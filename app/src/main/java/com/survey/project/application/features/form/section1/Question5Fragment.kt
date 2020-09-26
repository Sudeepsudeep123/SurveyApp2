package com.survey.project.application.features.form.section1

import android.content.Context
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
import kotlinx.android.synthetic.main.fragment_question4.*
import kotlinx.android.synthetic.main.fragment_question4.btnNext
import kotlinx.android.synthetic.main.fragment_question4.btnPrevious
import kotlinx.android.synthetic.main.fragment_question5.*

class Question5Fragment : Fragment(), View.OnClickListener {
    private lateinit var question6Fragment: Question6Fragment

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question5, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()
    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? = context?.getSharedPreferences(
                "Section1",
                Context.MODE_PRIVATE
            )
            val name = prefs?.getString("gharNo", "")
            if (name != "" || !name.equals(null)) {
                edtGharNo.setText(name)
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
                if (edtGharNo.text.toString() == "") {
                    Toast.makeText(context, "Empty Field", Toast.LENGTH_SHORT).show()
                } else {
                    save()
                    showQuestion6()
                }
            }
        }
    }

    private fun showQuestion6() {
        if (!::question6Fragment.isInitialized)
            question6Fragment = Question6Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question6Fragment,
            FragmentTagConstants.question6Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        prefs?.edit()
            ?.putString("gharNo", edtGharNo.text.toString())
            ?.apply();
    }
}