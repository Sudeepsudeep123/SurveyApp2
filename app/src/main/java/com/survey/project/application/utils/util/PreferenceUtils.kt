package com.survey.project.application.utils.util

import android.content.Context
import com.survey.project.application.utils.constants.PreferenceConstants

object PreferenceUtils {
    fun saveEthnicity(context: Context?, ethnicity: String) {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.ethnicity, ethnicity)?.apply()
    }

    fun getEthnicity(context: Context?): String {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.ethnicity, "") ?: ""
    }

    fun saveReligion(context: Context?, religion: String) {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.religion, religion)?.apply()
    }

    fun getReligion(context: Context?): String {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.religion, "") ?: ""
    }

    fun saveMotherTongue(context: Context?, language: String) {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.language, language)?.apply()
    }

    fun getMotherTongue(context: Context?): String {
        val pref = context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.language, "") ?: ""
    }
}