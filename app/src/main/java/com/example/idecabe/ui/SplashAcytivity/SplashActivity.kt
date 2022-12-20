package com.example.idecabe.ui.SplashAcytivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.HandlerCompat
import androidx.core.os.postDelayed
import com.example.idecabe.BottomNavigationActivity
import com.example.idecabe.R
import com.example.idecabe.ui.register.RegisterActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed(
            {
                val intent = Intent(this@SplashActivity, BottomNavigationActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000
        )

    }
}