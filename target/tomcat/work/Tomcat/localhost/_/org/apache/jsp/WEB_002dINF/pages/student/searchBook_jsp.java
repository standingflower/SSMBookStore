/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-05-29 14:20:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class searchBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>检索书籍</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tmargin: 0px;\r\n");
      out.write("\t\tbackground-color:#b3e5fc;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.header {\r\n");
      out.write("\t\tmargin: 0px auto;\r\n");
      out.write("\t\tmargin-top: 25px;\r\n");
      out.write("\t\twidth: 840px;\r\n");
      out.write("\t\theight: 110px;\r\n");
      out.write("\t\tpadding-left: 45px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.main {\r\n");
      out.write("\t\tmargin: 0px auto;\r\n");
      out.write("\t\twidth: 840px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.book_logo {\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tfont-family: 华文楷体;\r\n");
      out.write("\t\tfont-size: 45px;\r\n");
      out.write("\t\tpadding-left: 105px;\r\n");
      out.write("\t\tpadding-top: 25px;\r\n");
      out.write("\t\tline-height: 100px;\r\n");
      out.write("\t\tcolor: #2979ff;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login {\r\n");
      out.write("\t\tmargin-top: 75px;\r\n");
      out.write("\t\tmargin-right: 35px;\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t\tfont-size: 20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.navi {\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t\tmargin: 0px auto;\r\n");
      out.write("\t\twidth: 840px;\r\n");
      out.write("\t\tborder: 1px solid #b3e5fc;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.bod{\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t\tmargin: 100px auto;\r\n");
      out.write("\t\tpadding-top:30px;\r\n");
      out.write("\t\twidth: 240px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tbackground-color:#00b0ff;\r\n");
      out.write("\t\tbox-shadow: 0px 0px 20px white;\r\n");
      out.write("\t\tborder-radius:20px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdt{\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\twidth:33%;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tbackground-color:#4999ff; \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdt a{\r\n");
      out.write("\t\tdisplay: block;\r\n");
      out.write("\t\ttext-decoration: none;\r\n");
      out.write("\t\tfont-size: 20px;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tdt a:hover{\r\n");
      out.write("\t\tbackground-color:#b3e5fc;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t.sele {\r\n");
      out.write("\t\tclear: both;\r\n");
      out.write("\t\tpadding-left: 22px;\r\n");
      out.write("\t\tmargin-top: 40px;\r\n");
      out.write("\t\tmargin-bottom: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.foot {\r\n");
      out.write("\t\twidth: 55%;\r\n");
      out.write("\t\tmargin: 0px auto;\r\n");
      out.write("\t\tmargin-top: 45px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tcolor: #757575;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div style=\"float: left;\">\r\n");
      out.write("\t\t\t<img src=\"file/img/webimg/book_logo.png\" width=\"150px\" height=\"120px\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"book_logo\">图书管理系统</div>\r\n");
      out.write("\t\t<div class=\"login\">\t\r\n");
      out.write("\t\t\t<!-- \r\n");
      out.write("\t\t\t\ttest不能使用EL表达式\r\n");
      out.write("\t\t\t -->\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"main\">\r\n");
      out.write("\t\t<div class=\"navi\">\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dt><a href=\"book_findbook\" style=\"display: block;\">热门推荐</a></dt>\r\n");
      out.write("\t\t\t\t<dt><a href=\"book_search\" >文献查找</a></dt>\r\n");
      out.write("\t\t\t\t<dt><a href=\"bookuser_selectRecordByUserId\">我的图书</a></dt>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"bod\">\r\n");
      out.write("\t\t\t<form action=\"book_selectBookBySearch\" method=\"post\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"value\"> <br>\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"type\" value=\"book_name\">书名&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"type\" value=\"book_author\">作者&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"type\" value=\"book_publih\">出版社&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"检索\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"margin-top:150px;text-align:center;\">\r\n");
      out.write("\t\t图书管理系统©版本1.0\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/pages/student/searchBook.jsp(109,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.user}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<a href=\"login.jsp\">登录</a>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t欢迎<span style=\"color:red;\">\r\n");
        out.write("\t\t\t\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.userName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\r\n");
        out.write("\t\t\t\t\t</span>的登录\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
