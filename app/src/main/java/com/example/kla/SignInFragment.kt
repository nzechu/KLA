package com.example.kla

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kla.databinding.FragmentSignInBinding
import com.example.kla.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController
    private lateinit var fAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        fAuth = Firebase.auth

        binding.signUpText.setOnClickListener {
            navCon.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        binding.signInButton.setOnClickListener {
            validateForm()
        }
        return binding.root
        }

    private fun validateForm() {
        when {
            TextUtils.isEmpty(binding.emailEd.text.toString().trim()) -> {
                binding.emailEd.setError("Please enter Email")
            }
            TextUtils.isEmpty(binding.passwordEd.text.toString().trim()) -> {
                binding.passwordEd.setError("Please enter password")
            }

            binding.emailEd.text.toString().isNotEmpty() &&
                    binding.passwordEd.text.toString().isNotEmpty()  ->
            {
                if (binding.emailEd.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){

                       fireBaseSignIn()
                       Toast.makeText(context,"SignIn successful", Toast.LENGTH_LONG).show()

                } else {
            binding.emailEd.error = "Please enter valid Email"
        }

        }
    }




    }

    private fun fireBaseSignIn() {

        binding.signInButton.isEnabled = false
        binding.signInButton.alpha = 1.0f
        fAuth.signInWithEmailAndPassword(binding.emailEd.text.toString(),
        binding.passwordEd.text.toString()).addOnCompleteListener {
            task ->
        if (task.isSuccessful){
            navCon.navigate(R.id.action_signInFragment_to_topicFragment)

        }else {
        binding.signInButton.isEnabled = true
        binding.signInButton.alpha = 1.0f
        Toast.makeText(context,task.exception?.message, Toast.LENGTH_LONG).show()


        }    }

    }
}

