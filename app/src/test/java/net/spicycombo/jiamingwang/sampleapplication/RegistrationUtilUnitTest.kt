package net.spicycombo.jiamingwang.sampleapplication
import androidx.core.content.ContextCompat.RegisterReceiverFlags
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilUnitTest {
    // make tests for password failures of:
        // min lenghth of 8 (make sure it has a capital letter and a number
        // at least one digit (make sure it is at least 8 letters long & hase a capitol
        // at least one capitol letter (make sure it has... (you figure this out))
    // add more good matching password eges cases and maybe a coiple comfortably passing ones
    // make the tests for other functions in the Util class with the commo nafilures
    // and one success for each

    @Test
    fun validateUsername() {
        assertThat(
            RegistrationUtil.validateUsername("MrMills")
        ).isEqualTo(RegistrationUtil.ResponseType.PASS)

        assertThat(
            RegistrationUtil.validateUsername("M!r.Mills")
        ).isEqualTo(RegistrationUtil.ResponseType.USERNAME_NOT_VALID)
    }

    @Test
    fun validateEmail() {
        // TODO
        assertThat(
            RegistrationUtil.validateEmail("me@example.com")
        ).isEqualTo(RegistrationUtil.ResponseType.PASS)

        assertThat(
            RegistrationUtil.validateEmail("me.test.example.com")
        ).isEqualTo(RegistrationUtil.ResponseType.EMAIL_INVALID)

        assertThat(
            RegistrationUtil.validateEmail("m!e@example.c#m")
        ).isEqualTo(RegistrationUtil.ResponseType.EMAIL_INVALID)

        assertThat(
            RegistrationUtil.validateEmail("me@multiple.subdomain.example.com")
        ).isEqualTo(RegistrationUtil.ResponseType.PASS)

        assertThat(
            RegistrationUtil.validateEmail("me@---test.co")
        ).isEqualTo(RegistrationUtil.ResponseType.EMAIL_INVALID)
    }

    @Test
    fun validatePassword() {
        val good = RegistrationUtil.validatePassword("eLm5!aY8#c55^", "eLm5!aY8#c55^") // some hard password
        assertThat(good).isEqualTo(RegistrationUtil.ResponseType.PASS)

        // only chars
        val bad1 = RegistrationUtil.validatePassword("123456789q", "123456789q")
        // Will return RegistrationUtil.ResponseType.PASSWORD_NO_UPPER
        assertThat(bad1).isEqualTo(RegistrationUtil.ResponseType.PASSWORD_NO_UPPER)

        // No special characters, returns RegistrationUtil.ResponseType.PASSWORD_SPECIAL,
        // there needs to have more special characters
        val bad2 = RegistrationUtil.validatePassword("Jin1A87Un#", "Jin1A87Un#")
        assertThat(bad2).isEqualTo(RegistrationUtil.ResponseType.PASSWORD_SPECIAL)

        val bad3 = RegistrationUtil.validatePassword("19nf#!NAaj*额", "19nf#!NAaj*额")
        assertThat(bad3).isEqualTo(RegistrationUtil.ResponseType.PASSWORD_PROHIBITED_CHAR)
        //...and all is good!
    }



    // when done with all the unit tests & registration util functions (and they are successful),
    // implement the validation in your RegistrationActivity. don't let them registrewr if anything
    // is not valid. bonus: tell them what is wrong in a toast
}