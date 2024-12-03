package net.spicycombo.jiamingwang.sampleapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityLoginPageBinding
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //https://developer.android.com/develop/ui/views/components/appbar/setting-up
        //https://developer.android.com/develop/ui/views/touch-and-input/keyboard-input/style
        //https://stackoverflow.com/questions/10978038/restrict-edittext-to-single-line

        binding.loginButton.setOnClickListener() {
            openLogin()
        }
    }

    fun openLogin() {
        val intent = Intent(baseContext, LoginPageActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
        // I took 3 minutes to realize I have to add .java after... :CCCC
        startActivity(intent)
    }
}