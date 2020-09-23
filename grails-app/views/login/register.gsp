<%--
  Created by IntelliJ IDEA.
  User: saurabhjain
  Date: 19/08/20
  Time: 20:26
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main-non-mobile">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.3/themes/hot-sneaks/jquery-ui.css" />
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
    <title>Registration</title>
</head>

<body>
<script>
    $(document).ready(function() {
        $("#tooltipSpan").tooltip();

        $("#tooltipImg").mouseover(function() {
            $("#tooltipSpan").tooltip("open");
        });
    });

</script>
<div style="margin-left: 30px">
    <g:form>
        <br>
        <h3> <g:message code="com.jukin.registration.fill.fields"/> </h3>
        <br>
        <label> <g:message code="com.jukin.registration.page.email.field"/> </label>
        <g:textField name="reg.email" value="${flash.email}"/>
        <br>
        <br>
        <label> <g:message code="com.jukin.registration.page.password.field"/> </label>
        <g:passwordField name="reg.password"/>
        <g:img id="tooltipImg" file="question_mark.png" style="width: 15px" />
        <span id="tooltipSpan" title="Password must be at least 8 characters, contain Upper and Lower case letters, at least 1 number and one of these symbols: !@#$%^&*()+=_-<>?,./;:[]{}|~">
        </span>
        <br>
        <br>
        <label> <g:message code="com.jukin.registration.page.confirm.password.field"/> </label>
        <g:passwordField name="reg.confirmPassword"/>
        <br>
        <br>

        <g:if test="${flash.message}">
            <div id="failedMessage" style="font-size: small; color: #cc0000">
                ${flash.message}
            </div>
        </g:if>
        <br>
        <g:actionSubmit value="Submit" action="doRegister"/>
        <g:actionSubmit value="Back to Login" action="index"/>
        <br>
    </g:form>
</div>
</body>
</html>