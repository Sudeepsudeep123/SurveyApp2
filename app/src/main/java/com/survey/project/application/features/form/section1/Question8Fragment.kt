package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question8.*
import kotlinx.android.synthetic.main.fragment_question8.btnNext
import kotlinx.android.synthetic.main.fragment_question8.btnPrevious
import kotlinx.android.synthetic.main.fragment_question9.*

class Question8Fragment : Fragment(), View.OnClickListener {
    private lateinit var question9Fragment: Question9Fragment
    var familyMemberListEditText: MutableList<EditText> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberAgeList: MutableList<String> = ArrayList()

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question8, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()

        makeForm()
    }

    private fun makeForm() {
        familyMemberList.reverse()
        llDynamicMemberAge.removeAllViews()
        for (i in 0 until familyMemberList.size) {
            var myEditText = EditText(context)
            myEditText.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            myEditText.hint = familyMemberList[i] + " उमेर"
            myEditText.inputType=InputType.TYPE_CLASS_NUMBER
            familyMemberListEditText.add(myEditText)
            llDynamicMemberAge.addView(myEditText)
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
                familyMemberAgeList.clear()
                for (age in familyMemberListEditText) {
                    if (age.text.toString() == "") {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        familyMemberAgeList.add(age.text.toString())
                    }
                }


                if (familyMemberAgeList.size == familyMemberList.size) {
                    save()
                    showQuestion8()
                }
                else{
                    Toast.makeText(context, "Invalid", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun showQuestion8() {
        if (!::question9Fragment.isInitialized)
            question9Fragment = Question9Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question9Fragment,
            FragmentTagConstants.question8Fragment, true
        )
    }

    private fun save() {

        val prefs: SharedPreferences? = context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberAgeList)
        prefs?.edit()?.putStringSet("familyMemberAge", set)?.apply()
    }
}
