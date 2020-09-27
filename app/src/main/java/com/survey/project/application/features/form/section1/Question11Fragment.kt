package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question10.*
import kotlinx.android.synthetic.main.fragment_question10.btnNext
import kotlinx.android.synthetic.main.fragment_question10.btnPrevious
import kotlinx.android.synthetic.main.fragment_question3.*

class Question11Fragment : Fragment() , View.OnClickListener {
    var listOfWard: MutableList<String> = ArrayList()
    private lateinit var question12Fragment: Question12Fragment
    var familyMemberListSpinner: MutableList<Spinner> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberLocalAddress: MutableList<String> = ArrayList()
    var selectedItem = ""

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question10, container, false)
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
            listOfWard.add("1")
            listOfWard.add("2")
            listOfWard.add("3")
            listOfWard.add("4")
            listOfWard.add("5")
    }

    private fun makeForm() {
        familyMemberList.reverse()
        var spinner = arrayOfNulls<Spinner>(familyMemberList.size)


        for (i in 0 until familyMemberList.size) {

            var textView = TextView(context)
            textView.text = familyMemberList[i]
            llDynamicMemberNotStay.addView(textView)

             spinner[i] = Spinner(context)
            val adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, listOfWard) }
            spinner[i]?.adapter = adapter
            spinner[i]?.let { familyMemberListSpinner.add(it) }
            llDynamicMemberNotStay.addView(spinner[i])

        }

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
                familyMemberLocalAddress.clear()

                for (member in familyMemberListSpinner) {
//                    if (member.isChecked) {
//                        familyMemberNotStayList.add(member.toString())
//                        Log.e("fam Member", member.text.toString())
//                    }

                    member.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View, position: Int, id: Long
                        ) {
                            Toast.makeText(context, listOfWard[position], Toast.LENGTH_SHORT).show()
                            selectedItem = listOfWard[position]
                            familyMemberLocalAddress.add(selectedItem)

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
        if (!::question12Fragment.isInitialized)
            question12Fragment = Question12Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question12Fragment,
            FragmentTagConstants.question12Fragment, true
        )
    }

    private fun save() {

        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberLocalAddress)
        prefs?.edit()?.putStringSet("familyMemberLocalAddress", set)?.apply()
    }
}