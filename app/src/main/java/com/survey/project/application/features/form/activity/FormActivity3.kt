package com.survey.project.application.features.form.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.survey.project.application.R
import com.survey.project.application.features.form.section3.Fragment1Sec3
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router

class FormActivity3 : AppCompatActivity() {
    private lateinit var question1Fragment: Fragment1Sec3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form3)
        showQuestion1()
    }

    private fun showQuestion1() {
        if (!::question1Fragment.isInitialized)
            question1Fragment = Fragment1Sec3()

        Router.attachFragment(
            this, R.id.frmMain3, question1Fragment,
            FragmentTagConstants.question1Fragment, true
        )
    }
}