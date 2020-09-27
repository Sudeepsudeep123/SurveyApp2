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
import kotlinx.android.synthetic.main.fragment_twenty_five.*

class TwentyFiveFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_five, container, false)
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
        Utils.popBackStack(FragmentTagConstants.twentyFiveFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentySixFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.twentySixFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var bankAccPresent = ""
        val selectedBankAccPresent = rdgTwentyFive?.checkedRadioButtonId
        if (selectedBankAccPresent != null && selectedBankAccPresent != -1) {
            val selectedRentedLandRadioButton =
                view?.findViewById<View>(selectedBankAccPresent) as RadioButton
            bankAccPresent = selectedRentedLandRadioButton.text.toString()
            PreferenceUtils.saveIsBankAccountPresentValue(context, bankAccPresent)
            goToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.isBankAccountPresentValue(context)) {
            getString(R.string.yes_nepali) -> rdgTwentyFive?.check(R.id.rdgTypeOne)
            getString(R.string.no_nepali) -> rdgTwentyFive?.check(R.id.rdgTypeTwo)
            else -> {
            }
        }
    }
}