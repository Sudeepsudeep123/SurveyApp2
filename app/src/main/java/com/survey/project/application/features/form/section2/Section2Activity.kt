package com.survey.project.application.features.form.section2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router

class Section2Activity : AppCompatActivity() {
    private lateinit var questionB1Fragment: QuestionB1Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section2)
        showQuestionB1()
    }

    private fun showQuestionB1() {
        if (!::questionB1Fragment.isInitialized) {
            questionB1Fragment = QuestionB1Fragment()
        }
        attachFragment(questionB1Fragment, FragmentTagConstants.questionB1)
    }

    fun attachFragment(fragment: Fragment, fragmentTag: String) {
        Router.attachFragment(
            this,
            R.id.frmSectionB,
            fragment,
            fragmentTag,
            true
        )
    }
}