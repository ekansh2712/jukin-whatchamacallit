package whatchamacallit

import grails.validation.Validateable

class LoginController {

    def validUsernames = ["quality@jukinmedia.com", "quality@jukinmedia", "quality@jukinmedia.",
                          "quality", "jukinmedia", "jukinmedia.com"]
    String validPassword = "Test1ng"

    def EMAIL_REGEX = "^([a-zA-Z0-9])(([\\-.]|[_]+)?([a-zA-Z0-9]+))*(@){1}[a-z0-9]+[.]{1}(([a-z]{2,3})|([a-z]{2,3}[.]{1}[a-z]{2,3}))\$"

    def index() {
        render(view: "loginPage")
    }

    def doLogin(UserCredentials creds) {
        boolean loginFailed = false

        if (validUsernames.contains(creds.username)) {
            if (creds.password != validPassword) {
                flash.invalidPassword = message(code: "com.jukin.incorrect.password")
                loginFailed = true
            }
        } else {
            flash.invalidUsernameAndPassword = message(code: "com.jukin.incorrect.email.and.password")
            loginFailed = true
        }

        loginFailed ? redirect(action: index()) : render(view: "loginSuccess")
    }

    def forgotPassword() {}

    def doForgotPasswordAjax(ForgotPassword fp) {
        if (fp.hasErrors()) {
            render(status: 400, text: message(code: "com.jukin.valid.email.failed"))
        } else {
            render(status: 200, text: "")
        }
    }

    def register() {}

    def doRegister(RegisterUser reg) {
        boolean registrationFailed = false

        // If validation fails for any field, fail the registration
        if (reg.hasErrors()) {
            flash.message = message(code: "com.jukin.registration.failed.fields.missing")
            registrationFailed = true
        }

        // If email is already in use, fail the registration
        if (validUsernames.contains(reg.email)) {
            flash.message = message(code: "com.jukin.registration.failed.email.unavailable")
            registrationFailed = true

            // Match email with EMAIL_REGEX for validation
        } else if (!reg.email.matches(EMAIL_REGEX)) {
            flash.message = message(code: "com.jukin.registration.failed.email.invalid")
            registrationFailed = true
        }

        // If password do not matches, fail the registration
        if (reg.password != reg.confirmPassword) {
            flash.email = reg.email     // retain the email and display on register failure page.
            flash.message = message(code: "com.jukin.registration.failed.password.mismatch")
            registrationFailed = true
        }

        registrationFailed ? redirect(action: "register") : render(view: "registerSuccess")
    }
}

/*
    Command Object to be used during login.
    Need to add validateable otherwise it wont allow the usage of hasErrors.
 */
@Validateable
class UserCredentials {
    String username
    String password

    static constraints = {
        username nullable: false, blank: false
        password nullable: false, blank: true
    }
}

// Command object to be used during register.
@Validateable
class RegisterUser {
    String email
    String password
    String confirmPassword

    static constraints = {
        email nullable: false, blank: false
        password nullable: false, blank: false
        confirmPassword nullable: false, blank: false
    }
}

// Command object to be used during forgot password.
@Validateable
class ForgotPassword {
    String email

    static constraints = {
        email nullable: false, blank: true, email: true
    }
}
