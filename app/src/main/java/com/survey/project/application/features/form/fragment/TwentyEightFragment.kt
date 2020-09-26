package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_twenty_nine.*

class TwentyEightFragment : Fragment(), View.OnClickListener {
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
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> goToNextFragment()
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
}