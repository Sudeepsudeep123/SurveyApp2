package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.features.form.fragment.SixteenFragment
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.helper.DropdownHelper
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question15.*

class Question15Fragment : Fragment() , View.OnClickListener {
    var listOfEducationalStatus: MutableList<String> = ArrayList()
    private lateinit var question16Fragment: SixteenFragment
    var familyMemberListSpinner: MutableList<Spinner> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberEducationalStatus: MutableList<String> = ArrayList()
    var selectedItem = ""

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question14, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setList()
        getData()
        makeForm()

        for(i  in 0 until  familyMemberListSpinner.size){
            familyMemberListSpinner[i].onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(context, listOfEducationalStatus[position], Toast.LENGTH_SHORT).show()
                    selectedItem = listOfEducationalStatus[position]
                    familyMemberEducationalStatus.add(i,selectedItem)

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }
    }

    private fun setList() {
        listOfEducationalStatus.add("UnEducated")
        listOfEducationalStatus.add("SEE")
        listOfEducationalStatus.add("+2")
        listOfEducationalStatus.add("Bachelors")
        listOfEducationalStatus.add("Masters")
        listOfEducationalStatus.add("Above")

    }

    private fun makeForm() {
        familyMemberList.reverse()
        familyMemberListSpinner = DropdownHelper.dropDownHelper(
            familyMemberList.size,
            context,
            familyMemberList,
            llDynamicEducationStatus,
            listOfEducationalStatus
        )
    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? =
                context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)

            val set: Set<String> = prefs?.getStringSet("familyMemberName", null) as Set<String>
            for (item in set) {
                familyMemberList.add(item)
                Log.e("item", item)
            }
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
            btnNext -> {
                save()
                showQuestion16()
            }
        }
    }

    private fun showQuestion16() {
        if (!::question16Fragment.isInitialized)
            question16Fragment = SixteenFragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question16Fragment,
            FragmentTagConstants.sixtenFragmentTag, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberEducationalStatus)
        prefs?.edit()?.putStringSet("familyMemberEducationalStatus", set)?.apply()
    }
}