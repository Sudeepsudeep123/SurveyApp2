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
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.helper.DropdownHelper
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question13.*


class Question13Fragment : Fragment() , View.OnClickListener {
    var listOfTalent: MutableList<String> = ArrayList()
    private lateinit var question14Fragment: Question14Fragment
    var familyMemberListSpinner: MutableList<Spinner> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberMainTalent: MutableList<String> = ArrayList()
    var selectedItem = ""

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question13, container, false)
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
                    Toast.makeText(context, listOfTalent[position], Toast.LENGTH_SHORT).show()
                    selectedItem = listOfTalent[position]
                    familyMemberMainTalent.add(i,selectedItem)

                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }
    }

    private fun setList() {
        listOfTalent.add("1")
        listOfTalent.add("2")
        listOfTalent.add("3")
        listOfTalent.add("4")
        listOfTalent.add("5")
    }

    private fun makeForm() {
        familyMemberList.reverse()
        familyMemberListSpinner = DropdownHelper.dropDownHelper(
            familyMemberList.size,
            context,
            familyMemberList,
            llDynamicMainTalent,
            listOfTalent
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
                showQuestion14()
            }
        }
    }

    private fun showQuestion14() {
        if (!::question14Fragment.isInitialized)
            question14Fragment = Question14Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question14Fragment,
            FragmentTagConstants.question14Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberMainTalent)
        prefs?.edit()?.putStringSet("familyMemberMainTalent", set)?.apply()
    }
}