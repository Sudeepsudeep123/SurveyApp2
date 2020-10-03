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
import kotlinx.android.synthetic.main.fragment_fragment11_sec3.*
import kotlinx.android.synthetic.main.fragment_fragment11_sec3.btnNext
import kotlinx.android.synthetic.main.fragment_fragment11_sec3.chkOption1
import kotlinx.android.synthetic.main.fragment_fragment11_sec3.chkOption2
import kotlinx.android.synthetic.main.fragment_fragment11_sec3.chkOption3
import kotlinx.android.synthetic.main.fragment_fragment2_sec3.*


class Fragment11Sec3 : Fragment(), View.OnClickListener {
    private lateinit var correctionSec3: FragmentSec3Correction
    private lateinit var myView: View
    var chkValue: MutableList<String> = ArrayList()
    var checked = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment11_sec3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()
    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? = context?.getSharedPreferences(
                "Section3",
                Context.MODE_PRIVATE
            )
//            val name = prefs?.getString("whichModeOfTransportation", "")
            val set: Set<String> =
                prefs?.getStringSet("whichModeOfTransportation", null) as Set<String>
            for (name in set) {
                if (name != "" || name != null) {
                    if (name == chkOption1.text.toString()) {
                        chkOption1.isChecked = true
                    }

                    if (name == chkOption2.text.toString()) {
                        chkOption2.isChecked = true
                    }
                    if (name == chkOption3.text.toString()) {
                        chkOption3.isChecked = true
                    }
                }
            }
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(chkValue)
        prefs?.edit()?.putStringSet("whichModeOfTransportation", set)?.apply()
    }

    private fun showCorrection() {
        if (!::correctionSec3.isInitialized)
            correctionSec3 = FragmentSec3Correction()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, correctionSec3,
            FragmentTagConstants.correctionSec3, true
        )
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                if (chkOption1.isChecked) {
                    chkValue.add(chkOption1.text.toString())
                    save()
                    checked = "1"
                }
                if (chkOption2.isChecked) {
                    chkValue.add(chkOption2.text.toString())
                    save()
                    checked = "1"
                }
                if (chkOption3.isChecked) {
                    chkValue.add(chkOption3.text.toString())
                    save()
                    checked = "1"
                }
                if (checked == "1") {
                    showCorrection()
                } else {
                    Toast.makeText(context, "Please check any 1 item", Toast.LENGTH_SHORT).show()
                }
            }

            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
        }
    }
}