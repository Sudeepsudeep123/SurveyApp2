package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_fragment6_sec3.*

class Fragment6Sec3 : Fragment(), View.OnClickListener {
    private lateinit var question7Sec3: Fragment7Sec3
    private lateinit var myView: View
    var selectedValue = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment6_sec3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()

        radWashHandOption.setOnCheckedChangeListener { p0, checkedId ->
            val radioButton = radWashHandOption.findViewById<RadioButton>(checkedId)
            selectedValue = radioButton.text.toString()

        }

    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? = context?.getSharedPreferences(
                "Section3",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("handWash", "")

            if (name == rbCha.text.toString()) {
                rbCha.isChecked = true
                selectedValue = name
            } else if (name == rbChaina.text.toString()) {
                rbChaina.isChecked = true
                selectedValue = name
            }

        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
    }

    private fun save() {
        val editor: SharedPreferences.Editor? =
            context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)?.edit()
        editor?.putString("handWash", selectedValue)
        editor?.apply()
    }

    private fun showQuestion7() {
        if (!::question7Sec3.isInitialized)
            question7Sec3 = Fragment7Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question7Sec3,
            FragmentTagConstants.question7Sec3, true
        )
    }


    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                if (selectedValue != ""){
                        save()
                        showQuestion7()
                    }
                else {
                    Toast.makeText(context, "Please choose one", Toast.LENGTH_SHORT).show()
                }


            }
            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
        }
    }
}