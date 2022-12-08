package com.example.idecabe.ui.project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.idecabe.R
import com.example.idecabe.databinding.FragmentDashboardBinding
import com.example.idecabe.databinding.FragmentProjectBinding
import com.example.idecabe.ui.dashboard.ProjectViewModel

class ProjectFragment : Fragment() {

    private var _binding: FragmentProjectBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val spinner: Spinner = binding.maskingSelection

        val projectViewModel =
            ViewModelProvider(this).get(ProjectViewModel::class.java)

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        projectViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Create an ArrayAdapter using the string array and a default spinner layout
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.maskingSelection,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
//                spinner.adapter = adapter
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}