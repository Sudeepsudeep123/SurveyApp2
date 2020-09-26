package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question1.*


private lateinit var myView: View

class Question1Fragment : Fragment(),View.OnClickListener {
    private lateinit var question2Fragment: Question2Fragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question1, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()
    }

    private fun getData() {
        try{
            val prefs: SharedPreferences? = context?.getSharedPreferences("Section1", MODE_PRIVATE)
            val name = prefs?.getString("houseOwnerName", "")
            if(name!="" || !name.equals(null)){
                etHouseOwnerName.setText(name)
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
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)?.edit()
        editor?.putString("houseOwnerName", etHouseOwnerName.text.toString())
        editor?.apply()
    }

    private fun showQuestion2() {
            if (!::question2Fragment.isInitialized)
                question2Fragment = Question2Fragment()
            Router.attachFragment(
                context as AppCompatActivity?, R.id.frmMain, question2Fragment,
                FragmentTagConstants.question2Fragment, true
            )
    }

    override fun onClick(view: View?) {
        when(view){
            btnNext ->{
                if(etHouseOwnerName == null || etHouseOwnerName.text.toString() == ""){
                    Toast.makeText(context,"Empty Field",Toast.LENGTH_SHORT).show()
                }
                else{
                    save()
                    showQuestion2()

                }
            }
        }
    }

}