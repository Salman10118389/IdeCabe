package com.example.idecabe.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.idecabe.BottomNavigationActivity
import com.example.idecabe.databinding.FragmentAccountBinding
import com.example.idecabe.databinding.FragmentNotificationsBinding
import com.example.idecabe.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var userId: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val accountViewModel =
            ViewModelProvider(this).get(AccountViewModel::class.java)

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textNotifications
//        accountViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        userId = FirebaseAuth.getInstance().currentUser?.uid.toString()

        binding.textLogout.setOnClickListener({
            if(userId.isNotEmpty()){
                logOut()
            }
        })
        return root
    }

    private fun logOut(){
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val intentToMain = Intent(activity, LoginActivity::class.java)
        startActivity(intentToMain)
        activity?.finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}