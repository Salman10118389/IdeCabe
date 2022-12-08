package com.example.idecabe.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.withStarted
import com.example.idecabe.R
import com.example.idecabe.databinding.ActivityRegisterBinding
import com.example.idecabe.ui.auth.LoginActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get connected Firebase
        val auth = FirebaseAuth.getInstance()



        binding.btnRegister.setOnClickListener({
            val fullname: String = binding.etFullname.text.toString()
            val email: String = binding.etEmail.text.toString()
            val password: String = binding.etPassword.text.toString()
            val confirm_password = binding.etConfirmPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirm_password.isNotEmpty() && fullname.isNotEmpty()) {
                if (password == confirm_password) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                this,
                                "Account Registration Successfull",
                                Toast.LENGTH_LONG
                            ).show()
                            val loginIntent = Intent(this, LoginActivity::class.java)
                            startActivity(loginIntent)
                            finish()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(
                        this,
                        "confrim password is not matched with password \nPlease fill the matched confirmpassword",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(this, "Please fill the empty fields !!", Toast.LENGTH_SHORT).show()
            }
        })

        binding.tvLogin.setOnClickListener({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}
