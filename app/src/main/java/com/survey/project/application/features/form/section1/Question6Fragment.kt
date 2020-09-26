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
import kotlinx.android.synthetic.main.fragment_question6.*


class Question6Fragment : Fragment(), View.OnClickListener {
    private lateinit var question7Fragment: Question7Fragment

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question6, container, false)
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



            val purush = prefs?.getString("purushNumber", "")
            val mahila = prefs?.getString("mahilaNumber", "")
            val other = prefs?.getString("tesroNumber", "")
            if (purush != "" || !purush.equals(null)) {
                edtMaleNumber.setText(purush)
            }

            if (mahila != "" || !mahila.equals(null)) {
                edtFemaleNumber.setText(purush)
            }

            if (other != "" || !other.equals(null)) {
                edtOtherNumber.setText(purush)
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
                if (edtMaleNumber.text.toString() == "" || edtFemaleNumber.text.toString() == "" || edtOtherNumber.text.toString() == ""
                ) {
                    Toast.makeText(context, "Empty Field", Toast.LENGTH_SHORT).show()
                } else {
                    save()
                    showQuestion7()
                }
            }
        }
    }

    private fun showQuestion7() {
        if (!::question7Fragment.isInitialized)
            question7Fragment = Question7Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question7Fragment,
            FragmentTagConstants.question6Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        prefs?.edit()


            ?.putString("purushNumber", edtMaleNumber.text.toString())
            ?.putString("mahilaNumber", edtFemaleNumber.text.toString())
            ?.putString("tesroNumber", edtOtherNumber.text.toString())
            ?.apply();
    }
}