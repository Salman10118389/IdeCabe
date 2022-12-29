package com.example.idecabe.core.sources.remote.repositories

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import com.example.idecabe.BottomNavigationActivity
import com.example.idecabe.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import com.inyongtisto.myhelper.extension.isNotNull
import org.checkerframework.common.subtyping.qual.Bottom

class AuthRepositoryImp {
    private lateinit var application: Application
    private lateinit var firebaseUserMutableLiveData: MutableLiveData<FirebaseUser>
    private lateinit var userLoggedMutableLiveDate: MutableLiveData<Boolean>
    private lateinit var auth: FirebaseAuth
//    val gson: Gson

    fun getFirebaseUserMutableLiveData(): MutableLiveData<FirebaseUser> {
        return firebaseUserMutableLiveData
    }

    fun getUserLoggedMutableLiveData(): MutableLiveData<Boolean> {
        return userLoggedMutableLiveDate
    }

    fun Authentication(application: Application){
        this.application = application
        firebaseUserMutableLiveData = MutableLiveData()
        userLoggedMutableLiveDate = MutableLiveData()
        auth = FirebaseAuth.getInstance()

        if(auth.currentUser.isNotNull()) {
            firebaseUserMutableLiveData.postValue(auth.currentUser)
            Toast.makeText(application, "Sudah Login", Toast.LENGTH_LONG).show()
        }else {
            val text: String? = "Anda belum Login"
            Toast.makeText(application, text, Toast.LENGTH_LONG).show()
        }
    }

    fun signInEmail(email: String, password: String){
        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener({
                if (it.isSuccessful){
                    firebaseUserMutableLiveData.postValue(auth.currentUser)
                    val intentToBottomNav = Intent(application, BottomNavigationActivity::class.java)
                    application.startActivity(intentToBottomNav)
                }else {
                    Toast.makeText(application, it.exception.toString(), Toast.LENGTH_LONG)
                }
            })
        }else{
            Toast.makeText(application, "Tolong lengkapi email & password anda", Toast.LENGTH_LONG)
        }
    }

    fun moveToLogin(){
        val intent = Intent(application, LoginActivity::class.java)
        application.startActivity(intent)

    }
}