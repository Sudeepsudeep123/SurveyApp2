package com.survey.project.application.utils.helper

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView

object DropdownHelper {
    var familyMemberListSpinner: MutableList<Spinner> = ArrayList()

    fun dropDownHelper(
        size: Int,
        context: Context?,
        familyMemberList: MutableList<String>,
        llDynamicMemberNotStay: LinearLayout,
        listOfData: MutableList<String>
    ): MutableList<Spinner> {
        var spinner = arrayOfNulls<Spinner>(size)
        llDynamicMemberNotStay.removeAllViews()
        for (i in 0 until size) {

            var textView = TextView(context)
            textView.text = familyMemberList[i]
            llDynamicMemberNotStay.addView(textView)

            spinner[i] = Spinner(context)
            spinner[i]?.id = i
            val adapter = context?.let { ArrayAdapter(it, R.layout.simple_spinner_item, listOfData) }
            spinner[i]?.adapter = adapter
            spinner[i]?.let { familyMemberListSpinner.add(it) }
            llDynamicMemberNotStay.addView(spinner[i])
        }
        return familyMemberListSpinner
    }
}