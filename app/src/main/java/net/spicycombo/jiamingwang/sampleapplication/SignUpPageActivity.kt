package net.spicycombo.jiamingwang.sampleapplication

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

        setSupportActionBar(binding.toolbar4)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true);
        supportActionBar?.title = "Signup" // getString(R.string.myinfo_title)


    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) { finish() }

        return super.onOptionsItemSelected(item)
    }
}