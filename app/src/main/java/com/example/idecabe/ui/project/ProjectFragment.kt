package com.example.idecabe.ui.project

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.databinding.FragmentProject2Binding
import com.example.idecabe.util.hide
import com.example.idecabe.util.show
import com.example.idecabe.util.toast
import com.example.idecabe.utils.UiState
import com.google.firebase.auth.FirebaseAuth
import com.inyongtisto.myhelper.extension.isNull
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

@AndroidEntryPoint
class ProjectFragment(private val project: Project? = null) : Fragment() {

    val auth = FirebaseAuth.getInstance()

    private lateinit var viewModel: ProjectViewModel
    private lateinit var binding: FragmentProject2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProject2Binding.inflate(inflater, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ProjectViewModel::class.java)
        // TODO: Use the ViewModel

        binding.saveButton.setOnClickListener {
            if (validation()){
                val userId = auth.currentUser?.uid.toString()
                if (validation()){
                    viewModel.addProject(Project(
                        id = "",
                        user_id = userId,
                        project_name = binding.etProjectName.text.toString(),
                        date = Date()
                    ))
                }
            }
        }
        viewModel.addProject.observe(viewLifecycleOwner){state ->
            when (state){
                is UiState.Loading -> {
                    binding.progressBar.show()
                }

                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(state.error)
                }

                is UiState.Success -> {
                    binding.progressBar.hide()
                    toast("Project has been Uploaded!")
                }
            }

        }
    }

//    private fun observer(){
//        viewModel.addProject.observe(viewLifecycleOwner){
//            state ->
//            when(state){
//                is UiState.Loading{
//
//                }
//            }
//        }
//    }

    private fun validation(): Boolean {
        var isValid = true
        if (binding.etProjectName.text.isNullOrEmpty()){
            isValid = false
        }
        return isValid
    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun date(date: ): String{
//            val currentTime = LocalDateTime.now()
//            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
//            val formatted = currentTime.format(formatter)
//    }
}

