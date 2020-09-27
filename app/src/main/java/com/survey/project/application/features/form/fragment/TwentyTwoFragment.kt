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
import kotlinx.android.synthetic.main.fragment_twenty_two.*

class TwentyTwoFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_two, container, false)
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
        Utils.popBackStack(FragmentTagConstants.twentyTwoFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyThreeFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.twentyThreeFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var rentedLand = ""
        val selectedRentedLand = rdgTwentyTwo?.checkedRadioButtonId
        if (selectedRentedLand != null && selectedRentedLand != -1) {
            val selectedRentedLandRadioButton =
                view?.findViewById<View>(selectedRentedLand) as RadioButton
            rentedLand = selectedRentedLandRadioButton.text.toString()

            PreferenceUtils.saveRentedLandValue(context, rentedLand)
            goToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getRentedLandValue(context)) {
            getString(R.string.yes_nepali) -> rdgTwentyTwo?.check(R.id.rdgTypeOne)
            getString(R.string.no_nepali) -> rdgTwentyTwo?.check(R.id.rdgTypeTwo)
            else -> {
            }
        }
    }
}