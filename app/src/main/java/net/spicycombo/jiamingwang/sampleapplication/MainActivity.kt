package net.spicycombo.jiamingwang.sampleapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding : ActivityMainBinding

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val prevIntent = result.data
            if (prevIntent == null) Log.i(TAG, "No result from LoginPageActivity available.")
            val user = prevIntent?.getStringExtra(LoginPageActivity.EXTRA_USERNAME)
            Log.i(TAG, "Logged in as user " + user + "!")
            Toast.makeText(
                this,
                "Logged in as " + user +  ".",
                Toast.LENGTH_SHORT
            ).show()
        } else if (result.resultCode == Activity.RESULT_CANCELED) {
            Log.i(TAG, "Login canceled")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        //https://developer.android.com/develop/ui/views/components/appbar/setting-up
        //https://developer.android.com/develop/ui/views/touch-and-input/keyboard-input/style
        //https://stackoverflow.com/questions/10978038/restrict-edittext-to-single-line

        binding.loginButton.setOnClickListener() {
            openLogin()
        }
    }

    private fun openLogin() {
        val intent = Intent(baseContext, LoginPageActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
        startForResult.launch(intent)
        // I took 3 minutes to realize I have to add .java after... :CCCC
        //startActivity(intent)
    }
}