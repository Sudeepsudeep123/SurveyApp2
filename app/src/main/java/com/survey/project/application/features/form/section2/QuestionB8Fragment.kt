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
import kotlinx.android.synthetic.main.fragment_b8.*

class QuestionB8Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b8, container, false)
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
                //   goToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB8, activity)
    }

    private fun gotToNextFragment() {
        val b9Fragment =
            QuestionB9Fragment()
        (activity as Section2Activity)?.attachFragment(
            b9Fragment,
            FragmentTagConstants.questionB9
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun getAndSetData() {
        val sonMarriedBefore18 = PreferenceUtils.getSonMarriedBefore18(context)
        val daughterMarriedBefore18 = PreferenceUtils.getDaughterMarriedBefore18(context)
        edtSon?.setText(sonMarriedBefore18)
        edtDaughter?.setText(daughterMarriedBefore18)
    }

    private fun saveValuesAndGoToNextFragment() {
        val sonCountMarriedBefore18 = edtSon?.text.toString()
        val daughterCountMarriedBefore18 = edtDaughter?.text.toString()

        PreferenceUtils.saveSonDaughterMarriedBefore18(
            context,
            sonCountMarriedBefore18,
            daughterCountMarriedBefore18
        )
        gotToNextFragment()
    }
}