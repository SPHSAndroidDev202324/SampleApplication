package net.spicycombo.jiamingwang.sampleapplication
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
        ).isFalse()

        assertThat(
            RegistrationUtil.validateUsername()
        )
    }

    @Test
    fun validateEmail() {
        assertThat(
            RegistrationUtil.validateEmail("me@example.com")
        ).isTrue()

        assertThat(
            RegistrationUtil.validateEmail("me.test.example.com")
        ).isFalse()

        assertThat(
            RegistrationUtil.validateEmail("m!e@example.c#m")
        ).isTrue()

        assertThat(
            RegistrationUtil.validateEmail("me@multiple.subdomain.example.com")
        ).isTrue()
    }

    @Test
    fun validatePassword() {
        val good1 = RegistrationUtil.validatePassword("A2sdfserieujt", "testtest") // some hard password
        assertThat(good1).isTrue()
    }



    // when done with all the unit tests & registration util functions (and they are successful),
    // implement the validation in your RegistrationActivity. don't let them registrewr if anything
    // is not valid. bonus: tell them what is wrong in a toast
}