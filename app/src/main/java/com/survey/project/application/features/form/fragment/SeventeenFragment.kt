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
import kotlinx.android.synthetic.main.fragment_seventeen.*

class SeventeenFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seventeen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                saveValueAndDoToNExtFragment()
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
        Utils.popBackStack(FragmentTagConstants.seventeenFragmentTag, activity)
    }

    private fun goToNextFragment() {
        val sevFragment =
            EighteenFragment()
        (activity as FormActivity)?.attachFragment(
            sevFragment,
            FragmentTagConstants.eighteenFragmentTag
        )
    }

    private fun saveValueAndDoToNExtFragment() {
        var religion = ""
        var selectedReligion = rdgSeventeen?.checkedRadioButtonId

        if (selectedReligion != null && selectedReligion != -1) {
            val selectedReligionRadioButton =
                view?.findViewById<View>(selectedReligion) as RadioButton
            religion = selectedReligionRadioButton.text.toString()

            PreferenceUtils.saveReligion(context, religion)
            goToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getReligion(context)) {
            getString(R.string.hindu) -> rdgSeventeen?.check(R.id.rdgHindu)
            getString(R.string.buddhism) -> rdgSeventeen?.check(R.id.rdgBuddhism)
            getString(R.string.christian) -> rdgSeventeen?.check(R.id.rdgChristian)
            getString(R.string.muslim) -> rdgSeventeen?.check(R.id.rdgMuslim)
            getString(R.string.kirati) -> rdgSeventeen?.check(R.id.rdgKirati)
            getString(R.string.other) -> rdgSeventeen?.check(R.id.rdgOther)
            getString(R.string.empty_string) -> {
            }
            else -> {
                rdgSeventeen?.check(R.id.rdgHindu)
            }
        }
    }
}