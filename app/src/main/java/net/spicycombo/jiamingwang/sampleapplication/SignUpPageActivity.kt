package net.spicycombo.jiamingwang.sampleapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityLoginPageBinding
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivitySignupPageBinding

class SignUpPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupPageBinding

    override fun onCreate(previousState : Bundle?) {
        super.onCreate(previousState)
        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.signupToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title = "Signup" // getString(R.string.myinfo_title)

        binding.signupButtonConfirmReg.setOnClickListener() {
            // extract data
            val password = binding.signupEditTextPassword.text.toString()
            val confirm = binding.signupEditTextConfirmPass.text.toString()
            val username = binding.signupEditTextUsername.text.toString()
            val email = binding.signupEditTextEmail.text.toString()

            RegistrationUtil.validateUsername(username)
            RegistrationUtil.validatePassword(password, confirm)
            RegistrationUtil.validateEmail(email)

            // TODO: do some server side things

            val resultIntent = Intent().apply {
                putExtra(LoginPageActivity.EXTRA_USERNAME, username)
                putExtra(LoginPageActivity.EXTRA_PASSWORD, password)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}