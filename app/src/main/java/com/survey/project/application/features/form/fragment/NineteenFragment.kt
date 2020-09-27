package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_nineteen.*

class NineteenFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nineteen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                getSelectedAndSaveToPreference()
                //  goToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
        }
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.nineteenFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            TwentyFragment()
        (activity as FormActivity).attachFragment(
            fragment,
            FragmentTagConstants.twentyFragmentTag
        )
    }

    fun getSelectedAndSaveToPreference() {
        val result = StringBuilder()
        // result.append("Selected Items:")
        var i = 0
        if (chb1.isChecked) {
            i++
            result.append("$i " + getString(R.string.hosue_type_one))
        }
        if (chb2.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.hosue_type_two))
        }
        if (chb3.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.hosue_type_three))
        }
        if (chb4.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.hosue_type_four))
        }
        if (chb5.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.hosue_type_five))
        }
        if (chb6.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.hosue_type_six))
        }
        if (chb7.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.other))
        }
        //  Log.d("resultValueK", result.toString())
        PreferenceUtils.saveHouseCount(context, i)
        PreferenceUtils.saveHouseType(context, result.toString())
        goToNextFragment()
    }

    fun getAndSetData() {
        val houseCount = PreferenceUtils.getHouseCount(context)
        val hoseTypes = PreferenceUtils.getHouseType(context)

        if (houseCount != 0) {
            for (i in 1 .. houseCount) {
                val type = hoseTypes.substringAfter("$i ").substringBefore("\n")

                when (type){
                    getString(R.string.hosue_type_one) -> chb1.isChecked = true
                    getString(R.string.hosue_type_two) -> chb2.isChecked = true
                    getString(R.string.hosue_type_three) -> chb3.isChecked = true
                    getString(R.string.hosue_type_four) -> chb4.isChecked = true
                    getString(R.string.hosue_type_five) -> chb5.isChecked = true
                    getString(R.string.hosue_type_six) -> chb6.isChecked = true
                    getString(R.string.other) -> chb7.isChecked = true
                }

            }
        }
    }
}