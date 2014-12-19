package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import VIP.Person;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>VIP - Search</title>\n");
      out.write("        <style>\n");
      out.write("            table, th, td {\n");
      out.write("                border: 1px solid black;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("            th,td {\n");
      out.write("                padding: 15px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>VIP - Search</h1>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <center>\n");
      out.write("            <form action=\"Controleur\" method=\"POST\">\n");
      out.write("                <label for=\"filter\">Person</label>\n");
      out.write("                <input type=\"text\" name=\"filter\" id=\"filter\" placeholder=\"filter: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${filter}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"requestedPage\" value=\"search\">\n");
      out.write("                <input type=\"submit\" value=\"Search\">\n");
      out.write("            </form>\n");
      out.write("        </center>\n");
      out.write("            \n");
      out.write("    \n");
      out.write("        </br>\n");
      out.write("        <form action=\"Controleur\" method=\"POST\">\n");
      out.write("            <table style=\"width:100%\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>VIP's ID</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>First Name</th>\n");
      out.write("                    <th>Home Phone</th>\n");
      out.write("                    <th>Mobile Phone</th>\n");
      out.write("                    <th>Professional Phone</th>\n");
      out.write("                    <th>Street</th>\n");
      out.write("                    <th>ZIP code</th>\n");
      out.write("                    <th>City</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </table>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <center>\n");
      out.write("                <p style=\"color:blue;\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${quantity == 0 && (filter == null || filter.isEmpty()) ? \"The club needs VIPs !\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </p>\n");
      out.write("                <p style=\"color:red;\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${quantity == 0 && filter != null && !filter.isEmpty() ? \"No result.\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </p>                \n");
      out.write("                <p style=\"color:green;\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deletion && successfullyDeleted ? \"Successfully deleted VIP !\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </p>                \n");
      out.write("                <p style=\"color:red;\">\n");
      out.write("                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deletion && !successfullyDeleted ? \"Error while trying to delete VIP !\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                </p>\n");
      out.write("            </center>\n");
      out.write("\n");
      out.write("            <center>\n");
      out.write("                <input type=\"submit\" value=\"details\" name=\"requestedPage\" >\n");
      out.write("                <input type=\"submit\" value=\"delete\" name=\"requestedPage\" >\n");
      out.write("            </center>\n");
      out.write("        </form>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIPs}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("VIP");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    <tr>\n");
          out.write("                        <th><input type=\"radio\" name=\"ID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" required></th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getPrenom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getTelDom()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getTelPerso()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getTelPro()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getAddress()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getZipCode()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getCity()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                        <th>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${VIP.getEmail()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</th>\n");
          out.write("                    </tr>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
