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
        /* val b12Fragment =
             QuestionB12Fragment()
         (activity as Section2Activity)?.attachFragment(
             b12Fragment,
             FragmentTagConstants.questionB12
         )*/
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        if (rdbTb?.text.toString().isNotEmpty() && rdbTb?.text.toString().isNotBlank() &&
            rdbCancer?.text.toString().isNotEmpty() && rdbCancer?.text.toString().isNotBlank() &&
            rdbHiv?.text.toString().isNotEmpty() && rdbHiv?.text.toString().isNotBlank() &&
            rdbSugar?.text.toString().isNotEmpty() && rdbSugar?.text.toString().isNotBlank() &&
            rdbBp?.text.toString().isNotEmpty() && rdbBp?.text.toString().isNotBlank() &&
            rdbOther?.text.toString().isNotEmpty() && rdbOther?.text.toString().isNotBlank()
        ) {
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
        } else {
            Toast.makeText(context, getString(R.string.invalid), Toast.LENGTH_SHORT).show()
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