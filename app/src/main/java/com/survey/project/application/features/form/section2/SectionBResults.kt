package com.survey.project.application.features.form.section2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.util.PreferenceUtils
import kotlinx.android.synthetic.main.fragment_sectionb_results.*

class SectionBResults : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sectionb_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        getAndSetData()
    }

    override fun onClick(view: View?) {
        when (view) {
            btnCancel -> {
                //clear Preference

            }
            btnComplete -> {
                //go to section C
                //  goToPreviousFragment()
            }
        }
    }

    private fun initListener() {

    }

    private fun getAndSetData() {
        txvMaleDead?.text = PreferenceUtils.getMaleDeadCount(context)
        txvFemaleDead?.text = PreferenceUtils.getFemaleDeadCount(context)
        txvThirdGenderDead?.text = PreferenceUtils.getThirdGenderDeadCount(context)

        val sentToSchool = PreferenceUtils.getSendKidsToSchool(context)
        txvSentKidToSchool.text = sentToSchool
        if (sentToSchool == getString(R.string.yes_nepali)) {
            rllQb3?.visibility = View.VISIBLE
            txvSchoolType.text = PreferenceUtils.getSchoolType(context)
        } else {
            rllQb3?.visibility = View.GONE
        }

        val childLabor = PreferenceUtils.getChildLaborValue(context)
        txvChildLabor?.text = childLabor

        if (childLabor == getString(R.string.yes_nepali)) {
            rllQb5?.visibility = View.VISIBLE
            rllQb6?.visibility = View.VISIBLE

            //b5
            val sonInCountry = PreferenceUtils.getSonCountInCountry(context)
            val daughterInCountry = PreferenceUtils.getDaughterCountInCountry(context)
            val sonInInForeign = PreferenceUtils.getSonCountInForeign(context)
            val daughterInInForeign = PreferenceUtils.getDaughterCountInForeign(context)

            txvInCountry.text =
                "${getString(R.string.in_country)}: ${getString(R.string.son)}:$sonInCountry  " +
                        "${getString(R.string.daughter)}:$daughterInCountry"

            txvInForeign.text =
                "${getString(R.string.in_country)}: ${getString(R.string.son)}:$sonInInForeign  " +
                        "${getString(R.string.daughter)}:$daughterInInForeign"

            //b6
            val ghareluSon = PreferenceUtils.getGhareluSonCount(context)
            val ghareluDaughter = PreferenceUtils.getGhareluDaughterCount(context)
            val karkhanaSon = PreferenceUtils.getKarkhanaSonCount(context)
            val karkhanaDaughter = PreferenceUtils.getKarkhanaDaughterCount(context)
            val byaparSon = PreferenceUtils.getByaparSonCount(context)
            val byaparDaughter = PreferenceUtils.getByaparDaughterCount(context)
            val krishiSon = PreferenceUtils.getkrishiSonCount(context)
            val krishiDaughter = PreferenceUtils.getkrishiDaughterCount(context)
            val karyalayaSon = PreferenceUtils.getKaryalayaSonCount(context)
            val karyalayaDaughter = PreferenceUtils.getKaryalayaDaughterCount(context)
            val circusSon = PreferenceUtils.getCircusSonCount(context)
            val circusDaughter = PreferenceUtils.getCircusDaughterCount(context)

            txvGhareluKamdar.text =
                "${getString(R.string.b6a)}: ${getString(R.string.son)}:$ghareluSon  " +
                        "${getString(R.string.daughter)}:$ghareluDaughter"
            txvKarkhana.text =
                "${getString(R.string.b6b)}: ${getString(R.string.son)}:$karkhanaSon  " +
                        "${getString(R.string.daughter)}:$karkhanaDaughter"
            txvByapar.text =
                "${getString(R.string.b6c)}: ${getString(R.string.son)}:$byaparSon  " +
                        "${getString(R.string.daughter)}:$byaparDaughter"
            txvKrishi.text =
                "${getString(R.string.b6d)}: ${getString(R.string.son)}:$krishiSon  " +
                        "${getString(R.string.daughter)}:$krishiDaughter"
            txvKaryalaya.text =
                "${getString(R.string.b6e)}: ${getString(R.string.son)}:$karyalayaSon  " +
                        "${getString(R.string.daughter)}:$karyalayaDaughter"
            txvCircus.text =
                "${getString(R.string.b6f)}: ${getString(R.string.son)}:$circusSon  " +
                        "${getString(R.string.daughter)}:$circusDaughter"
        } else {
            rllQb5?.visibility = View.GONE
            rllQb6?.visibility = View.GONE
        }
    }
}