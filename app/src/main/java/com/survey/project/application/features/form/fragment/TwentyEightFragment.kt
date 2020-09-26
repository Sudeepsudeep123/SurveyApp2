package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_twenty_eight.*

class TwentyEightFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_eight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> saveValuesAndGoToNextFragment()
            btnPrevious -> goToPreviousFragment()
        }
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.twentyEightFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyNIneFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.twentyNineFragmentTag
        )
    }

    private fun saveValuesAndGoToNextFragment() {
        val maleUnemployed = edtMaleUnemployedCount?.text.toString()
        val femaleUnemployed = edtFemaleUnemployed?.text.toString()
        val thirdGenderUnemployed = edtThirdGenderUnemployed?.text.toString()
        val combination = "$maleUnemployed/$femaleUnemployed/$thirdGenderUnemployed"
        PreferenceUtils.saveUnemployedCount(context, maleUnemployed, femaleUnemployed, thirdGenderUnemployed)
        goToNextFragment()
    }

    private fun getAndSetData() {
        val maleCount = PreferenceUtils.getMaleUnemployedCount(context)
        val femaleCount = PreferenceUtils.getFemaleUnemployedCount(context)
        val thirdGenderCount = PreferenceUtils.getThirdUnemployedCount(context)

        edtMaleUnemployedCount?.setText(maleCount)
        edtFemaleUnemployed?.setText(femaleCount)
        edtThirdGenderUnemployed?.setText(thirdGenderCount)
    }
}