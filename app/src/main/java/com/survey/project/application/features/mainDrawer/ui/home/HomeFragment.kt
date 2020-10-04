package com.survey.project.application.features.mainDrawer.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.survey.project.application.R
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.base.BaseFragment
import com.survey.project.application.features.main.MainActivity
import com.survey.project.application.features.shared.adapter.HomeAdapter
import com.survey.project.application.features.shared.model.AreaModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView, View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel
    var userName: String? = ""
    var provence: String? = ""
    var zone: String? = ""
    var district: String? = ""
    lateinit var areaList: MutableList<AreaModel>
    private var layoutManager: LinearLayoutManager? = null
    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
   /*     val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        userName = activity?.intent?.getStringExtra("username") ?: ""
        provence = activity?.intent?.getStringExtra("provence") ?: ""
        zone = activity?.intent?.getStringExtra("zone") ?: ""
        district = activity?.intent?.getStringExtra("district") ?: ""

        textView.text = "$provence   $zone   $district"
*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initRecyclerView()
        presenter?.getLocationFromDB()
    }

    override fun createPresenter() = HomePresenter()

    override fun onClick(view: View?) {
        when (view) {
            btnAddNew -> {
                val intent = Intent(context, MainActivity::class.java)
                startActivityForResult(intent, 3000)
            }
        }
    }


    override fun getAppDatabase(): MainRoomDatabase? = MainRoomDatabase.getAppDatabase(context)

    override fun populateAreaModelInList(mainModel: List<AreaModel>) {


    }

    override fun onFailure(message: String) {

    }

    override fun populateLocationsInView(list: List<AreaModel>) {
        areaList?.clear()
        areaList?.addAll(list)
        homeAdapter?.notifyDataSetChanged()
    }

    private fun initListener() {
        btnAddNew?.setOnClickListener(this)
    }

    private fun initRecyclerView() {
        areaList = ArrayList()
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvSurveyLocations.layoutManager = layoutManager

        rcvSurveyLocations?.isNestedScrollingEnabled = false
        homeAdapter = HomeAdapter(context, areaList)
        rcvSurveyLocations?.adapter = homeAdapter
    }
}