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
import kotlinx.android.synthetic.main.fragment_question12.*

class Question12Fragment : Fragment() , View.OnClickListener {
    var listOfOccupation: MutableList<String> = ArrayList()
    private lateinit var question13Fragment: Question13Fragment
    var familyMemberListSpinner: MutableList<Spinner> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberMainOccupation: MutableList<String> = ArrayList()
    var selectedItem = ""

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question12, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setList()
        getData()
        makeForm()
        
    }

    private fun setList() {
        listOfOccupation.add("1")
        listOfOccupation.add("2")
        listOfOccupation.add("3")
        listOfOccupation.add("4")
        listOfOccupation.add("5")
    }

    private fun makeForm() {
        familyMemberList.reverse()
        familyMemberListSpinner = DropdownHelper.dropDownHelper(
            familyMemberList.size,
            context,
            familyMemberList,
            llDynamicMainOccupation,
            listOfOccupation
        )
    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? =
                context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)

            val set: Set<String> = prefs?.getStringSet("familyMemberLocalAddress", null) as Set<String>
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
                familyMemberMainOccupation.clear()

                for (member in familyMemberListSpinner) {
                    member.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            Toast.makeText(context, listOfOccupation[position], Toast.LENGTH_SHORT).show()
                            selectedItem = listOfOccupation[position]
                            familyMemberMainOccupation.add(selectedItem)

                        }
                        override fun onNothingSelected(parent: AdapterView<*>) {

                        }
                    }
                }
                save()
                showQuestion12()
            }
        }
    }

    private fun showQuestion12() {
        if (!::question13Fragment.isInitialized)
            question13Fragment = Question13Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question13Fragment,
            FragmentTagConstants.question13Fragment, true
        )
    }

    private fun save() {

        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberMainOccupation)
        prefs?.edit()?.putStringSet("familyMemberMainOccupation", set)?.apply()
    }
}