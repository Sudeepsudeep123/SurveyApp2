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
import kotlinx.android.synthetic.main.fragment_twenty_nine.*

class TwentyNIneFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_twenty_nine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> saveAndGoToNextFragment()
            btnPrevious -> goToPreviousFragment()
        }
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.twentyNineFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val fragment =
            ThirtyFragment()
        (activity as FormActivity)?.attachFragment(
            fragment,
            FragmentTagConstants.thirtyFragmentTag
        )
    }

    private fun saveAndGoToNextFragment() {
        val result = StringBuilder()
        // result.append("Selected Items:")
        var i = 0
        if (chb1.isChecked) {
            i++
            result.append("$i " + getString(R.string.b1))
        }
        if (chb2.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b2))
        }
        if (chb3.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b3))
        }
        if (chb4.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b4))
        }
        if (chb5.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b5))
        }
        if (chb6.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b6))
        }
        if (chb7.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b7))
        }
        if (chb8.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b8))
        }
        if (chb9.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b9))
        }
        if (chb10.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b10))
        }
        if (chb11.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b11))
        }
        if (chb12.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b12))
        }
        if (chb13.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b13))
        }
        if (chb14.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b14))
        }
        if (chb15.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b15))
        }
        if (chb16.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b16))
        }
        if (chb17.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b17))
        }
        if (chb18.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b18))
        }
        if (chb19.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b19))
        }
        if (chb20.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b20))
        }
        if (chb21.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b21))
        }
        if (chb22.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b22))
        }
        if (chb23.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b23))
        }
        if (chb24.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b24))
        }
        if (chb25.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b25))
        }
        if (chb26.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b26))
        }
        if (chb27.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b27))
        }
        if (chb28.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b28))
        }
        if (chb29.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b29))
        }
        if (chb30.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b30))
        }
        if (chb31.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b31))
        }
        if (chb32.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b31))
        }
        if (chb33.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b33))
        }
        if (chb34.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b34))
        }
        if (chb35.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b35))
        }
        if (chb36.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b36))
        }
        if (chb37.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b37))
        }
        if (chb38.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b38))
        }
        if (chb39.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b39))
        }
        if (chb40.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b40))
        }
        if (chb41.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b41))
        }
        if (chb42.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b42))
        }
        if (chb43.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b43))
        }
        if (chb44.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b44))
        }
        if (chb45.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b45))
        }
        if (chb46.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b46))
        }
        if (chb47.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b47))
        }
        if (chb48.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b48))
        }
        if (chb49.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b49))
        }
        if (chb50.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b50))
        }
        if (chb51.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b51))
        }
        if (chb52.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b52))
        }
        if (chb53.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b53))
        }
        if (chb54.isChecked) {
            i++
            result.append("\n$i " + getString(R.string.b54))
        }
        //  Log.d("resultValueK", result.toString())
        PreferenceUtils.saveBusinessCount(context, i)
        PreferenceUtils.saveBusinessType(context, result.toString())
        goToNextFragment()
    }

    fun getAndSetData() {
        val businessCount = PreferenceUtils.getBusinessCount(context)
        val businessTypes = PreferenceUtils.getBusinessType(context)

        if (businessCount != 0) {
            for (i in 1..businessCount) {
                val type = businessTypes.substringAfter("$i ").substringBefore("\n")

                when (type) {
                    getString(R.string.b1) -> chb1.isChecked = true
                    getString(R.string.b2) -> chb2.isChecked = true
                    getString(R.string.b3) -> chb3.isChecked = true
                    getString(R.string.b4) -> chb4.isChecked = true
                    getString(R.string.b5) -> chb5.isChecked = true
                    getString(R.string.b6) -> chb6.isChecked = true
                    getString(R.string.b7) -> chb7.isChecked = true
                    getString(R.string.b8) -> chb8.isChecked = true
                    getString(R.string.b9) -> chb9.isChecked = true
                    getString(R.string.b10) -> chb10.isChecked = true
                    getString(R.string.b11) -> chb11.isChecked = true
                    getString(R.string.b12) -> chb12.isChecked = true
                    getString(R.string.b13) -> chb13.isChecked = true
                    getString(R.string.b14) -> chb14.isChecked = true
                    getString(R.string.b15) -> chb15.isChecked = true
                    getString(R.string.b16) -> chb16.isChecked = true
                    getString(R.string.b17) -> chb17.isChecked = true
                    getString(R.string.b18) -> chb18.isChecked = true
                    getString(R.string.b19) -> chb19.isChecked = true
                    getString(R.string.b20) -> chb20.isChecked = true
                    getString(R.string.b21) -> chb21.isChecked = true
                    getString(R.string.b22) -> chb22.isChecked = true
                    getString(R.string.b23) -> chb23.isChecked = true
                    getString(R.string.b24) -> chb24.isChecked = true
                    getString(R.string.b25) -> chb25.isChecked = true
                    getString(R.string.b26) -> chb26.isChecked = true
                    getString(R.string.b27) -> chb27.isChecked = true
                    getString(R.string.b28) -> chb28.isChecked = true
                    getString(R.string.b29) -> chb29.isChecked = true
                    getString(R.string.b30) -> chb30.isChecked = true
                    getString(R.string.b31) -> chb31.isChecked = true
                    getString(R.string.b32) -> chb32.isChecked = true
                    getString(R.string.b33) -> chb33.isChecked = true
                    getString(R.string.b34) -> chb34.isChecked = true
                    getString(R.string.b35) -> chb35.isChecked = true
                    getString(R.string.b36) -> chb36.isChecked = true
                    getString(R.string.b37) -> chb37.isChecked = true
                    getString(R.string.b38) -> chb38.isChecked = true
                    getString(R.string.b39) -> chb39.isChecked = true
                    getString(R.string.b40) -> chb40.isChecked = true
                    getString(R.string.b41) -> chb41.isChecked = true
                    getString(R.string.b42) -> chb42.isChecked = true
                    getString(R.string.b43) -> chb43.isChecked = true
                    getString(R.string.b44) -> chb44.isChecked = true
                    getString(R.string.b45) -> chb45.isChecked = true
                    getString(R.string.b46) -> chb46.isChecked = true
                    getString(R.string.b47) -> chb47.isChecked = true
                    getString(R.string.b48) -> chb48.isChecked = true
                    getString(R.string.b49) -> chb49.isChecked = true
                    getString(R.string.b50) -> chb50.isChecked = true
                    getString(R.string.b51) -> chb51.isChecked = true
                    getString(R.string.b52) -> chb52.isChecked = true
                    getString(R.string.b53) -> chb53.isChecked = true
                    getString(R.string.b54) -> chb54.isChecked = true
                }
            }
        }
    }
}