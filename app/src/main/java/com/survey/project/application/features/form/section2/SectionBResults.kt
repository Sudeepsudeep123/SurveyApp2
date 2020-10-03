package com.survey.project.application.features.form.section2

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.features.form.activity.FormActivity3
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.util.PreferenceUtils
import kotlinx.android.synthetic.main.fragment_sectionb_results.*


class SectionBResults : Fragment(), View.OnClickListener {
    lateinit var questionB1Fragment: QuestionB1Fragment
    lateinit var questionB2Fragment: QuestionB2Fragment
    lateinit var questionB3Fragment: QuestionB3Fragment
    lateinit var questionB4Fragment: QuestionB4Fragment
    lateinit var questionB5Fragment: QuestionB5Fragment
    lateinit var questionB6Fragment: QuestionB6Fragment
    lateinit var questionB7Fragment: QuestionB7Fragment
    lateinit var questionB8Fragment: QuestionB8Fragment
    lateinit var questionB9Fragment: QuestionB9Fragment
    lateinit var questionB10Fragment: QuestionB10Fragment
    lateinit var questionB11Fragment: QuestionB11Fragment
    lateinit var questionB12Fragment: QuestionB12Fragment
    lateinit var questionB13Fragment: QuestionB13Fragment

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
                (activity as Section2Activity)?.clearSecBPreference()
                //PreferenceUtils.clearSharedPreferenceSectionB(context)
            }
            btnComplete -> {
                //go to section C
                //  goToPreviousFragment()
                startActivity(Intent(context, FormActivity3::class.java))
            }
            rllB1 -> {
                if (!::questionB1Fragment.isInitialized) {
                    questionB1Fragment = QuestionB1Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB1Fragment,
                    FragmentTagConstants.questionB1
                )
            }
            rllQb2 -> {
                if (!::questionB2Fragment.isInitialized) {
                    questionB2Fragment = QuestionB2Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB2Fragment,
                    FragmentTagConstants.questionB2
                )
            }
            rllQb3 -> {
                if (!::questionB3Fragment.isInitialized) {
                    questionB3Fragment = QuestionB3Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB3Fragment,
                    FragmentTagConstants.questionB3
                )
            }
            rllQb4 -> {
                if (!::questionB4Fragment.isInitialized) {
                    questionB4Fragment = QuestionB4Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB4Fragment,
                    FragmentTagConstants.questionB4
                )
            }
            rllQb5 -> {
                if (!::questionB5Fragment.isInitialized) {
                    questionB5Fragment = QuestionB5Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB5Fragment,
                    FragmentTagConstants.questionB5
                )
            }
            rllQb6 -> {
                if (!::questionB6Fragment.isInitialized) {
                    questionB6Fragment = QuestionB6Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB6Fragment,
                    FragmentTagConstants.questionB6
                )
            }
            rllQb7 -> {
                if (!::questionB7Fragment.isInitialized) {
                    questionB7Fragment = QuestionB7Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB7Fragment,
                    FragmentTagConstants.questionB7
                )
            }
            rllQb8 -> {
                if (!::questionB8Fragment.isInitialized) {
                    questionB8Fragment = QuestionB8Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB8Fragment,
                    FragmentTagConstants.questionB8
                )
            }
            rllQb9 -> {
                if (!::questionB9Fragment.isInitialized) {
                    questionB9Fragment = QuestionB9Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB9Fragment,
                    FragmentTagConstants.questionB9
                )
            }
            rllQb10 -> {
                if (!::questionB10Fragment.isInitialized) {
                    questionB10Fragment = QuestionB10Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB10Fragment,
                    FragmentTagConstants.questionB10
                )
            }
            rllQb11 -> {
                if (!::questionB11Fragment.isInitialized) {
                    questionB11Fragment = QuestionB11Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB11Fragment,
                    FragmentTagConstants.questionB11
                )
            }
            rllQb12 -> {
                if (!::questionB12Fragment.isInitialized) {
                    questionB12Fragment = QuestionB12Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB12Fragment,
                    FragmentTagConstants.questionB12
                )
            }
            rllQb13 -> {
                if (!::questionB13Fragment.isInitialized) {
                    questionB13Fragment = QuestionB13Fragment()
                }
                (activity as Section2Activity)?.attachFragment(
                    questionB13Fragment,
                    FragmentTagConstants.questionB13
                )
            }
        }
    }

    private fun initListener() {
        rllB1?.setOnClickListener(this)
        rllQb2?.setOnClickListener(this)
        rllQb3?.setOnClickListener(this)
        rllQb4?.setOnClickListener(this)
        rllQb5?.setOnClickListener(this)
        rllQb6?.setOnClickListener(this)
        rllQb7?.setOnClickListener(this)
        rllQb8?.setOnClickListener(this)
        rllQb9?.setOnClickListener(this)
        rllQb10?.setOnClickListener(this)
        rllQb11?.setOnClickListener(this)
        rllQb12?.setOnClickListener(this)
        rllQb13?.setOnClickListener(this)
        btnComplete?.setOnClickListener(this)
        btnCancel?.setOnClickListener(this)
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

        //4,5,6
        if (childLabor == getString(R.string.yes_nepali)) {
            rllQb5?.visibility = View.VISIBLE
            rllQb6?.visibility = View.VISIBLE

            //b5
            val sonInCountry = PreferenceUtils.getSonCountInCountry(context)
            val daughterInCountry = PreferenceUtils.getDaughterCountInCountry(context)
            val sonInInForeign = PreferenceUtils.getSonCountInForeign(context)
            val daughterInInForeign = PreferenceUtils.getDaughterCountInForeign(context)

            txvInCountry.text =
                "${getString(R.string.in_country)}: ${getString(R.string.son_count)}:$sonInCountry  " +
                        "${getString(R.string.daughter_count)}:$daughterInCountry"

            txvInForeign.text =
                "${getString(R.string.outside_country)}: ${getString(R.string.son_count)}:$sonInInForeign  " +
                        "${getString(R.string.son_count)}:$daughterInInForeign"

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
                "${getString(R.string.b6a)}: ${getString(R.string.son_count)}:$ghareluSon  " +
                        "${getString(R.string.daughter_count)}:$ghareluDaughter"
            txvKarkhana.text =
                "${getString(R.string.b6b)}: ${getString(R.string.son_count)}:$karkhanaSon  " +
                        "${getString(R.string.daughter_count)}:$karkhanaDaughter"
            txvByapar.text =
                "${getString(R.string.b6c)}: ${getString(R.string.son_count)}:$byaparSon  " +
                        "${getString(R.string.daughter_count)}:$byaparDaughter"
            txvKrishi.text =
                "${getString(R.string.b6d)}: ${getString(R.string.son_count)}:$krishiSon  " +
                        "${getString(R.string.daughter_count)}:$krishiDaughter"
            txvKaryalaya.text =
                "${getString(R.string.b6e)}: ${getString(R.string.son_count)}:$karyalayaSon  " +
                        "${getString(R.string.daughter_count)}:$karyalayaDaughter"
            txvCircus.text =
                "${getString(R.string.b6f)}: ${getString(R.string.son_count)}:$circusSon  " +
                        "${getString(R.string.daughter_count)}:$circusDaughter"
        } else {
            rllQb5?.visibility = View.GONE
            rllQb6?.visibility = View.GONE
        }

        //7,8
        val married = PreferenceUtils.getKidMarriedBefore18(context)
        txvKidsMarriedBefire18.text = married

        if (married == getString(R.string.yes_nepali)) {
            rllQb8?.visibility = View.VISIBLE
            val sonMarried = PreferenceUtils.getSonMarriedBefore18(context)
            val daughterMarried = PreferenceUtils.getDaughterMarriedBefore18(context)

            txvSonMarried?.text = "${getString(R.string.son_count)}: $sonMarried"
            txvDaughterMarried?.text = "${getString(R.string.daughter_count)}: $daughterMarried"
        } else {
            rllQb8?.visibility = View.GONE
        }

        //9,10,11
        val differentlyAbledInFam = PreferenceUtils.getDifferentlyAbledInFam(context)
        txvDissferentlyAbled?.text = differentlyAbledInFam

        if (differentlyAbledInFam == getString(R.string.yes_nepali)) {
            rllQb10?.visibility = View.VISIBLE
            rllQb11?.visibility = View.VISIBLE

            txvMentalIllness?.text =
                "${getString(R.string.mental_illnes)} : ${PreferenceUtils.getMentalIllnessCount(
                    context
                )}"
            txvAustism?.text =
                "${getString(R.string.mental_illnes)} : ${PreferenceUtils.getAutismCount(context)}"
            txvOther?.text =
                "${getString(R.string.mental_illnes)} : ${PreferenceUtils.getOtherCount(context)}"

            //11
            txvRed.text = "${getString(R.string.red)}: ${PreferenceUtils.getRedCardCount(context)}"
            txvBlue.text =
                "${getString(R.string.blue)}: ${PreferenceUtils.getBlueCardCount(context)}"
            txvYellow.text =
                "${getString(R.string.yellow)}: ${PreferenceUtils.getYellowCardCount(context)}"
            txvWhite.text =
                "${getString(R.string.white)}: ${PreferenceUtils.getOtherCount(context)}"
        } else {
            rllQb10?.visibility = View.GONE
            rllQb11?.visibility = View.GONE
        }

        val longTermIllness = PreferenceUtils.getLongTermDiseaseInFam(context)
        txvLongIllness?.text = longTermIllness

        if (longTermIllness == getString(R.string.yes_nepali)) {
            rllQb13?.visibility = View.VISIBLE

            txvTv?.text = getString(R.string.tb) + ": " + PreferenceUtils.getTbCount(context)
            txvCancer?.text =
                getString(R.string.cancer) + ": " + PreferenceUtils.getCancerCount(context)
            txvHiv?.text = getString(R.string.hiv) + ": " + PreferenceUtils.getHivCount(context)
            txvSugar?.text =
                getString(R.string.sugar) + ": " + PreferenceUtils.getSugarCount(context)
            txvBp?.text = getString(R.string.bp) + ": " + PreferenceUtils.getBpCount(context)
            txvOtherLongTermIllness?.text =
                getString(R.string.other) + ": " + PreferenceUtils.getOtherIllnessCount(context)
        } else {
            rllQb13?.visibility = View.GONE
        }
    }

}