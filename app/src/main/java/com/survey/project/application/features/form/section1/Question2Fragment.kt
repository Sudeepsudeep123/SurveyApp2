package com.survey.project.application.features.form.section1

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question2.*


class Question2Fragment : Fragment(), View.OnClickListener {
    private lateinit var question3Fragment: Question3Fragment

    private lateinit var myView: View
    var selectedItem = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question2, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()

        rgHouseOwner.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton? = view?.findViewById(checkedId)
            selectedItem = radio?.text as String
        }
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
    }

    private fun save() {
        val prefs: SharedPreferences? = context?.getSharedPreferences("Section1", MODE_PRIVATE)
        prefs?.edit()?.putString("houseOwner", selectedItem)?.apply();
    }

    override fun onClick(p0: View?) {
        when (p0) {
            btnNext -> {
                save()
                showQuestion3()

            }

            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
        }
    }

    private fun showQuestion3() {
        if (!::question3Fragment.isInitialized)
            question3Fragment = Question3Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question3Fragment,
            FragmentTagConstants.question3Fragment, true
        )
    }
}