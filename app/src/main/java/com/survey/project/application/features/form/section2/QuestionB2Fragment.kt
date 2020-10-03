package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
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
            PreferenceUtils.saveSentKidsToSchool(context, sentKidsToSchool)
            
            if (sentKidsToSchool == getString(R.string.yes_nepali)){
                gotToB3NextFragment()
            }else{
                gotToB4NextFragment()
            }
        }else{
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB2, activity)
    }

    private fun gotToB3NextFragment() {
        val b3Fragment =
            QuestionB3Fragment()
        (activity as Section2Activity)?.attachFragment(
            b3Fragment,
            FragmentTagConstants.questionB3
        )
    }

    private fun gotToB4NextFragment() {
        val b4Fragment =
            QuestionB4Fragment()
        (activity as Section2Activity)?.attachFragment(
            b4Fragment,
            FragmentTagConstants.questionB4
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