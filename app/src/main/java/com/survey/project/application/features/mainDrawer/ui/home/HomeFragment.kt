package com.survey.project.application.features.mainDrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.survey.project.application.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var userName:String ?=""
    var provence:String ?=""
    var zone:String ?=""
    var district:String ?=""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        userName = activity?.intent?.getStringExtra("username") ?: ""
        provence = activity?.intent?.getStringExtra("provence") ?: ""
        zone = activity?.intent?.getStringExtra("zone") ?: ""
        district = activity?.intent?.getStringExtra("district") ?: ""

        textView.text = "$provence   $zone   $district"






        return root
    }
}