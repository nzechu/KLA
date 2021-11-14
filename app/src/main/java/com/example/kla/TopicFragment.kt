package com.example.kla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kla.adapters.TopicAdapter
import com.example.kla.Data.DataSource
import com.example.kla.databinding.FragmentTopicBinding


class TopicFragment : Fragment() {




    private var _binding: FragmentTopicBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon : NavController





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopicBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)

        //sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]






        val newRecyclerView = binding.recyclerView
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)


        val myDataSet = DataSource.loadTopics


        var adapter = TopicAdapter(myDataSet)
        newRecyclerView.adapter = adapter

        //sharedViewModel!!.topics.observe(viewLifecycleOwner, Observer{ var adapter = TopicAdapter(it)})



        adapter.setOnItemClickListener(object: TopicAdapter.onItemClickedListener{
            override fun onItemClick(position: Int) {

                    val title = myDataSet[position]


                    val bundle = Bundle()
                    bundle.putString("TITLE", title.textLine)
                    bundle.putString("DESCRIPTION", title.detail)

                navCon.navigate(R.id.action_topicFragment_to_detailFragment,bundle)

                }












        })

        return binding.root

    }


}