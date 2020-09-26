package com.survey.project.application.features.main

import `in`.galaxyofandroid.spinerdialog.SpinnerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.survey.project.application.R
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.mainDrawer.DrawerActivity
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.otherClasses.ProvenceZoneDistrict
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpActivity<MainView, MainPresenter>(), MainView,
    View.OnClickListener {
    private var spinnerDialogProvence: SpinnerDialog? = null
    private var spinnerDialogZone: SpinnerDialog? = null
    private var spinnerDialogDistrict: SpinnerDialog? = null

    var provenceList: ArrayList<String> = ArrayList()
    var zoneList: ArrayList<String> = ArrayList()
    var districtList: ArrayList<String> = ArrayList()

    var userName: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
        userName = intent.getStringExtra("username") ?: ""
        Log.e("userName", userName)
        provenceList.clear()
        setSpinnerData()
//         presenter.getLocationFromDB()

        spinnerDialogProvence?.bindOnSpinerListener { item, position ->
            zoneList.clear()
            districtList.clear()
            txvZone.text = "Choose Zone"
            txvDistrict.text = "Choose District"

            setZoneList(item)
           // Toast.makeText(this, "$item  $position", Toast.LENGTH_SHORT).show();
            txvProvience.text = item
        }

        spinnerDialogZone?.bindOnSpinerListener { item, position ->
            districtList.clear()
            txvDistrict.text = "Choose District"
            Log.e("item", item)
            setDistrictItems(item)
           // Toast.makeText(this, "$item  $position", Toast.LENGTH_SHORT).show();
            txvZone.text = item
        }

        spinnerDialogDistrict?.bindOnSpinerListener { item, position ->
          //  Toast.makeText(this, "$item  $position", Toast.LENGTH_SHORT).show();
            txvDistrict.text = item
        }

    }

    private fun setSpinnerData() {
        ProvenceZoneDistrict.setProvence()
        ProvenceZoneDistrict.zone()

        setProvenceList(ProvenceZoneDistrict.listOfProvence)
        spinnerDialogProvence = SpinnerDialog(this, provenceList, "Search Provence", "X")
        spinnerDialogZone = SpinnerDialog(this, zoneList, "Search Zone", "X")
        spinnerDialogDistrict = SpinnerDialog(this, districtList, "Search District", "X")
    }

    private fun setDistrictItems(item: String) {
        Log.e("here", "here")

        districtList.clear()
        for (zone in ProvenceZoneDistrict.listOfZone) {
            if (item == zone.key) {
                Log.e("here", "here123")
                for (district in zone.value) {
                    Log.e("value", district)
                    districtList.add(district)
                }
            }
        }
    }

    private fun setZoneList(item: String) {
        zoneList.clear()
        for (provinces in ProvenceZoneDistrict.listOfProvence) {
            if (item.equals(provinces.key)) {
                for (zone in provinces.value) {
                    zoneList.add(zone)
                }
            }
        }

    }

    private fun setProvenceList(listOfProvence: HashMap<String, List<String>>) {
        for (provence in listOfProvence) {
            Log.e("data", provence.key)
            provenceList.add(provence.key)
        }

    }

    private fun setListener() {
        txvProvience.setOnClickListener(this)
        txvZone.setOnClickListener(this)
        txvDistrict.setOnClickListener(this)
        btnArea.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            txvProvience -> {
                spinnerDialogProvence?.showSpinerDialog()
            }

            txvZone -> {

                spinnerDialogZone?.showSpinerDialog()
            }

            txvDistrict -> {
                spinnerDialogDistrict?.showSpinerDialog()
            }

            btnArea -> {
                presenter.submit(
                    userName,
                    txvProvience.text.toString(),
                    txvZone.text.toString(),
                    txvDistrict.text.toString()
                )
            }

        }
    }

    override fun createPresenter() = MainPresenter()
    override fun onSuccess(mainModel: List<AreaModel>) {
        if (mainModel is List<AreaModel>) {
            Log.e("success", mainModel.toString())
            var intent = Intent(this, DrawerActivity::class.java)
//            intent.putExtra(mainModel[0])
            intent.putExtra("provence", txvProvience.text.toString())
            intent.putExtra("zone", txvZone.text.toString())
            intent.putExtra("district", txvDistrict.text.toString())
            intent.putExtra("userName", userName)
            startActivity(intent)
        }
    }

    override fun onGetLocation(mainModel: List<AreaModel>) {
        if (mainModel.isEmpty()) {
            setSpinnerData()
        } else {
            if (mainModel[0].area?.get(0)?.username.equals(userName)) {
                startActivity(Intent(this, DrawerActivity::class.java))
            } else {
                Log.e("here", "here")
                setSpinnerData()
            }
        }
    }

    override fun onFailure(message: String) {
        Log.e("Error", message)
    }

    override fun getAppDatabase(): MainRoomDatabase? = MainRoomDatabase.getAppDatabase(this)


    override fun showToast(messageInt: Int) {
        TODO("Not yet implemented")
    }
}