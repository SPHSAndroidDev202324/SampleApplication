package net.spicycombo.jiamingwang.sampleapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.spicycombo.jiamingwang.sampleapplication.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(previousState : Bundle?) {
        super.onCreate(previousState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}