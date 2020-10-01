package com.survey.project.application.features.form.section3

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_fragment2_sec3.*
import kotlinx.android.synthetic.main.fragment_question2.btnNext

class Fragment2Sec3 : Fragment(), View.OnClickListener {
    private lateinit var question3Sec3: Fragment3Sec3
    private lateinit var myView: View
    var chkValue: MutableList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_fragment2_sec3, container, false)
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
            val name = prefs?.getString("gharKoJug", "")
            if (name != "" || name != null) {
                if(name.equals(chkOption1.text.toString())){
                    chkOption1.isChecked
                }

                if(name.equals(chkOption2.text.toString())){
                    chkOption2.isChecked
                }
                if(name.equals(chkOption3.text.toString())){
                    chkOption3.isChecked
                }
            }
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
    }

    private fun save() {
        val prefs: SharedPreferences? =
            context?.getSharedPreferences("Section3", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(chkValue)
        prefs?.edit()?.putStringSet("gharKoJug", set)?.apply()
    }

    private fun showQuestion3() {
        if (!::question3Sec3.isInitialized)
            question3Sec3 = Fragment3Sec3()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain3, question3Sec3,
            FragmentTagConstants.question2Sec3, true
        )
    }

    override fun onClick(view: View?) {
        when (view) {
            btnNext -> {
                if (chkOption1.isChecked) {
                    chkValue.add(chkOption1.text.toString())
                }
                if (chkOption2.isChecked) {
                    chkValue.add(chkOption2.text.toString())
                }

                if (chkOption3.isChecked) {
                    chkValue.add(chkOption3.text.toString())
                }
                save()
                showQuestion3()
            }
        }
    }
}