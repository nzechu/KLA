package com.example.kla

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.kla.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    var heading: String =""
    var allText: String =""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)

        heading = arguments?.getString("TITLE").toString()
        allText = arguments?.getString("DESCRIPTION").toString()


        binding.topicText.text = heading
        binding.mainText.text = allText


        binding.backButton.setOnClickListener {
            navCon.navigate(R.id.action_detailFragment_to_topicFragment)

        }


        val  button = binding.shareButton
        button.setOnClickListener {
            val s = binding.mainText.text.toString()
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type= "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,s)
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,"share ")
            startActivity(Intent.createChooser(shareIntent, "share text via"))
        }



return binding.root
}
}