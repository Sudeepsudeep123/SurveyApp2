package com.survey.project.application.features.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.survey.project.application.R
import com.survey.project.application.features.form.section1.Question1Fragment
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router

class FormActivity : AppCompatActivity() {
    private lateinit var question1Fragment: Question1Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        showQuestion1()

    }

    private fun showQuestion1() {
        if (!::question1Fragment.isInitialized)
            question1Fragment = Question1Fragment()
        Router.attachFragment(
            this as? AppCompatActivity, R.id.frmMain, question1Fragment,
            FragmentTagConstants.forgotPasswordFragmentTag, true
        )
    }
}