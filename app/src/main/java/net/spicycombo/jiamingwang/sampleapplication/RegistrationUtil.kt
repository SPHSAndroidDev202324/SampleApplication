package net.spicycombo.jiamingwang.sampleapplication

class RegistrationUtil {
    companion object {
        // use this in the test class for the is username taken test
        // make another similar list for some taken emails
        var existingUsers = listOf("MrMills")
        // you can use listOf<type>() instead of making the list & adding individual
        // List<String> blah...

        fun isExistingUser(user : String) : Boolean {
            return existingUsers.contains(user)
        }

        // isn't empty
        // not already taken
        // minimum number of characters is 3, max 16
        // Alphanumeric, with _

        fun validateUsername(username: String) : Boolean {
            if (isExistingUser(username)) return false
            if (3 > username.length || username.length > 16) return false
            if (!username.contains("[A-Za-z0-9_]".toRegex())) return false


            return true
            // TODO: Implement
        }

        // Not empty
        // Minimum 16 characters, maximum of 128 characters
        // At least contains numbers,
        //  lower and capitalized characters,
        //  special characters !@#$%*
        //
        fun validatePassword(password: String, confirm: String) : Boolean {
            if (!password.contains("[\\x21-\\x7E]\n".toRegex())) return false
            // all alphanumeric, and non-chinese characters
            if (password != confirm) return false
            return true
            // TODO: Implement
        }

        // you@example.net

        fun validateEmail(email: String) : Boolean {
            return false
            // TODO: Implement
        }
    }

}