import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sdetTestApp_loginregister_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/register.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main-non-mobile")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',29,['code':("com.jukin.registration.fill.fields")],-1)
printHtmlPart(8)
invokeTag('message','g',31,['code':("com.jukin.registration.page.email.field")],-1)
printHtmlPart(9)
invokeTag('textField','g',33,['name':("reg.email"),'value':(flash.email)],-1)
printHtmlPart(10)
invokeTag('message','g',36,['code':("com.jukin.registration.page.password.field")],-1)
printHtmlPart(9)
invokeTag('passwordField','g',37,['name':("reg.password")],-1)
printHtmlPart(11)
invokeTag('img','g',38,['id':("tooltipImg"),'file':("question_mark.png"),'style':("width: 15px")],-1)
printHtmlPart(12)
invokeTag('message','g',43,['code':("com.jukin.registration.page.confirm.password.field")],-1)
printHtmlPart(9)
invokeTag('passwordField','g',44,['name':("reg.confirmPassword")],-1)
printHtmlPart(13)
if(true && (flash.message)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('actionSubmit','g',53,['value':("Submit"),'action':("doRegister")],-1)
printHtmlPart(11)
invokeTag('actionSubmit','g',55,['value':("Back to Login"),'action':("index")],-1)
printHtmlPart(17)
})
invokeTag('form','g',55,[:],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',56,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1598389955000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
