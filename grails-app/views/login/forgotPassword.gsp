<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <asset:javascript src="bootstrap.js" />
    <asset:stylesheet src="bootstrap.css" />
    <title>Forgot Password</title>

    <style>
        #forgotPasswordButton {
            border: 1px solid gray;
            padding: 5px;
            cursor: default;
            text-decoration: none;
            color: gray;
        }

        a:hover {
            color: #48802c;
        }

        .changeFont {
            font-family: monospace;
        }
    </style>
</head>

<body>
<script>
    $(document).ready(function() {

        // Render differently for firefox
        let userAgent = navigator.userAgent;
        if (userAgent.match('Firefox')) {
            $("#formDiv").addClass('changeFont');
        }

        $('input[name="fp.email"]').blur(function () {
            forgotPasswordFn(false);
        });
    });

    function forgotPasswordFn(showModal) {
        let email = $('input[name="fp.email"]').val();
        $.ajax({
            url: "${resource()}"+"/login/doForgotPasswordAjax",
            data: {email: email}
        })
        .done (function (data) {

            // Clear the failure msg
            $("#flashMsg").html("");

            // Launch success modal windows
            if (showModal) {
                $("#fpSuccessModal").modal({
                    keyboard: false,
                    backdrop: 'static'
                });
            }
        })
        .fail (function (data) {
            $("#flashMsg").html(data.responseText);
        });
    }

    function closeFpSuccessModalFn() {
        $("#fpSuccessModal").modal('hide');
    }
</script>

<div id="formDiv" style="margin-left: 30px;">
    <g:form>
        <br>
        <label> <g:message code="com.jukin.forgot.password.page.email.field"/> </label>
        <g:textField name="fp.email" />
        <br>
        <div id="flashMsg" style="font-size: small; color: #cc0000">
            ${flash.enterValidEmail}
        </div>
        <br>
        <br>
        <a id="forgotPasswordButton" href="#" onclick="forgotPasswordFn(true)">Submit</a>
        <br>
        <br>
        <g:link action="register">
            <g:message code="com.jukin.forgot.password.page.back.to.login"/>
        </g:link>
    </g:form>
</div>

<!-- Modal -->
<div class="modal fade" id="fpSuccessModal" tabindex="-1" role="dialog" aria-labelledby="fpSuccessModalLabel" aria-hidden="true">
    <div style="height: 40px;" onclick="closeFpSuccessModalFn()" >
    </div>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="fpSuccessModalLabel">Password reset successfully</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <g:message code="com.jukin.forgot.password.success"/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal"> Ok </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>