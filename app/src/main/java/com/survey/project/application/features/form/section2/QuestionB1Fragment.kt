package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_b1.*

class QuestionB1Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetValues()
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
                saveValuesAndGoToNextFragment()
            }
        }
    }

    private fun saveValuesAndGoToNextFragment() {
        val maleCount = edtMaleCount?.text.toString()
        val femaleCount = edtFemaleCount?.text.toString()
        val thirdGenderCount = edtTHirdGenderCount?.text.toString()

        PreferenceUtils.saveDeadCount(context, maleCount, femaleCount, thirdGenderCount)
        gotToNextFragment()
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB1, activity)
    }

    private fun gotToNextFragment() {
        val b2Fragment =
            QuestionB2Fragment()
        (activity as Section2Activity)?.attachFragment(
            b2Fragment,
            FragmentTagConstants.questionB2
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun getAndSetValues() {
        val maleCount = PreferenceUtils.getMaleDeadCount(context)
        val femaleCount = PreferenceUtils.getFemaleDeadCount(context)
        val thirdGenderCount = PreferenceUtils.getThirdGenderDeadCount(context)

        edtMaleCount.setText(maleCount)
        edtFemaleCount.setText(femaleCount)
        edtTHirdGenderCount.setText(thirdGenderCount)
    }
}