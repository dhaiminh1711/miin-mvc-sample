package miin.learning

import android.text.TextUtils
import android.util.Patterns

class User {
    var email: String? = null
    var password: String? = null

    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmail(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return !TextUtils.isEmpty(password) && password.length >= PASSWORD_LENGTH_LIMIT
    }

    companion object {
        const val PASSWORD_LENGTH_LIMIT = 6
    }
}
