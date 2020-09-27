package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_twenty_seven.*

class TwentySevenFragment  : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_seven, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> saveValuesANdGoToNextFragment()
            btnPrevious -> goToPreviousFragment()
        }
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.twentySevenFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyEightFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.twentyEightFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var unEmployedYesOrNo = ""
        val selectedBankAccPresent = rdgTwentySeven?.checkedRadioButtonId
        if (selectedBankAccPresent != null && selectedBankAccPresent != -1) {
            val selectedRentedLandRadioButton =
                view?.findViewById<View>(selectedBankAccPresent) as RadioButton
            unEmployedYesOrNo = selectedRentedLandRadioButton.text.toString()
            PreferenceUtils.saveAnyoneUnemployedInFam(context, unEmployedYesOrNo)
            goToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getAnyoneUnemployedInFam(context)) {
            getString(R.string.yes_nepali) -> rdgTwentySeven?.check(R.id.rdgTypeOne)
            getString(R.string.no_nepali) -> rdgTwentySeven?.check(R.id.rdgTypeTwo)
            else -> {
            }
        }
    }
}