package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question4.*
import kotlinx.android.synthetic.main.fragment_question5.btnNext
import kotlinx.android.synthetic.main.fragment_question5.btnPrevious
import kotlinx.android.synthetic.main.fragment_question7.*

class Question7Fragment : Fragment(), View.OnClickListener {
    private lateinit var question8Fragment: Question8Fragment
    var purushNumber = 0
    var mahilaNumber = 0
    var tesroNumber = 0
    var result1 = ""
    var gharMuliNaam: String? = ""
    var familyMemberListEditText: MutableList<EditText> = ArrayList()
    var familyMemberList: MutableList<String> = ArrayList()

    private lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question7, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        getData()

        makeForm()
    }

    private fun makeForm() {
        if (purushNumber != 0) {
            for (i in 0 until purushNumber) {
                var myEditText = EditText(context)
                myEditText.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                myEditText.setHint(R.string.purush)
                familyMemberListEditText.add(myEditText)
                llDynamicMemberName.addView(myEditText)
            }
        }

        if (mahilaNumber != 0) {
            for (i in 0 until mahilaNumber) {
                var myEditText = EditText(context)
                myEditText.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                myEditText.setHint(R.string.mahila)
                familyMemberListEditText.add(myEditText)
                llDynamicMemberName.addView(myEditText)
            }
        }

        if (tesroNumber != 0) {
            for (i in 0 until tesroNumber) {
                var myEditText = EditText(context)
                myEditText.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
                myEditText.setHint(R.string.tesro)
                familyMemberListEditText.add(myEditText)
                llDynamicMemberName.addView(myEditText)
            }
        }
    }

    private fun getData() {
        try {
            val prefs: SharedPreferences? =
                context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)

            gharMuliNaam = prefs?.getString("houseOwnerName", "")
            var purush = prefs?.getString("purushNumber", "")
            var mahila = prefs?.getString("mahilaNumber", "")
            var tesro = prefs?.getString("tesroNumber", "")

            purushNumber = purush?.let { Integer.parseInt(it) }!!
            mahilaNumber = mahila?.let { Integer.parseInt(it) }!!
            tesroNumber = tesro?.let { Integer.parseInt(it) }!!
        } catch (ex: Exception) {
            Log.e("ex", ex.toString())
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
            btnNext -> {
                familyMemberList.clear()
                for (name in familyMemberListEditText) {
                    if (name.text.toString() == "") {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        familyMemberList.add(name.text.toString())
                    }
                }

                for (i in 0 until familyMemberList.size) {

                    if (familyMemberList[i] == gharMuliNaam) {
                        result1 = "Success"
                    }
                }

                if (result1 == "Success") {
                    save()
                    showQuestion8()
                }
                else{
                    Toast.makeText(context, "Invalid", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun showQuestion8() {
        if (!::question8Fragment.isInitialized)
            question8Fragment = Question8Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question8Fragment,
            FragmentTagConstants.question7Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? = context?.getSharedPreferences("Section1", Context.MODE_PRIVATE)
        val set: MutableSet<String> = HashSet()
        set.addAll(familyMemberList)
        prefs?.edit()?.putStringSet("familyMemberName", set)?.apply()

//        prefs?.edit()
//            ?.putString("gharNo", edtBastiGauTol.text.toString())
//            ?.apply()
    }
}