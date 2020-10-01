package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_b2.*

class QuestionB2Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b2, container, false)
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

    private fun saveValuesAndGoToNextFragment() {
        var sentKidsToSchool = ""
        val selectedVal = rdgB2?.checkedRadioButtonId
        if (selectedVal != null && selectedVal != -1) {
            val selectedRadioButton = view?.findViewById<View>(selectedVal) as RadioButton

            sentKidsToSchool = selectedRadioButton.text.toString()
        }

        PreferenceUtils.saveSentKidsToSchool(context, sentKidsToSchool)
        gotToNextFragment()
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB2, activity)
    }

    private fun gotToNextFragment() {
        val b3Fragment =
            QuestionB3Fragment()
        (activity as Section2Activity)?.attachFragment(
            b3Fragment,
            FragmentTagConstants.questionB3
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun getAndSetData() {
        val sentKidsToSchool = PreferenceUtils.getSendKidsToSchool(context)

        when (sentKidsToSchool) {
            getString(R.string.yes_nepali) -> rdgB2?.check(R.id.edtYes)
            getString(R.string.no_nepali) -> rdgB2?.check(R.id.edtNo)
            else -> {
            }
        }
    }
}