package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_twenty_one.*

class TwentyOneFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_one, container, false)
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
        Utils.popBackStack(FragmentTagConstants.twentyOneFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyTwoFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.twentyTwoFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var houseRented = ""
        val selectedOwnership = rdgTwentyOne?.checkedRadioButtonId
        if (selectedOwnership != null && selectedOwnership != -1) {
            val selectedLanguageRadioButton =
                view?.findViewById<View>(selectedOwnership) as RadioButton
            houseRented = selectedLanguageRadioButton.text.toString()
        }
        PreferenceUtils.saveRentedHouseValue(context, houseRented)
        goToNextFragment()
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getRentedHouseValue(context)) {
            getString(R.string.yes_nepali) -> rdgTwentyOne?.check(R.id.rdgTypeOne)
            getString(R.string.no_nepali) -> rdgTwentyOne?.check(R.id.rdgTypeTwo)
            else -> {
            }
        }
    }
}