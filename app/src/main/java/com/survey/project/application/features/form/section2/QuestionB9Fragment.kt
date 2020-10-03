package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_b7.*

class QuestionB9Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        setUp()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                saveValuesAndGoToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
            btnSkip -> {
                PreferenceUtils.saveDifferentlyAbledInFam(context, getString(R.string.no_nepali))
                gotToB12Fragment()
            }
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB9, activity)
    }

    private fun gotToB10Fragment() {
        val b10Fragment =
            QuestionB10Fragment()
        (activity as Section2Activity)?.attachFragment(
            b10Fragment,
            FragmentTagConstants.questionB10
        )
    }

    private fun gotToB12Fragment() {
        val b12Fragment =
            QuestionB12Fragment()
        (activity as Section2Activity)?.attachFragment(
            b12Fragment,
            FragmentTagConstants.questionB12
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
        btnSkip?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        var differentlyAbledInFam = ""
        val selectedVal = lnlB7?.checkedRadioButtonId
        if (selectedVal != null && selectedVal != -1) {
            val selectedRadioButton = view?.findViewById<View>(selectedVal) as RadioButton

            differentlyAbledInFam = selectedRadioButton.text.toString()

            PreferenceUtils.saveDifferentlyAbledInFam(context, differentlyAbledInFam)

            if (differentlyAbledInFam == getString(R.string.yes_nepali)) {
                gotToB10Fragment()
            } else {
                gotToB12Fragment()
            }
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getDifferentlyAbledInFam(context)) {
            getString(R.string.yes_nepali) -> lnlB7.check(R.id.edtYes)
            getString(R.string.no_nepali) -> lnlB7.check(R.id.edtNo)
            else -> {
            }
        }
    }

    private fun setUp() {
        txvQuestionB7?.text = getString(R.string.question_b9)
        btnSkip?.visibility = View.VISIBLE
    }
}