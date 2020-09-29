package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question9.*


class Question9Fragment : Fragment(), View.OnClickListener {
    private lateinit var question10Fragment: Question10Fragment
    var familyMemberListCheckBox: MutableList<CheckBox> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberStayList: MutableList<String> = ArrayList()

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question9, container, false)
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
        llDynamicMemberStay.removeAllViews()
//        val radioGroup = RadioGroup(context)
//        val rb = arrayOfNulls<RadioButton>(familyMemberList.size)
        val cb = arrayOfNulls<CheckBox>(familyMemberList.size)


        for (i in 0 until familyMemberList.size) {

//            rb[i] = RadioButton(context)
//            rb[i]?.text = familyMemberList[i]
//            radioGroup.addView(rb[i]);

            cb[i] = CheckBox(context)
            cb[i]?.text = familyMemberList[i]
            cb[i]?.let { familyMemberListCheckBox.add(it) }
            llDynamicMemberStay.addView(cb[i])

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
                familyMemberStayList.clear()
                for (member in familyMemberListCheckBox) {
                    if (member.isChecked) {
                        familyMemberStayList.add(member.toString())
                        Log.e("fam Member", member.text.toString())
                    }
                }
                save()
                showQuestion10()
            }
        }
    }

    private fun showQuestion10() {
        if (!::question10Fragment.isInitialized)
            question10Fragment = Question10Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question10Fragment,
            FragmentTagConstants.question10Fragment, true
        )
    }

    private fun save() {

        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberStayList)
        prefs?.edit()?.putStringSet("familyMemberStay", set)?.apply()
    }
}