package net.spicycombo.jiamingwang.sampleapplication

import android.health.connect.datatypes.RespiratoryRateRecord
import android.util.Log

class RegistrationUtil {
    enum class ResponseType {
        PASS,

        USERNAME_NOT_VALID, USERNAME_TAKEN,

        PASSWORD_LENGTH, PASSWORD_NO_NUMBER, PASSWORD_NO_UPPER, PASSWORD_NO_LOWER,
        PASSWORD_SPECIAL, PASSWORD_NOT_MATCHED, PASSWORD_PROHIBITED_CHAR,

        EMAIL_INVALID
    }

    companion object {
        // use this in the test class for the is username taken test
        // make another similar list for some taken emails
        var existingUsers = listOf("test")
        // you can use listOf<type>() instead of making the list & adding individual
        // List<String> blah...

        fun isExistingUser(username: String) : Boolean {
            return existingUsers.contains(username)
        }

        // isn't empty
        // not already taken
        // minimum number of characters is 3

        fun validateUsername(username: String) : ResponseType {
            if (!isAlphanumeric(username)) return ResponseType.USERNAME_NOT_VALID
            if (isExistingUser(username)) return ResponseType.USERNAME_TAKEN
            return ResponseType.PASS
        }

        // Not empty
        // Minimum 16 characters, maximum of 128 characters
        // At least contains numbers,
        //  lower and capitalized characters,
        //  and 3 special characters !@#$%*

        //.*[A-Za-z].*   check for the presence of at least one letter
        //.*[0-9].*      check for the presence of at least one number
        //[A-Za-z0-9]*   check that only numbers and letters compose this string

        fun validatePassword(password: String, confirm: String) : ResponseType {
            if (password.length < 16 || password.length > 128) ResponseType.PASSWORD_LENGTH
            if (!password.matches(".*[A-Z].*".toRegex())) return ResponseType.PASSWORD_NO_UPPER
            if (!password.matches(".*[a-z].*".toRegex())) return ResponseType.PASSWORD_NO_LOWER
            if (!password.matches(".*[0-9].*".toRegex())) return ResponseType.PASSWORD_NO_NUMBER
            if (3 > password.count {
                "!#$%&'()*+,./:;<=>?@\\^_`{|}~-".contains(it)
            }) return ResponseType.PASSWORD_SPECIAL
            if (!password.matches(
                    "[A-Za-z0-9!#$%&'()*+,./:;<=>?@\\\\^_`{|}~-]*".toRegex())
                ) return ResponseType.PASSWORD_PROHIBITED_CHAR
            if (password != confirm) return ResponseType.PASSWORD_NOT_MATCHED
            return ResponseType.PASS
        }

        // you@example.net

        fun validateEmail(email: String) : ResponseType {
            val ats = email.count { it == '@' }
            if (ats != 1) return ResponseType.EMAIL_INVALID// println("ats")
            val sections = email.split('@')
            val subdomainChunks = sections[1].split('.')
            // to check for the hyphens that would be the start or end of a subdomain
            if (sections[0].matches("^-+".toRegex()) || sections[1].matches("^-+".toRegex()) ||
                sections[1].matches("-+[.]]".toRegex()) ||
                sections[1].matches("[.]-+".toRegex())) ResponseType.EMAIL_INVALID //println("regex")
            if (!email.matches("[A-Za-z0-9._@-]*".toRegex())) ResponseType.EMAIL_INVALID //println("regex2")
            if (2 > subdomainChunks.count()) println("chunks count")
            if (2 > subdomainChunks[subdomainChunks.size - 1].length) ResponseType.EMAIL_INVALID //println("domaintext")
            return ResponseType.PASS // TODO: Implement
        }

        // https://stackoverflow.com/questions/43977420/check-if-a-string-is-alphanumeric
        // prolly good to read an entire article on regex expressions. I know they exist,
        // but don't know enough to use them properly or implement them

        //.*[A-Za-z].*   check for the presence of at least one letter
        //.*[0-9].*      check for the presence of at least one number
        //[A-Za-z0-9]*   check that only numbers and letters compose this string

        // if is Alphanumeric with _ character.
        private fun isAlphanumeric(text : String) : Boolean {
            return text.matches(".*[A-Za-z].*".toRegex())
                    && text.matches("[A-Za-z0-9]*".toRegex())
        }
    }

}