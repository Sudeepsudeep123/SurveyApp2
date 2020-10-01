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
import kotlinx.android.synthetic.main.fragment_b5.*

class QuestionB5Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(p0: View?) {
        when (p0) {
            btnNext -> {
                saveValuesAndGoToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
        }
    }

    private fun saveValuesAndGoToNextFragment() {
        val sonCountInCountry = edtCountrySon?.text.toString()
        val daughterCountInCountry = edtCountryDaughter?.text.toString()
        val sonCountInForeign = edtForeignSon?.text.toString()
        val daughterCountInForeign = edtForeignDaughter?.text.toString()

        PreferenceUtils.saveSonDaughterCountInCountryAndForeign(
            context,
            sonCountInCountry,
            daughterCountInCountry,
            sonCountInForeign,
            daughterCountInForeign
        )
        gotToNextFragment()
    }

    private fun gotToNextFragment() {
        val b6Fragment =
            QuestionB6Fragment()
        (activity as Section2Activity)?.attachFragment(
            b6Fragment,
            FragmentTagConstants.questionB6
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB5, activity)
    }

    private fun getAndSetData() {
        edtCountrySon.setText(PreferenceUtils.getSonCountInCountry(context))
        edtCountryDaughter.setText(PreferenceUtils.getDaughterCountInCountry(context))
        edtForeignSon.setText(PreferenceUtils.getSonCountInForeign(context))
        edtForeignDaughter.setText(PreferenceUtils.getDaughterCountInForeign(context))
    }
}