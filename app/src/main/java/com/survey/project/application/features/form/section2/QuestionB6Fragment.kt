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
import kotlinx.android.synthetic.main.fragment_b6.*

class QuestionB6Fragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b6, container, false)
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

    private fun gotToNextFragment() {
        val b7Fragment =
            QuestionB7Fragment()
        (activity as Section2Activity)?.attachFragment(
            b7Fragment,
            FragmentTagConstants.questionB7
        )
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.questionB6, activity)
    }

    private fun getAndSetData() {
        edtGhareluKamdarSon.setText(PreferenceUtils.getGhareluSonCount(context))
        edtGhareluKamdarDaughter.setText(PreferenceUtils.getGhareluDaughterCount(context))
        edtKarkhanaSon.setText(PreferenceUtils.getKarkhanaSonCount(context))
        edtKarkhanaDaughter.setText(PreferenceUtils.getKarkhanaDaughterCount(context))
        edtByaparSon.setText(PreferenceUtils.getByaparSonCount(context))
        edtByaparDaughter.setText(PreferenceUtils.getByaparDaughterCount(context))
        edtKrishiSon.setText(PreferenceUtils.getkrishiSonCount(context))
        edtKrishiDaughter.setText(PreferenceUtils.getkrishiDaughterCount(context))
        edtKaryalayaSon.setText(PreferenceUtils.getKaryalayaSonCount(context))
        edtKaryalayaDaughter.setText(PreferenceUtils.getKaryalayaDaughterCount(context))
        edtCircusSon.setText(PreferenceUtils.getCircusSonCount(context))
        edtCircusDaughter.setText(PreferenceUtils.getCircusDaughterCount(context))
    }

    private fun saveValuesAndGoToNextFragment() {
        if (edtGhareluKamdarSon.text.toString().isNotEmpty() && edtGhareluKamdarSon.text.toString()
                .isNotBlank() &&
            edtGhareluKamdarDaughter.text.toString()
                .isNotEmpty() && edtGhareluKamdarDaughter.text.toString().isNotBlank() &&
            edtKarkhanaSon.text.toString().isNotEmpty() && edtKarkhanaSon.text.toString()
                .isNotBlank() &&
            edtKarkhanaDaughter.text.toString().isNotEmpty() && edtKarkhanaDaughter.text.toString()
                .isNotBlank() &&
            edtByaparSon.text.toString().isNotEmpty() && edtByaparSon.text.toString()
                .isNotBlank() &&
            edtByaparDaughter.text.toString().isNotEmpty() && edtByaparDaughter.text.toString()
                .isNotBlank() &&
            edtKrishiSon.text.toString().isNotEmpty() && edtKrishiSon.text.toString()
                .isNotBlank() &&
            edtKrishiDaughter.text.toString().isNotEmpty() && edtKrishiDaughter.text.toString()
                .isNotBlank() &&
            edtKaryalayaSon.text.toString().isNotEmpty() && edtKaryalayaSon.text.toString()
                .isNotBlank() &&
            edtKaryalayaDaughter.text.toString()
                .isNotEmpty() && edtKaryalayaDaughter.text.toString().isNotBlank() &&
            edtCircusSon.text.toString().isNotEmpty() && edtCircusSon.text.toString()
                .isNotBlank() &&
            edtCircusDaughter.text.toString().isNotEmpty() && edtCircusDaughter.text.toString()
                .isNotBlank()
        ) {
            PreferenceUtils.saveSonDaughterLaborType(
                context,
                edtGhareluKamdarSon?.text.toString(),
                edtGhareluKamdarDaughter?.text.toString(),
                edtKarkhanaSon?.text.toString(),
                edtKarkhanaDaughter?.text.toString(),
                edtByaparSon?.text.toString(),
                edtByaparDaughter?.text.toString(),
                edtKrishiSon?.text.toString(),
                edtKrishiDaughter?.text.toString(),
                edtKaryalayaSon?.text.toString(),
                edtKaryalayaDaughter?.text.toString(),
                edtCircusSon?.text.toString(),
                edtCircusDaughter?.text.toString()
            )
            gotToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.invalid), Toast.LENGTH_SHORT).show()
        }
    }
}