package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_b13.*

class QuestionB13Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b13, container, false)
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
        Utils.popBackStack(FragmentTagConstants.questionB13, activity)
    }

    private fun gotToNextFragment() {
        //show Last list
        Toast.makeText(context, "END", Toast.LENGTH_SHORT).show()
        val resutsFragment =
            SectionBResults()
        (activity as Section2Activity)?.attachFragment(
            resutsFragment,
            FragmentTagConstants.sectionBResults
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        if (rdbTb?.text.toString().isEmpty() && rdbTb?.text.toString().isBlank() &&
            rdbCancer?.text.toString().isEmpty() && rdbCancer?.text.toString().isBlank() &&
            rdbHiv?.text.toString().isEmpty() && rdbHiv?.text.toString().isBlank() &&
            rdbSugar?.text.toString().isEmpty() && rdbSugar?.text.toString().isBlank() &&
            rdbBp?.text.toString().isEmpty() && rdbBp?.text.toString().isBlank() &&
            rdbOther?.text.toString().isEmpty() && rdbOther?.text.toString().isBlank()
        ) {
            Toast.makeText(context, getString(R.string.invalid), Toast.LENGTH_SHORT).show()
        } else {
            PreferenceUtils.saveDisesesCount(
                context,
                rdbTb?.text.toString(),
                rdbCancer?.text.toString(),
                rdbHiv?.text.toString(),
                rdbSugar?.text.toString(),
                rdbBp?.text.toString(),
                rdbOther?.text.toString()
            )
            gotToNextFragment()
        }
    }

    private fun getAndSetData() {
        rdbTb?.setText(PreferenceUtils.getTbCount(context))
        rdbCancer?.setText(PreferenceUtils.getCancerCount(context))
        rdbHiv?.setText(PreferenceUtils.getHivCount(context))
        rdbSugar?.setText(PreferenceUtils.getSugarCount(context))
        rdbBp?.setText(PreferenceUtils.getBpCount(context))
        rdbOther?.setText(PreferenceUtils.getOtherIllnessCount(context))
    }
}