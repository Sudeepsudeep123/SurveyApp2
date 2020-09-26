package com.survey.project.application.utils

import android.util.Patterns
import com.survey.project.application.R
import com.survey.project.application.features.Signup.SignupView
import com.survey.project.application.features.login.LoginView
import com.survey.project.application.features.main.MainView

object FieldValidationUtils {
    fun signUpValidation(
        view: SignupView?,
        email: String?,
        username: String?,
        etPassword: String,
        etConfirmPassword: String,
        address: String
    ): Boolean {
        if (email.isNullOrEmpty()) {
            view?.showToast(R.string.error_email_empty)
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.showToast(R.string.error_email_invalid)
            return false
        }
        if (username.isNullOrEmpty()) {
            view?.showToast(R.string.error_username)
            return false
        }

        if (etPassword.isNullOrEmpty()) {
            view?.showToast(R.string.error_new_password_empty)
            return false
        }

        if (etConfirmPassword.isNullOrEmpty()) {
            view?.showToast(R.string.error_confirm_password_empty)
            return false
        }
        if (!etPassword.equals(etConfirmPassword)) {
            view?.showToast(R.string.password_mismatch)
            return false
        }
        if (address.isNullOrEmpty()) {
            view?.showToast(R.string.error_address_empty)
            return false
        }
        return true
    }

    fun loginValidation(
        view: LoginView?,
        username: String?,
        etPassword: String?
    ) : Boolean {
        if (username.isNullOrEmpty()) {
            view?.showToast(R.string.error_username)
            return false
        }

        if (etPassword.isNullOrEmpty()) {
            view?.showToast(R.string.error_new_password_empty)
            return false
        }
        return true

    }

    fun areaValidation(
        view: MainView?,
        provence: String?,
        zone: String?,
        district: String?
    ) : Boolean {
        if (provence.equals("Choose Provence")) {
            view?.showToast(R.string.error_username)
            return false
        }

        if (zone.equals("Choose Zone")) {
            view?.showToast(R.string.error_new_password_empty)
            return false
        }
        if (district.equals("Choose District")) {
            view?.showToast(R.string.error_new_password_empty)
            return false
        }
        return true

    }
}