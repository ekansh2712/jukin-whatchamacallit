import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sdetTestApp_loginforgotPassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/forgotPassword.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',5,['src':("bootstrap.js")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',6,['src':("bootstrap.css")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(resource())
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',75,['code':("com.jukin.forgot.password.page.email.field")],-1)
printHtmlPart(8)
invokeTag('textField','g',76,['name':("fp.email")],-1)
printHtmlPart(9)
expressionOut.print(flash.enterValidEmail)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('message','g',87,['code':("com.jukin.forgot.password.page.back.to.login")],-1)
printHtmlPart(12)
})
invokeTag('link','g',88,['action':("register")],3)
printHtmlPart(1)
})
invokeTag('form','g',89,[:],2)
printHtmlPart(13)
invokeTag('message','g',105,['code':("com.jukin.forgot.password.success")],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1598468849000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
