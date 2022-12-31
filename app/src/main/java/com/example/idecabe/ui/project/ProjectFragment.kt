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
import com.example.idecabe.util.toast
import com.example.idecabe.utils.UiState
import com.google.firebase.auth.FirebaseAuth
import com.inyongtisto.myhelper.extension.isNull
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@AndroidEntryPoint
class ProjectFragment(private val project: Project? = null) : Fragment() {

    companion object {
        fun newInstance() = ProjectFragment()
    }

    var isSuccessAddTask: Boolean = false
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
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProjectViewModel::class.java)
        // TODO: Use the ViewModel

        binding.saveButton.setOnClickListener {
            if (validation()){
                val userId = auth.currentUser?.uid.toString()
                val currentTime = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                val formatted = currentTime.format(formatter).toString()
                project?.project_name = binding.etProjectName.text.toString()
                project?.date = formatted
                project?.user_id = userId
                if (project != null) {
                    viewModel.addProject(project)
                }else {
                    Toast.makeText(activity, "Please fill all of the fields", Toast.LENGTH_LONG)
                }
            }
        }
    }

    private fun observer() {
        viewModel.addProject.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> {
                    Toast.makeText(activity, "Loading", Toast.LENGTH_SHORT)
                }
                is UiState.Failure -> {
                    toast(state.error)
                }
                is UiState.Success -> {
                    isSuccessAddTask = true
                    toast(state.data.second)
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
        if (binding.etProjectName.isNull()){
            isValid = false
            Toast.makeText(activity, "Please fill the empty fields", Toast.LENGTH_LONG)
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

