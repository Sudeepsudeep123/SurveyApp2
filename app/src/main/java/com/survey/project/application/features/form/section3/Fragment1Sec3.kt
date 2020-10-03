package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_fragment1_sec3.*


class Fragment1Sec3 : Fragment() ,View.OnClickListener {
    private lateinit var question2Sec3: Fragment2Sec3
    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment1_sec3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()
    }

    private fun getData() {
        try{
            val prefs: SharedPreferences? = context?.getSharedPreferences("Section3",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("noOfHouse", "")
            if(name!="" || name != null){
                etNoOfHouse.setText(name)
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
        editor?.putString("noOfHouse", etNoOfHouse.text.toString())
        editor?.apply()
    }

    private fun showQuestion2() {
        if (!::question2Sec3.isInitialized)
            question2Sec3 = Fragment2Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question2Sec3,
            FragmentTagConstants.question2Sec3, true
        )
    }

    override fun onClick(view: View?) {
        when(view){
            btnNext ->{
                if(etNoOfHouse == null || etNoOfHouse.text.toString() == ""){
                    Toast.makeText(context,"Empty Field", Toast.LENGTH_SHORT).show()
                }
                else{
                    save()
                    showQuestion2()
                }
            }
        }
    }

}