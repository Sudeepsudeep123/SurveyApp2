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

class QuestionB7Fragment : Fragment(), View.OnClickListener {
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
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB7, activity)
    }

    private fun gotToB8Fragment() {
        val b8Fragment =
            QuestionB8Fragment()
        (activity as Section2Activity)?.attachFragment(
            b8Fragment,
            FragmentTagConstants.questionB8
        )
    }

    private fun gotToB9Fragment() {
        val b9Fragment =
            QuestionB9Fragment()
        (activity as Section2Activity)?.attachFragment(
            b9Fragment,
            FragmentTagConstants.questionB9
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        var gotYourKidMarriedBefore18 = ""
        val selectedVal = lnlB7?.checkedRadioButtonId
        if (selectedVal != null && selectedVal != -1) {
            val selectedRadioButton = view?.findViewById<View>(selectedVal) as RadioButton

            gotYourKidMarriedBefore18 = selectedRadioButton.text.toString()
            PreferenceUtils.savKidMarriedBefore18(context, gotYourKidMarriedBefore18)

            if (gotYourKidMarriedBefore18 == getString(R.string.yes_nepali)) {
                gotToB8Fragment()
            } else {
                gotToB9Fragment()
            }
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getKidMarriedBefore18(context)) {
            getString(R.string.yes_nepali) -> lnlB7.check(R.id.edtYes)
            getString(R.string.no_nepali) -> lnlB7.check(R.id.edtNo)
            else -> {
            }
        }
    }
}