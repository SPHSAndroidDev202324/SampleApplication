package net.spicycombo.jiamingwang.sampleapplication

class RegistrationUtil {
    // use this in the test class for the is username taken test
    // make another similar list for some taken emails
    var existingUsers = listOf("test")
    // you can use listOf<type>() instead of making the list & adding individual
    // List<String> blah...

    // isn't empty
    // not already taken
    // minimum number of characters is 3

    fun validateUsername(username : String) {

    }

    // Not empty
    // Minimum 16 characters, maximum of 128 characters
    // At least contains numbers,
    //  lower and capitalized characters,
    //  special characters !@#$%*
    //
    fun validatePassword(password : String, confirm : String) {

    }

    // min 3, max 6
    // Numbers
    fun validateUserName(username : String) {

    }

    // you@example.net

    fun validateEmail(email : String) {

    }


}