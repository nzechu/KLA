package com.example.kla

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kla.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignUpFragment : Fragment() {

    private lateinit var fAuth: FirebaseAuth
    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)

        fAuth = Firebase.auth
        binding.signInText.setOnClickListener {
            navCon.navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        binding.signUpButton.setOnClickListener {
            validateEmptyForm()
        }

        return binding.root  }

    private fun validateEmptyForm() {
        when {
            TextUtils.isEmpty(binding.regEmail.text.toString().trim()) -> {
                binding.regEmail.setError("Please enter username")
            }
            TextUtils.isEmpty(binding.regPassword.text.toString().trim()) -> {
                binding.regPassword.setError("Please enter password")
            }
            TextUtils.isEmpty(binding.regCmfPassword.text.toString().trim()) -> {
                binding.regCmfPassword.setError("Please enter password again")
            }
            binding.regEmail.text.toString().isNotEmpty() &&
                    binding.regPassword.text.toString().isNotEmpty() &&
                    binding.regCmfPassword.text.toString().isNotEmpty() ->
            {
                if (binding.regEmail.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    if (binding.regPassword.text.toString().length>=5){
                        if (binding.regPassword.text.toString() == binding.regCmfPassword.text.toString()){
                            fireBaseSignUp()
                            Toast.makeText(context,"Signup successful", Toast.LENGTH_LONG).show()
                        }
                        else {
                            binding.regCmfPassword.error = "Password didnt match"
                        }

                    }else {
                        binding.regPassword.error = "Please enter atleast 5 chaacters"
                    }

                }
            }else->{
            binding.regEmail.error = "Please enter valid Email"
        }

        }
    }

    private fun fireBaseSignUp() {

        fAuth.createUserWithEmailAndPassword(  binding.regEmail.text.toString(),
            binding.regPassword.text.toString() ).addOnCompleteListener {
                task ->
            if (task.isSuccessful){
                Toast.makeText(context,"Signup successful", Toast.LENGTH_LONG).show()
                /*var navHome = activity as FragmentNavigation
                navHome.navigateFrag(HomeFragment,true)*/

                navCon.navigate(R.id.action_signUpFragment_to_signInFragment)

            }else { Toast.makeText(context,task.exception?.message, Toast.LENGTH_LONG).show()
            }
        }
    }


}


