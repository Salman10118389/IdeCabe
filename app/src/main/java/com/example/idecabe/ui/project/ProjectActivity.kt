package com.example.idecabe.ui.project

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.idecabe.R
import com.example.idecabe.databinding.ActivityProjectBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.inyongtisto.myhelper.extension.isNull
import com.yalantis.ucrop.view.CropImageView

class ProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProjectBinding
    private var iconImageUri: Uri? = null
    private val firebaseStorage = FirebaseStorage.getInstance().getReference()
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val uId = firebaseAuth.uid.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val currentUserID = firebaseAuth.currentUser?.uid

        val projectName: String? = binding.etProjectName.text.toString()
        val label: String = binding.etLabel.text.toString()

        binding.btnSave.setOnClickListener({
                if(projectName != null && label != null){
                    var projectMap: HashMap<String, String> =HashMap<String, String>()
                    projectMap.put("Name", projectName.toString())
                    projectMap.put("Label", label)
                    projectMap.put("parent", uId)
                    firebaseFirestore.collection("Project").add(projectMap).addOnCompleteListener({
                        if (it.isSuccessful){
                            Toast.makeText(this, "Project Saved", Toast.LENGTH_LONG).show()
                        }else {
                            Toast.makeText(this, it?.exception?.message, Toast.LENGTH_LONG)
                        }
                    })
                }else{
                    Toast.makeText(
                        this, "Tolong isi project name & label", Toast.LENGTH_LONG
                    )
                }
            }
        )
    }
}