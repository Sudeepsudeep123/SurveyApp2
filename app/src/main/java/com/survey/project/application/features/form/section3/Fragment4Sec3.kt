package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_fragment1_sec3.*
import kotlinx.android.synthetic.main.fragment_fragment4_sec3.*
import kotlinx.android.synthetic.main.fragment_fragment4_sec3.btnNext


class Fragment4Sec3 : Fragment() , View.OnClickListener {
    private lateinit var question5Sec3: Fragment5Sec3
    private lateinit var question6Sec3: Fragment6Sec3
    private lateinit var myView: View
    var selectedValue = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment4_sec3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()

        radToiletOption.setOnCheckedChangeListener { p0, checkedId ->
            val radioButton = radToiletOption.findViewById<RadioButton>(checkedId)
            selectedValue = radioButton.text.toString()
            Log.e("value",selectedValue)
        }

    }

    private fun getData() {
        try{
            val prefs: SharedPreferences? = context?.getSharedPreferences("Section3",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("toilet", "")
            if(name.equals(rbCha.text.toString())){
                rbCha.isChecked
            }
            else{
                rbChaina.isChecked
            }
        }catch(ex:Exception){
            Log.e("ex",ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
    }

    private fun save() {
        val editor: SharedPreferences.Editor? =
            context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)?.edit()
        editor?.putString("toilet", selectedValue)
        editor?.apply()
    }

    private fun showQuestion5() {
        if (!::question5Sec3.isInitialized)
            question5Sec3 = Fragment5Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question5Sec3,
            FragmentTagConstants.question5Sec3, true
        )
    }
    private fun showQuestion6() {
        if (!::question6Sec3.isInitialized)
            question6Sec3 = Fragment6Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question6Sec3,
            FragmentTagConstants.question6Sec3, true
        )
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                save()
                if(selectedValue == "छ"){
                    showQuestion5()
                }
                else{
                    showQuestion6()

                }
            }
        }
    }
}