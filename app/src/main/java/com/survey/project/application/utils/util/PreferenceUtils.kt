package com.survey.project.application.utils.util

import android.content.Context
import com.survey.project.application.utils.constants.PreferenceConstants

object PreferenceUtils {
    fun saveEthnicity(context: Context?, ethnicity: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.ethnicity, ethnicity)?.apply()
    }

    fun getEthnicity(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.ethnicity, "") ?: ""
    }

    fun saveReligion(context: Context?, religion: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.religion, religion)?.apply()
    }

    fun getReligion(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.religion, "") ?: ""
    }

    fun saveMotherTongue(context: Context?, language: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.language, language)?.apply()
    }

    fun getMotherTongue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.language, "") ?: ""
    }

    fun saveHouseOwnership(context: Context?, houseOwnership: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.house_ownership, houseOwnership)?.apply()
    }

    fun getHouseOwnership(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.house_ownership, "") ?: ""
    }

    fun saveRentedHouseValue(context: Context?, houseRented: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.house_rented, houseRented)?.apply()
    }

    fun getRentedHouseValue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.house_rented, "") ?: ""
    }

    fun saveRentedLandValue(context: Context?, landRented: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.rented_land, landRented)?.apply()
    }

    fun getRentedLandValue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.rented_land, "") ?: ""
    }

    fun saveMonthlyIncome(context: Context?, monthlyIncome: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.monthly_income, monthlyIncome)?.apply()
    }

    fun getMonthlyIncome(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.monthly_income, "") ?: ""
    }

    fun saveMonthlySaving(context: Context?, monthlySaving: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.monthly_saving, monthlySaving)?.apply()
    }

    fun getMonthlySaving(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.monthly_saving, "") ?: ""
    }

    fun saveUnemployedCount(
        context: Context?,
        maleUnemployed: String,
        femaleUnemployed: String,
        thirdGenderUnemployed: String
    ) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.male_unemployed, maleUnemployed)?.apply()
        pref?.edit()?.putString(PreferenceConstants.female_unemployed, femaleUnemployed)?.apply()
        pref?.edit()?.putString(PreferenceConstants.third_gender_unemployed, thirdGenderUnemployed)
            ?.apply()
    }

    fun getMaleUnemployedCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.male_unemployed, "") ?: ""
    }

    fun getFemaleUnemployedCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.female_unemployed, "") ?: ""
    }

    fun getThirdUnemployedCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.third_gender_unemployed, "") ?: ""
    }
}