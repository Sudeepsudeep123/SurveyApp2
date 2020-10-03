package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_sec3_correction.*


class FragmentSec3Correction : Fragment(), View.OnClickListener {
    private lateinit var question1Sec3: Fragment1Sec3
    private lateinit var question2Sec3: Fragment2Sec3
    private lateinit var question3Sec3: Fragment3Sec3
    private lateinit var question4Sec3: Fragment4Sec3
    private lateinit var question5Sec3: Fragment5Sec3
    private lateinit var question6Sec3: Fragment6Sec3
    private lateinit var question7Sec3: Fragment7Sec3
    private lateinit var question8Sec3: Fragment8Sec3
    private lateinit var question9Sec3: Fragment9Sec3
    private lateinit var question10Sec3: Fragment10Sec3
    private lateinit var question11Sec3: Fragment11Sec3
    private lateinit var myView: View

    var whichModeOfTransportation = ""
    var toiletType = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_sec3_correction, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()
    }


    override fun onClick(view: View?) {
        when (view) {
            btnCLose -> {
                Toast.makeText(context, "Discarded", Toast.LENGTH_SHORT).show()
                val clearPref = context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)
                clearPref?.edit()?.clear()?.commit()

                showQuestion1()
            }
            btnSubmit -> {
                Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
            }

            cvQues1 -> {
                showQuestion1()
            }
            cvQues2 -> {
                showQuestion2()

            }
            cvQues3 -> {
                showQuestion3()

            }
            cvQues4 -> {
                showQuestion4()

            }
            cvQues5 -> {
                if (toiletType == ("") || toiletType == null) {

                } else {
                    showQuestion5()
                }

            }
            cvQues6 -> {
                showQuestion6()

            }
            cvQues7 -> {
                showQuestion7()

            }
            cvQues8 -> {
                showQuestion8()

            }
            cvQues9 -> {
                showQuestion9()

            }
            cvQues10 -> {
                showQuestion10()

            }
            cvQues11 -> {
                if (whichModeOfTransportation == ("") || whichModeOfTransportation == null) {
                } else {
                    showQuestion11()
                }
            }
        }

    }

    private fun showQuestion1() {
        if (!::question1Sec3.isInitialized)
            question1Sec3 = Fragment1Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question1Sec3,
            FragmentTagConstants.question1Sec3, true
        )
    }

    private fun showQuestion2() {
        if (!::question2Sec3.isInitialized)
            question2Sec3 = Fragment2Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question2Sec3,
            FragmentTagConstants.question2Sec3, true
        )
    }

    private fun showQuestion3() {
        if (!::question3Sec3.isInitialized)
            question3Sec3 = Fragment3Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question3Sec3,
            FragmentTagConstants.question2Sec3, true
        )
    }

    private fun showQuestion4() {
        if (!::question4Sec3.isInitialized)
            question4Sec3 = Fragment4Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question4Sec3,
            FragmentTagConstants.question3Sec3, true
        )
    }

    private fun showQuestion5() {
        if (!::question5Sec3.isInitialized)
            question5Sec3 = Fragment5Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question5Sec3,
            FragmentTagConstants.question5Sec3, true
        )
    }

    private fun showQuestion6() {
        if (!::question6Sec3.isInitialized)
            question6Sec3 = Fragment6Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question6Sec3,
            FragmentTagConstants.question6Sec3, true
        )
    }

    private fun showQuestion7() {
        if (!::question7Sec3.isInitialized)
            question7Sec3 = Fragment7Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question7Sec3,
            FragmentTagConstants.question7Sec3, true
        )
    }

    private fun showQuestion8() {
        if (!::question8Sec3.isInitialized)
            question8Sec3 = Fragment8Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question8Sec3,
            FragmentTagConstants.question8Sec3, true
        )
    }

    private fun showQuestion9() {
        if (!::question9Sec3.isInitialized)
            question9Sec3 = Fragment9Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question9Sec3,
            FragmentTagConstants.question9Sec3, true
        )
    }

    private fun showQuestion10() {
        if (!::question10Sec3.isInitialized)
            question10Sec3 = Fragment10Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question10Sec3,
            FragmentTagConstants.question10Sec3, true
        )
    }

    private fun showQuestion11() {
        if (!::question11Sec3.isInitialized)
            question11Sec3 = Fragment11Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question11Sec3,
            FragmentTagConstants.question11Sec3, true
        )
    }

    private fun setListener() {
        btnCLose.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

        cvQues1.setOnClickListener(this)
        cvQues2.setOnClickListener(this)
        cvQues3.setOnClickListener(this)
        cvQues4.setOnClickListener(this)
        cvQues5.setOnClickListener(this)
        cvQues6.setOnClickListener(this)
        cvQues7.setOnClickListener(this)
        cvQues8.setOnClickListener(this)
        cvQues9.setOnClickListener(this)
        cvQues10.setOnClickListener(this)
        cvQues11.setOnClickListener(this)
    }


    private fun getData() {
        val prefs: SharedPreferences? = context?.getSharedPreferences(
            "Section3",
            Context.MODE_PRIVATE
        )
        val name = prefs?.getString("noOfHouse", "")
        tvQues1.text = name


        //2nd
        val set: Set<String> = prefs?.getStringSet("gharKoJug", null) as Set<String>
        var jugType = ""
        for (name in set) {
            Log.e("jugg", name)
            jugType = "$jugType  $name "
        }
        tvQues2.text = jugType

        //3rd
        val set3: Set<String> = prefs?.getStringSet("paniKoSrot", null) as Set<String>
        var paniSrot = ""
        for (name in set3) {
            paniSrot = "$paniSrot  $name "
        }
        tvQues3.text = paniSrot

        //4th
        val toilet = prefs?.getString("toilet", "")
        tvQues4.text = toilet

//            5th
        try {
            val set5: Set<String> = prefs?.getStringSet("toiletType", null) as Set<String>
            for (name in set5) {
                toiletType = "$toiletType  $name "
            }
            tvQues5.text = toiletType
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }


//            6th

        val handWash = prefs?.getString("handWash", "")
        Log.e("handwash", handWash)
        tvQues6.text = handWash

//            7th
        val electricity = prefs?.getString("electricity", "")
        tvQues7.text = electricity

        //8th
        val set8: Set<String> = prefs?.getStringSet("cookFood", null) as Set<String>
        var cookFood = ""
        for (name in set8) {
            cookFood = "$cookFood  $name "

        }
        tvQues8.text = cookFood

        //9th
        val set9: Set<String> = prefs?.getStringSet("stoveType", null) as Set<String>
        var stoveType = ""
        for (name in set9) {
            stoveType = "$stoveType  $name "

        }
        tvQues9.text = stoveType

        //10th
        val transportation = prefs?.getString("transportation", "")
        tvQues10.text = transportation

        //11th
        try {

            val set11: Set<String> =
                prefs?.getStringSet("whichModeOfTransportation", null) as Set<String>

            for (name in set11) {
                whichModeOfTransportation = "$whichModeOfTransportation  $name "

            }
            tvQues11.text = whichModeOfTransportation
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

}