package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import com.survey.project.application.utils.util.Utils
import kotlinx.android.synthetic.main.fragment_eighteen.*
import kotlinx.android.synthetic.main.fragment_eighteen.btnNext
import kotlinx.android.synthetic.main.fragment_eighteen.btnPrevious
import kotlinx.android.synthetic.main.fragment_sixteen.*

class EighteenFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_eighteen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                saveValuesANdGoToNextFragment()
            }
            btnPrevious -> {
                goToPreviousFragment()
            }
        }
    }

    private fun initListener() {
        btnNext?.setOnClickListener(this)
        btnPrevious?.setOnClickListener(this)
    }

    private fun goToPreviousFragment() {
        Utils.popBackStack(FragmentTagConstants.eighteenFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val sevFragment =
            NineteenFragment()
        (activity as FormActivity)?.attachFragment(
            sevFragment,
            FragmentTagConstants.nineteenFragmentTag
        )
    }

    private fun saveValuesANdGoToNextFragment() {
        var motherTongue = ""
        val selectedLanguage = rdgEighteen?.checkedRadioButtonId
        if (selectedLanguage != null && selectedLanguage != -1) {
            val selectedLanguageRadioButton =
                view?.findViewById<View>(selectedLanguage) as RadioButton
            motherTongue = selectedLanguageRadioButton.text.toString()

            PreferenceUtils.saveMotherTongue(context, motherTongue)
            goToNextFragment()
        }else{
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getMotherTongue(context)) {
            getString(R.string.nepali) -> rdgEighteen?.check(R.id.rdgNepali)
            getString(R.string.newari) -> rdgEighteen?.check(R.id.rdgNewari)
            getString(R.string.magar) -> rdgEighteen?.check(R.id.rdgMagar)
            getString(R.string.gurung) -> rdgEighteen?.check(R.id.rdgGurung)
            getString(R.string.tamang) -> rdgEighteen?.check(R.id.rdgTamang)
            getString(R.string.muslim) -> rdgEighteen?.check(R.id.rdgMuslim)
            getString(R.string.tharu) -> rdgEighteen?.check(R.id.rdgTharu)
            getString(R.string.rai) -> rdgEighteen?.check(R.id.rdgRai)
            getString(R.string.other) -> rdgEighteen?.check(R.id.rdgOther)
            else -> {
            }
        }
    }
}