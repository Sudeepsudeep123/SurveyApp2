package com.survey.project.application.features.form.section1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.survey.project.application.R
import com.survey.project.application.utils.constants.FragmentTagConstants
import com.survey.project.application.utils.router.Router
import kotlinx.android.synthetic.main.fragment_question3.*


class Question3Fragment : Fragment(), View.OnClickListener {
    private lateinit var question4Fragment: Question4Fragment

    private lateinit var myView: View
    var selectedItem = ""
    var listOfWard: MutableList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (!::myView.isInitialized)
            myView = inflater.inflate(R.layout.fragment_question3, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList()
        setListener()

        spinNagarpalika.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {
                Toast.makeText(context, listOfWard[position], Toast.LENGTH_SHORT).show()
                selectedItem = listOfWard[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

    }

    private fun setList() {
        listOfWard.add("1")
        listOfWard.add("2")
        listOfWard.add("3")
        listOfWard.add("4")
        listOfWard.add("5")
        val adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_spinner_item, listOfWard) }
        spinNagarpalika.adapter = adapter
    }

    private fun setListener() {
        btnNext.setOnClickListener(this)
        btnPrevious.setOnClickListener(this)
//        spinNagarpalika.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnPrevious -> {
                fragmentManager?.popBackStack()
            }
            btnNext -> {
                save()
                showQuestion4()


            }
        }
    }

    private fun showQuestion4() {
        if (!::question4Fragment.isInitialized)
            question4Fragment = Question4Fragment()
        Router.attachFragment(
            context as AppCompatActivity?, R.id.frmMain, question4Fragment,
            FragmentTagConstants.question4Fragment, true
        )
    }

    private fun save() {
        val prefs: SharedPreferences? = context?.getSharedPreferences("Section1",
            Context.MODE_PRIVATE
        )
        prefs?.edit()?.putString("wardNo", selectedItem)?.apply();
    }
}
