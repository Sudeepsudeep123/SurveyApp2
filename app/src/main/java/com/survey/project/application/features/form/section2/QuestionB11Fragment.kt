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
import kotlinx.android.synthetic.main.fragment_b11.*

class QuestionB11Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b11, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                saveValuesAndGoToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB11, activity)
    }

    private fun gotToNextFragment() {
        val b12Fragment =
            QuestionB12Fragment()
        (activity as Section2Activity)?.attachFragment(
            b12Fragment,
            FragmentTagConstants.questionB12
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        PreferenceUtils.saveCardType(
            context,
            rdbRed?.text.toString(),
            rdbBlue?.text.toString(),
            rdbYellow?.text.toString(),
            rdbWhite?.text.toString()
        )
        gotToNextFragment()
    }

    private fun getAndSetData() {
        rdbRed?.setText(PreferenceUtils.getRedCardCount(context))
        rdbBlue?.setText(PreferenceUtils.getBlueCardCount(context))
        rdbYellow?.setText(PreferenceUtils.getYellowCardCount(context))
        rdbWhite?.setText(PreferenceUtils.getWhiteCardCount(context))
    }
}