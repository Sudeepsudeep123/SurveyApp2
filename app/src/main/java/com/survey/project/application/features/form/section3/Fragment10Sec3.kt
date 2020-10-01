package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_fragment10_sec3.*

class Fragment10Sec3 : Fragment() , View.OnClickListener {
    private lateinit var question11Sec3: Fragment11Sec3
    private lateinit var myView: View
    var selectedValue = ""

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
            Log.e("selected",selectedValue + "asd")
        }

    }

    private fun getData() {
        try{
            val prefs: SharedPreferences? = context?.getSharedPreferences("Section3",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("transportation", "")
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
        editor?.putString("transportation", selectedValue)
        editor?.apply()
    }

    private fun showQuestion8() {
        if (!::question11Sec3.isInitialized)
            question11Sec3 = Fragment11Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question11Sec3,
            FragmentTagConstants.question11Sec3, true
        )
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                save()
                if(selectedValue == "छ") {
                    showQuestion8()

                }else{
                    Toast.makeText(context,"Completed",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}