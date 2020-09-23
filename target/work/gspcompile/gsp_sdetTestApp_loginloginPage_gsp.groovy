import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sdetTestApp_loginloginPage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/loginPage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',33,['code':("com.jukin.login.fill.fields")],-1)
printHtmlPart(7)
invokeTag('textField','g',38,['id':("username"),'name':("creds.username")],-1)
printHtmlPart(8)
invokeTag('passwordField','g',41,['name':("creds.password")],-1)
printHtmlPart(9)
if(true && (flash.invalidPassword)) {
printHtmlPart(10)
expressionOut.print(flash.invalidPassword)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (flash.invalidUsernameAndPassword)) {
printHtmlPart(13)
expressionOut.print(flash.invalidUsernameAndPassword)
printHtmlPart(11)
}
printHtmlPart(14)
invokeTag('actionSubmit','g',58,['id':("loginButton"),'value':("Login"),'action':("doLogin"),'disabled':("true")],-1)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',61,['code':("com.jukin.login.forgot.password.link")],-1)
printHtmlPart(16)
})
invokeTag('link','g',61,['action':("forgotPassword")],3)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
invokeTag('message','g',63,['code':("com.jukin.login.register.link")],-1)
printHtmlPart(16)
})
invokeTag('link','g',64,['action':("register")],3)
printHtmlPart(2)
})
invokeTag('form','g',64,[:],2)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',64,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1598539706000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
