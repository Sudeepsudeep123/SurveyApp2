package com.survey.project.application.features.form.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.fragment.SixteenFragment
import com.survey.project.application.features.form.fragment.SeventeenFragment
import com.survey.project.application.features.form.section1.Question1Fragment
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router

class FormActivity : AppCompatActivity() {
    private lateinit var sixteenFragment: SixteenFragment
    private lateinit var seventeenFragment: SeventeenFragment
    private lateinit var question1Fragment: Question1Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        showQuestion1()
       // attachFirstFragment()
    }

    private fun attachFirstFragment() {
        if (!::sixteenFragment.isInitialized) {
            sixteenFragment =
                SixteenFragment()
            Log.e("here", "login")

            Router.attachFragment(
                this,
                R.id.frmMain,
                sixteenFragment,
                FragmentTagConstants.sixtenFragmentTag,
                true
            )
        }
    }

    private fun showQuestion1() {
        if (!::question1Fragment.isInitialized)
            question1Fragment = Question1Fragment()
        Router.attachFragment(
           this, R.id.frmMain, question1Fragment,
            FragmentTagConstants.forgotPasswordFragmentTag, true
        )
    }

    fun attachFragment(fragment: Fragment, fragmentTag: String) {
        Router.attachFragment(
            this,
            R.id.frmMain,
            fragment,
            fragmentTag,
            true
        )
    }
}