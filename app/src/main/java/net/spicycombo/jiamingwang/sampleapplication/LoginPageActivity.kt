package net.spicycombo.jiamingwang.sampleapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    companion object {
        // the values to send in intents are EXTRAS
        // the format for naming keys: EXTRA_...

        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    val startRegistrationForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    )
    {
        result: ActivityResult ->
        // contains both the status and data...
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // handle the Intent to do whatever we need with the returned info
            binding.editTextUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }
    }

    override fun onCreate(previousState : Bundle?) {
        super.onCreate(previousState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.loginToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title = "Login" // getString(R.string.myinfo_title)

        binding.signupButton.setOnClickListener() {
            openSignUp()
        }
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) { finish() }

        return super.onOptionsItemSelected(item)
    }

    fun openSignUp() {
        val intent = Intent(baseContext, SignUpPageActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
        // I took 3 minutes to realize I have to add .java after... :CCCC
        startRegistrationForResult.launch(intent)
    }
}