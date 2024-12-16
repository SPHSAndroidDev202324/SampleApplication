package net.spicycombo.jiamingwang.sampleapplication

class RegistrationUtil {
    companion object {
        // use this in the test class for the is username taken test
        // make another similar list for some taken emails
        var existingUsers = listOf("test")
        // you can use listOf<type>() instead of making the list & adding individual
        // List<String> blah...

        // Can check against a database for if the username already exists
        fun isExistingUser(username : String) : Boolean {
            return existingUsers.contains(username)
        }

        // isn't empty
        // not already taken
        // minimum number of characters is 3

        fun validateUsername(username: String) : Boolean {
            if (isExistingUser(username)) return false
            // do other things here too!
            return false
            // TODO: Implement
        }

        // Not empty
        // Minimum 16 characters, maximum of 128 characters
        // At least contains 3 numerical digit,
        //  lower and capitalized characters,
        //  special characters !@#$%*
        //
        fun validatePassword(password: String, confirm: String) : Boolean {
            if (password.isNullOrEmpty() || password.length < 16 || password.length > 128) return false
            if (password.count { it.isDigit() } < 3) return false
            if (password.count { it.isUpperCase() } < 1) return false
            if (password.count { it.isLowerCase() } < 1) return false
            // if (password.count { it == '!' })
            return false
            // TODO: Implement
        }

        // min 3, max 6
        // Numbers
        fun validateUserName(username: String) : Boolean {
            return false
            // TODO: Implement
        }

        // you@example.net

        fun validateEmail(email: String) : Boolean {
            return false
            // TODO: Implement
        }
    }

}