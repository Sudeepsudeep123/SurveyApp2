package com.survey.project.application.utils.router

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

object Router {
    fun attachFragment(
        context: AppCompatActivity?, frameLayout: Int, fragment: Fragment,
        fragmentTag: String, addToBackStack: Boolean
    ) {
        if (addToBackStack) {
            context?.supportFragmentManager
                ?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(frameLayout, fragment, fragmentTag)
                ?.addToBackStack(fragmentTag)
                ?.commit()
        } else {
            context?.supportFragmentManager
                ?.beginTransaction()
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                ?.replace(frameLayout, fragment, fragmentTag)
                ?.commit()
        }
    }
}