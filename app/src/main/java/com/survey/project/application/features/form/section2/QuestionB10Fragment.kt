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
import kotlinx.android.synthetic.main.fragment_b10.*

class QuestionB10Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b10, container, false)
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
        Utils.popBackStack(FragmentTagConstants.questionB10, activity)
    }

    private fun gotToNextFragment() {
        val b11Fragment =
            QuestionB11Fragment()
        (activity as Section2Activity)?.attachFragment(
            b11Fragment,
            FragmentTagConstants.questionB11
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun saveValuesAndGoToNextFragment() {
        if (edtMentalIllness?.text.toString().isNotEmpty() && edtMentalIllness?.text.toString()
                .isNotBlank() &&
            edtAutism?.text.toString().isNotEmpty() && edtAutism?.text.toString().isNotBlank() &&
            edtOther?.text.toString().isNotEmpty() && edtOther?.text.toString().isNotBlank()
        ) {
            PreferenceUtils.saveDiseasesInFam(
                context,
                edtMentalIllness?.text.toString(),
                edtAutism?.text.toString(),
                edtOther?.text.toString()
            )
            gotToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.invalid), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        edtMentalIllness?.setText(PreferenceUtils.getMentalIllnessCount(context))
        edtAutism?.setText(PreferenceUtils.getAutismCount(context))
        edtOther?.setText(PreferenceUtils.getOtherCount(context))
    }
}