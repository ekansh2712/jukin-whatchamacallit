<%--
  Created by IntelliJ IDEA.
  User: saurabhjain
  Date: 19/08/20
  Time: 19:38
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title>Login Page</title>

    <style>
        #loginButton:hover {
            cursor: not-allowed;
        }
    </style>
</head>

<body>
<script>
    $(document).ready(function() {
        $("#username").blur(function () {
            if ($("#username").val() != '') {
                $("#loginButton").prop("disabled", false);
            } else {
                $("#loginButton").prop("disabled", true);
            }
        });
    });
</script>
<div style="text-align: center">
    <g:form>
        <br>
        <h3> <g:message code="com.jukin.login.fill.fields"/> </h3>
        <br>
        <label>Username: </label>
        <g:textField id="username" name="creds.username"/>
        <br>
        <br>
        <label>Password: </label>
        <g:passwordField name="creds.password"/>
        <br>
        <br>

        <g:if test="${flash.invalidPassword}">
            <div id="invalidPassword" style="font-size: small; color: #cc0000">
                ${flash.invalidPassword}
            </div>
        </g:if>
        <g:if test="${flash.invalidUsernameAndPassword}">
            <div style="font-size: small; color: #cc0000">
                ${flash.invalidUsernameAndPassword}
            </div>
        </g:if>
        <br>
        <g:actionSubmit id="loginButton" value="Login" action="doLogin" disabled="true"/>
        <br>
        <br>
        <g:link action="forgotPassword"> <g:message code="com.jukin.login.forgot.password.link"/> </g:link>
        <br>
        <br>
        <g:link action="register"> <g:message code="com.jukin.login.register.link"/> </g:link>
    </g:form>
</div>
</body>
</html>