package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question4.*
import kotlinx.android.synthetic.main.fragment_question4.btnNext
import kotlinx.android.synthetic.main.fragment_question4.btnPrevious


class Question4Fragment : Fragment(),View.OnClickListener {
    private lateinit var question5Fragment: Question5Fragment

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question4, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
        getData()

    }
    private fun getData() {
        try{
            val prefs: SharedPreferences? = context?.getSharedPreferences("Section1",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("gauBastiTol", "")
            if(name!="" || !name.equals(null)){
                edtBastiGauTol.setText(name)
            }
        }catch(ex:Exception){
            Log.e("ex",ex.toString())
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
                save()
                showQuestion5()

            }
        }
    }

    private fun showQuestion5() {
        if (!::question5Fragment.isInitialized)
            question5Fragment = Question5Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question5Fragment,
            FragmentTagConstants.question5Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? = context?.getSharedPreferences("Section1",
            Context.MODE_PRIVATE
        )
        prefs?.edit()?.putString("gauBastiTol", edtBastiGauTol.text.toString())?.apply();
    }
}