package com.survey.project.application.features.form.fragment

import android.os.Bundle
import android.util.Log
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
import kotlinx.android.synthetic.main.fragment_sixteen.*

class SixteenFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sixteen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                getRadioBtnVal()
                //   goToNextFragment()
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
        //  Utils.popBackStack(FragmentTagConstants.sixtenFragmentTag, activity)
    }

    private fun goToNextFragment() {
        //(activity as FormActivity)?.attachSeventeenthFragment()
        val sevFragment =
            SeventeenFragment()
        (activity as FormActivity)?.attachFragment(
            sevFragment,
            FragmentTagConstants.seventeenFragmentTag
        )
    }

    private fun getRadioBtnVal() {
        var ethnicity = ""
        val selectedEthnicity = rdgSixteen?.checkedRadioButtonId
        if (selectedEthnicity != null && selectedEthnicity != -1) {
            val selectedEthnicityRadioButton =
                view?.findViewById<View>(selectedEthnicity) as RadioButton
            ethnicity = selectedEthnicityRadioButton.text.toString()

            PreferenceUtils.saveEthnicity(context, ethnicity)
            goToNextFragment()
        } else {
            Toast.makeText(context, getString(R.string.select_one), Toast.LENGTH_SHORT).show()
        }
    }

    private fun getAndSetData() {
        when (PreferenceUtils.getEthnicity(context)) {
            getString(R.string.brahman) -> rdgSixteen.check(R.id.rdgBrahmin)
            getString(R.string.chhetri) -> rdgSixteen.check(R.id.rdgChhetri)
            getString(R.string.newar) -> rdgSixteen.check(R.id.rdgNewar)
            getString(R.string.gurung) -> rdgSixteen.check(R.id.rdgGurung)
            getString(R.string.magar) -> rdgSixteen.check(R.id.rdMagar)
            getString(R.string.tamang) -> rdgSixteen.check(R.id.rdgTamang)
            getString(R.string.thakuri) -> rdgSixteen.check(R.id.rdgThakuri)
            getString(R.string.damai) -> rdgSixteen.check(R.id.rdgDamai)
            getString(R.string.kami) -> rdgSixteen.check(R.id.rdgKami)
            getString(R.string.sarki) -> rdgSixteen.check(R.id.rdgSarki)
            getString(R.string.bk) -> rdgSixteen.check(R.id.rdgBk)
            getString(R.string.sarki) -> rdgSixteen.check(R.id.rdgSarki)
            getString(R.string.yadav) -> rdgSixteen.check(R.id.rdgYadav)
            getString(R.string.tharu) -> rdgSixteen.check(R.id.rdgTharu)
            getString(R.string.chaudhary) -> rdgSixteen.check(R.id.rdgChaudhary)
            getString(R.string.danuwar) -> rdgSixteen.check(R.id.rdgDanuwar)
            getString(R.string.other) -> rdgSixteen.check(R.id.rdgOther)
            else -> {
            }
        }
    }
}