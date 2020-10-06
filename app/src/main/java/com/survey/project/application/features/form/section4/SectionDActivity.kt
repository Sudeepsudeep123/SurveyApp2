package com.survey.project.application.features.form.section4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router

class SectionDActivity : AppCompatActivity() {
    private lateinit var questionD1Fragment: QuestionD1Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section4)
        showQuestionD1()
    }

    private fun showQuestionD1() {
        if (::questionD1Fragment.isInitialized) {
            questionD1Fragment = QuestionD1Fragment()
        }
        attachFragment(questionD1Fragment, FragmentTagConstants.questionD1)
    }

    fun attachFragment(fragment: Fragment, fragmentTag: String) {
        Router.attachFragment(
            this,
            R.id.frmSectionD,
            fragment,
            fragmentTag,
            true
        )
    }
}