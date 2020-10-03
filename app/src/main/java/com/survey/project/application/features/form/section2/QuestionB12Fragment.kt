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

class QuestionB12Fragment : Fragment(), View.OnClickListener {
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
                //show last list
                goToResultsFragment()
                //Toast.makeText(context, "Skip clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB12, activity)
    }

    private fun goToResultsFragment() {
        val resultsFrag =
            SectionBResults()
        (activity as Section2Activity)?.attachFragment(
            resultsFrag,
            FragmentTagConstants.sectionBResults
        )
    }

    private fun gotToNextFragment() {
        val b13Fragment =
            QuestionB13Fragment()
        (activity as Section2Activity)?.attachFragment(
            b13Fragment,
            FragmentTagConstants.questionB13
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
        btnSkip?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        var longTermDiseaseInFam = ""
        val selectedVal = lnlB7?.checkedRadioButtonId
        if (selectedVal != null && selectedVal != -1) {
            val selectedRadioButton = view?.findViewById<View>(selectedVal) as RadioButton

            longTermDiseaseInFam = selectedRadioButton.text.toString()
            PreferenceUtils.saveLongTermDiseaseInFam(context, longTermDiseaseInFam)
            if (longTermDiseaseInFam == getString(R.string.yes_nepali)) {
                gotToNextFragment()
            } else {
                //show last list
                goToResultsFragment()
                //Toast.makeText(context, "Skip clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getLongTermDiseaseInFam(context)) {
            getString(R.string.yes_nepali) -> lnlB7.check(R.id.edtYes)
            getString(R.string.no_nepali) -> lnlB7.check(R.id.edtNo)
            else -> {
            }
        }
    }

    private fun setUp() {
        txvQuestionB7?.text = getString(R.string.question_b12)
        btnSkip?.visibility = View.VISIBLE
    }
}