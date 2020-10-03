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
import kotlinx.android.synthetic.main.fragment_fragment10_sec3.*
import kotlinx.android.synthetic.main.fragment_fragment10_sec3.btnNext
import kotlinx.android.synthetic.main.fragment_fragment10_sec3.rbCha
import kotlinx.android.synthetic.main.fragment_fragment10_sec3.rbChaina
import kotlinx.android.synthetic.main.fragment_fragment4_sec3.*

class Fragment10Sec3 : Fragment(), View.OnClickListener {
    private lateinit var question11Sec3: Fragment11Sec3
    private lateinit var question9Sec3: Fragment9Sec3
    private lateinit var myView: View
    var selectedValue = ""
    private lateinit var correctionSec3: FragmentSec3Correction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment10_sec3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()

        radVehicleOption.setOnCheckedChangeListener { p0, checkedId ->
            val radioButton = radVehicleOption.findViewById<RadioButton>(checkedId)
            selectedValue = radioButton.text.toString()
            Log.e("selected", selectedValue + "asd")
        }

    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? = context?.getSharedPreferences(
                "Section3",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("transportation", "")
            if (name == rbCha.text.toString()) {
                rbCha.isChecked = true
                selectedValue = name
            }

            else if(name == rbChaina.text.toString()) {
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
        editor?.putString("transportation", selectedValue)
        editor?.apply()
    }

    private fun showQuestion11() {
        if (!::question11Sec3.isInitialized)
            question11Sec3 = Fragment11Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question11Sec3,
            FragmentTagConstants.question11Sec3, true
        )
    }

    private fun showQuestion9() {
        if (!::question9Sec3.isInitialized)
            question9Sec3 = Fragment9Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question9Sec3,
            FragmentTagConstants.question9Sec3, true
        )
    }

    private fun showCorrection() {
        if (!::correctionSec3.isInitialized)
            correctionSec3 = FragmentSec3Correction()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, correctionSec3,
            FragmentTagConstants.correctionSec3, true
        )
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                save()
                if (selectedValue == "छ") {
                    showQuestion11()

                }

                else if(selectedValue == "छैन"){
                    showCorrection()
                }
                else{
                    Toast.makeText(context, "Please choose 1", Toast.LENGTH_SHORT).show()

                }
            }

            btnPrevious ->{
                fragmentManager?.popBackStack()
            }
        }
    }
}