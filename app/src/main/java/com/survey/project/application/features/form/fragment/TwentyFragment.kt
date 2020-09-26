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
import kotlinx.android.synthetic.main.fragment_twenty.*

class TwentyFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty, container, false)
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
        Utils.popBackStack(FragmentTagConstants.twentyFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyOneFragment()
        (activity as FormActivity).attachFragment(
            fragment,
            FragmentTagConstants.twentyOneFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var houseOwnership = ""
        val selectedOwnership = rdgTwenty?.checkedRadioButtonId
        if (selectedOwnership != null && selectedOwnership != -1) {
            val selectedLanguageRadioButton =
                view?.findViewById<View>(selectedOwnership) as RadioButton
            houseOwnership = selectedLanguageRadioButton.text.toString()
        }
        PreferenceUtils.saveHouseOwnership(context, houseOwnership)
        goToNextFragment()
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getHouseOwnership(context)) {
            getString(R.string.house_ownership_one) -> rdgTwenty?.check(R.id.rdgTypeOne)
            getString(R.string.house_ownership_two) -> rdgTwenty?.check(R.id.rdgTypeTwo)
            getString(R.string.house_ownership_three) -> rdgTwenty?.check(R.id.rdgTypeThree)
            getString(R.string.house_ownership_four) -> rdgTwenty?.check(R.id.rdgTypeFour)
            getString(R.string.other) -> rdgTwenty?.check(R.id.rdgTypeFive)
            else -> {
            }
        }
    }
}