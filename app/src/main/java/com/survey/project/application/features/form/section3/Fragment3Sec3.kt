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
import kotlinx.android.synthetic.main.fragment_fragment3_sec3.*

class Fragment3Sec3 : Fragment(), View.OnClickListener {
    private lateinit var question4Sec3: Fragment4Sec3
    private lateinit var question2Sec3: Fragment2Sec3
    private lateinit var myView: View
    var chkValue: MutableList<String> = ArrayList()
    var checked = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment3_sec3, container, false)
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

            val set: Set<String> = prefs?.getStringSet("paniKoSrot", null) as Set<String>
            for (name in set) {
                Log.e("chkedvalue", name)
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

        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious3.setOnClickListener(this)
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(chkValue)
        prefs?.edit()?.putStringSet("paniKoSrot", set)?.apply()
    }

    private fun showQuestion4() {
        if (!::question4Sec3.isInitialized)
            question4Sec3 = Fragment4Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question4Sec3,
            FragmentTagConstants.question3Sec3, true
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

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                if (chkOption1.isChecked) {
                    chkValue.add(chkOption1.text.toString())
                    save()
                    checked = "1"
                    Log.e("here", "here1")
                }
                if (chkOption2.isChecked) {
                    chkValue.add(chkOption2.text.toString())
                    save()
                    checked = "1"
                    Log.e("here", "here2")
                }
                if (chkOption3.isChecked) {
                    chkValue.add(chkOption3.text.toString())
                    save()
                    checked = "1"
                    Log.e("here", "here3")
                }
                if (checked == "1") {
                    showQuestion4()
                } else {
                    Toast.makeText(context, "Please check any 1 item", Toast.LENGTH_SHORT).show()
                }


            }

            btnPrevious3 -> {
//                showQuestion2()
                fragmentManager?.popBackStack()

            }
        }
    }
}