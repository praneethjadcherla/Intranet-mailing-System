package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".first{color:#990000;text-align:center;background:yellow;float:left}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<center><h1> hi...");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" !</h1></center>\n");
      out.write("<div class=\"first\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<body bgcolor=\"#E6F3FF\">\n");
      out.write("\n");
      out.write("<table width=\"100%\" border=\"10\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("   <td width=\"200\"><a href=\"compose.html\">ComposeMail</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td width=\"200\"><a href=\"inbox.html\">Inbox</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td width=\"200\"><a href=\"sentitems.html\" target=\"f4\">SentItems</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td width=\"200\"><a href=\"contacts.html\" target=\"f4\">Contacts</td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td width=\"200\"><a href=\"logout.html\" target=\"f4\">LogOut</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
