package net.spicycombo.jiamingwang.sampleapplication

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentSanitizer
import androidx.core.view.KeyEventDispatcher.Component
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private val TAG = "LoginPageActivity"

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

        binding.loginButton.setOnClickListener() {
            val username = binding.editTextUsername.text.toString()
            if (username.isNotEmpty()) {
                val result = Intent()
                result.putExtra(EXTRA_USERNAME, username)
                Log.i(TAG, "User " + intent.getStringExtra(EXTRA_USERNAME))

                setResult(Activity.RESULT_OK, result)
                finish()
            }
            else Toast.makeText(this, "Username cannot be empty.", Toast.LENGTH_SHORT).show()
        }

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