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
    private var _binding: ActivityRegisterBinding? = null

    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRegisterBinding.inflate(layoutInflater, binding.root, false)
        val root: View = binding.root
        setContentView(root)

        //get connected Firebase
        val auth = FirebaseAuth.getInstance()

        val email: String = binding.etEmail.text.toString()
        val password: String = binding.etPassword.text.toString()
        val confirm_password = binding.etConfirmPassword.text.toString()

        binding.btnRegister.setOnClickListener(View.OnClickListener {
            if(email.isNotEmpty() && password.isNotEmpty() && confirm_password.isNotEmpty()) {
                if (password == confirm_password) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this, "Account Registration Successfull", Toast.LENGTH_LONG).show()
                            val loginIntent = Intent(this, LoginActivity::class.java)
                            startActivity(loginIntent)
                            finish()
                        }else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "confrim password is not matched with password \nPlease fill the matched confirmpassword", Toast.LENGTH_LONG).show()
                }
            }else {
                Toast.makeText(this, "Please fill the empty fields !!", Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun confirm_password() {
    }


}

fun getData(){

}