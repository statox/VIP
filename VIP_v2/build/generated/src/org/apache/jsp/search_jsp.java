package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;
import com.sun.faces.*;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    // Being signed in is mandatory.
    // Thus, make sure the user loged in :
    Boolean connected = (Boolean) session.getAttribute( "registered");
    if (!connected) {
        session.setAttribute("signingInError", "Please login to access the list of VIPs.");
        response.sendRedirect("index.jsp");
    }

      out.write('\n');
      out.write('\n');

    // Connect to database
    String URL = "jdbc:derby://localhost:1527/VIP";
    String USER = "efrei";
    String PASS = "efrei";
    Connection conn = DriverManager.getConnection(URL, USER, PASS);
    Statement stmt = conn.createStatement();

      out.write("\n");
      out.write("\n");
      out.write("\n");

    // TODO : Handle research criteria (~ LIKE nameSearched)
    int quantity = 0;
    ResultSet rs = stmt.executeQuery("select * from UTILISATEUR");
    while (rs.next()) {
       String rsLogin  = rs.getString("LOGIN");
       String rsMdp  = rs.getString("MDP");
       quantity++;
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>VIP - Search</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>VIP - Search</h1>\n");
      out.write("        <p>There are ");
      out.print( quantity );
      out.write(" VIPs.</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table style=\"width:100%\">\n");
      out.write("            <tr>\n");
      out.write("                <th>VIP's ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Firstname</th>\n");
      out.write("                <th>Phone</th>\n");
      out.write("                <th>Mobile Phone</th>\n");
      out.write("                <th>Street</th>\n");
      out.write("                <th>ZIP code</th>\n");
      out.write("                <th>City</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Eve</td>\n");
      out.write("                <td>Jackson</td>\n");
      out.write("                <td>94</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
