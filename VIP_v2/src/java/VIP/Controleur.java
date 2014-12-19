/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matthieudelaro
 */
public class Controleur extends HttpServlet {
    private Connection conn = null;
    private Statement stmt = null;
    private boolean successfullyInitialized = false;
    
    /**
     * Configures the servlet once and for all.
     * Connects to the data base.
     * In case an error occurs, it prints it in the console,
     * sets successfullyInitialized to false (so that
     * any user requesting a page will be routed to initError.html) (legacy feature),
     * and throws an exception.
     * 
     * @param config
     * @throws ServletException In case it could not connect to the database.
     */
    public void init (ServletConfig config) throws ServletException
    {
        super.init(config);
        String URL = "jdbc:derby://localhost:1527/VIP";
        String USER = "efrei";
        String PASS = "efrei";
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
            successfullyInitialized = true;
        } catch (SQLException ex) {
            successfullyInitialized = false;
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException("Could not connect to the database.");
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * 
     * Everything happens here. ProcessRequest() checks that the user is logged
     * in, and route the user to index.jsp with a warning message in case he is
     * not.
     * 
     * Depending on requestedPage parameter, processRequest calls 
     *  - handleDetails
     *  - handleSearch
     *  - handleLogin
     * to handle the request.
     * 
     * This parameter comes from the form on the webpage the request comes from.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (!successfullyInitialized) {
            request.getRequestDispatcher("initError.html").forward(request, response);
        }
        
        // initializes user's session
        HttpSession session = request.getSession();
        
        // tries to figure out what page the user wants to display
        String requestedPage = (String) request.getParameter("requestedPage");
        if (requestedPage == null) {
            requestedPage = "index";
        }
        
        // route the user to the page he requested
        if (requestedPage.equals("index")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        // Validate/unvalidate given login/password
        if (requestedPage.equals("connexion")) {
            requestedPage = handleLogin(request, session, response);
        }
        
        // Makes sure he is logged in to search/delete/display details
        Boolean connected = (Boolean) session.getAttribute( "registered");
        if (!requestedPage.equals("index") && (connected ==null || !connected)) {
            request.setAttribute("signingInError", "Incorrect login/password");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        // handles request for the search page, either to search or to delete VIPs
        if (requestedPage.equals("search") || requestedPage.equals("delete")) {
            handleSearch(request, session, response);
        }
        
        // handle request to show details about the VIP
        if (requestedPage.equals("details")) {
            handleDetails(request, response);
        }
        
        // in case the requested page is unknown
        request.getRequestDispatcher("unknownPage.html").forward(request, response);
    }
    
    /**
     * Handles request to display VIP's details
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void handleDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from UTILISATEUR where NOM='" + ID + "'");
            if (rs.next()) {
                Person vip = new Person(rs);
                request.setAttribute("myPerson", vip);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Could not find VIP " + ID);
                request.getRequestDispatcher("details.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Could not find VIP " + ID);
            request.getRequestDispatcher("details.jsp").forward(request, response);
        }
    }
    
    /**
     * Handles request to search for users and to display the list,
     * and to a delete user as well.
     * @param request
     * @param session
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    private void handleSearch(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        // Look for a the search filter in request or in session.
        // It filters users based on their family name.
        // If request.filter == "" : clear filter
        // If request.filter == null : try session.filter
        String filter = request.getParameter("filter");
        if (filter == null) {
            filter = (String) session.getAttribute("filter");
        } else if(filter.isEmpty()) {
            session.setAttribute("filter", null);
        }
        
        // Handles VIP's deletion
        // Delete the VIP whose Name is given in the ID parameter.
        String IdToDelete = request.getParameter("ID");
        boolean successfullyDeleted = false; // will be used to display an error message in case an error occurs while deleting the VIP
        boolean deletion = false;
        if (IdToDelete != null) {
            deletion = true;
            try {
                if (stmt.executeUpdate("DELETE from UTILISATEUR where NOM='" + IdToDelete + "'") == 1) {
                    successfullyDeleted = true;
                }
            } catch (SQLException ex) {
                //successfullyDeleted = false; // successfullyDeleted already equals false   
            }
        }
        request.setAttribute("successfullyDeleted", successfullyDeleted);
        request.setAttribute("deletion", deletion);
        
        // Load VIPs from database
        ResultSet rs = null;
        try {
            if (filter == null || filter.isEmpty()) {
                rs = stmt.executeQuery("select * from UTILISATEUR");
            } else {
                session.setAttribute("filter", filter);
                rs = stmt.executeQuery(
                        "select * from UTILISATEUR where NOM like '%"+filter+"%'");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("dbError.html").forward(request, response);
        }
        
        // Create a list of VIPs from the request
        int quantity = 0;
        List<Person> VIPs = new LinkedList();
        try {
            while (rs.next()) {
                VIPs.add(new Person(rs));
                quantity++;
            }
        } catch (SQLException ex) {}
        
        request.setAttribute("quantity", quantity);
        request.setAttribute("VIPs", VIPs);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
    
    /**
     * Handles login requests : Validates/rejects given login/password.
     * In case of success, forward to search.jsp
     * Otherwise, forward to index.jsp with error message
     * 
     * Stores login in session attributes.
     * 
     * @param request
     * @param session
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    private String handleLogin(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        session.setAttribute("login", login);
        
        boolean connected = false;
        ResultSet rs;
        try {
            rs = stmt.executeQuery("select * from IDENTIFIANT where LOGIN='" + login + "'");
            if (rs.next()) {
                String rsLogin = rs.getString("LOGIN");
                String rsMdp = rs.getString("MDP");
                if (login.equals(rsLogin) && password.equals(rsMdp)) {
                    connected = true;
                }
            }
        } catch (SQLException ex) {
            request.setAttribute("signingInError", "Unable to test login/password in database.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        session.setAttribute("registered", connected);
        if (connected) {
            forward = "search";
        } else {
            request.setAttribute("signingInError", "Incorrect login/password");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        return forward;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
