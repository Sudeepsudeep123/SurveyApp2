package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question10.*


class Question10Fragment : Fragment() , View.OnClickListener {
    private lateinit var question11Fragment: Question11Fragment
    var familyMemberListCheckBox: MutableList<CheckBox> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()
    var familyMemberNotStayList: MutableList<String> = ArrayList()

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
        getData()
        makeForm()
    }

    private fun makeForm() {
        llDynamicMemberNotStay.removeAllViews()
        familyMemberList.reverse()
        val cb = arrayOfNulls<CheckBox>(familyMemberList.size)


        for (i in 0 until familyMemberList.size) {
            cb[i] = CheckBox(context)
            cb[i]?.text = familyMemberList[i]
            cb[i]?.let { familyMemberListCheckBox.add(it) }
            llDynamicMemberNotStay.addView(cb[i])

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
                familyMemberNotStayList.clear()
                for (member in familyMemberListCheckBox) {
                    if (member.isChecked) {
                        familyMemberNotStayList.add(member.toString())
                        Log.e("fam Member", member.text.toString())
                    }
                }
                save()
                showQuestion11()
            }
        }
    }

    private fun showQuestion11() {
        if (!::question11Fragment.isInitialized)
            question11Fragment = Question11Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question11Fragment,
            FragmentTagConstants.question11Fragment, true
        )
    }

    private fun save() {

        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberNotStayList)
        prefs?.edit()?.putStringSet("familyMemberNotStay", set)?.apply()
    }
}