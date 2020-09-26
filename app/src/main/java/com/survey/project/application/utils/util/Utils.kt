package com.survey.project.application.utils.util

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

object Utils {
    fun popBackStack(fragmentTag: String, activity: FragmentActivity?) {
        val fm: FragmentManager? = activity?.supportFragmentManager
        fm?.popBackStack(
            fragmentTag,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }
}