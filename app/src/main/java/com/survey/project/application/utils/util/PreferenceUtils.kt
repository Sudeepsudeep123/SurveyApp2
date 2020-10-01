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

    fun saveIsBankAccountPresentValue(context: Context?, bank_account_present: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.bank_account_present, bank_account_present)
            ?.apply()
    }

    fun isBankAccountPresentValue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.bank_account_present, "") ?: ""
    }

    fun saveAnyoneUnemployedInFam(context: Context?, umemployedValue: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.unemployment_in_family, umemployedValue)
            ?.apply()
    }

    fun getAnyoneUnemployedInFam(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.unemployment_in_family, "") ?: ""
    }

    fun saveLpValue(context: Context?, lalpurja: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.lalpurja, lalpurja)
            ?.apply()
    }

    fun getLpValue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.lalpurja, "") ?: ""
    }

    fun saveHouseType(context: Context?, houseType: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.house_type, houseType)
            ?.apply()
    }

    fun getHouseType(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.house_type, "") ?: ""
    }

    fun saveHouseCount(context: Context?, count: Int) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putInt(PreferenceConstants.count, count)
            ?.apply()
    }

    fun getHouseCount(context: Context?): Int {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getInt(PreferenceConstants.count, 0) ?: 0
    }

    fun saveBusinessCount(context: Context?, count: Int) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putInt(PreferenceConstants.businessCount, count)
            ?.apply()
    }

    fun getBusinessCount(context: Context?): Int {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getInt(PreferenceConstants.businessCount, 0) ?: 0
    }

    fun saveBusinessType(context: Context?, businessType: String) {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        pref?.edit()?.putString(PreferenceConstants.businessType, businessType)
            ?.apply()
    }

    fun getBusinessType(context: Context?): String {
        val pref =
            context?.getSharedPreferences(PreferenceConstants.main_preference, Context.MODE_PRIVATE)
        return pref?.getString(PreferenceConstants.businessType, "") ?: ""
    }

    fun saveDeadCount(
        context: Context?,
        male: String,
        female: String,
        thirdGender: String
    ) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.dead_count_male, male)?.apply()
        pref?.edit()?.putString(PreferenceConstants.dead_count_female, female)?.apply()
        pref?.edit()?.putString(PreferenceConstants.dead_count_third, thirdGender)
            ?.apply()
    }

    fun getMaleDeadCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.dead_count_male, "") ?: ""
    }

    fun getFemaleDeadCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.dead_count_female, "") ?: ""
    }

    fun getThirdGenderDeadCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.dead_count_third, "") ?: ""
    }

    fun saveSentKidsToSchool(context: Context?, sentVal: String) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.sent_kids_to_school, sentVal)?.apply()
    }

    fun getSendKidsToSchool(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.sent_kids_to_school, "") ?: ""
    }

    fun saveChildLaborValue(context: Context?, childLabor: String) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.childLabor, childLabor)?.apply()
    }

    fun getChildLaborValue(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.childLabor, "") ?: ""
    }

    fun saveSchoolType(context: Context?, schoolType: String) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.schoolType, schoolType)?.apply()
    }

    fun getSchoolType(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.schoolType, "") ?: ""
    }

    fun saveSonDaughterCountInCountryAndForeign(
        context: Context?,
        sonCountry: String,
        daughterCountry: String,
        sonForeign: String,
        daughterForeign: String
    ) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.sonCountInCountry, sonCountry)?.apply()
        pref?.edit()?.putString(PreferenceConstants.daughterCountInCountry, daughterCountry)
            ?.apply()
        pref?.edit()?.putString(PreferenceConstants.sonCountInForeign, sonForeign)?.apply()
        pref?.edit()?.putString(PreferenceConstants.daughterCountInForeign, daughterForeign)
            ?.apply()
    }

    fun getSonCountInCountry(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.sonCountInCountry, "") ?: ""
    }

    fun getDaughterCountInCountry(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.daughterCountInCountry, "") ?: ""
    }

    fun getSonCountInForeign(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.sonCountInForeign, "") ?: ""
    }

    fun getDaughterCountInForeign(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.daughterCountInForeign, "") ?: ""
    }

    fun saveSonDaughterLaborType(
        context: Context?,
        ghareluSon: String,
        ghareluDaughter: String,
        karkhanaSon: String,
        karkhanaDaughter: String,
        byaparSon: String,
        byaparDaughter: String,
        krishiSon: String,
        krishiDaughter: String,
        karyalayaSon: String,
        karyalayaDaughter: String,
        circusSon: String,
        circusDaughter: String
    ) {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        pref?.edit()?.putString(PreferenceConstants.ghareluKamdarSon, ghareluSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.ghareluKamdarDaughter, ghareluDaughter)?.apply()
        pref?.edit()?.putString(PreferenceConstants.karkhanaSon, karkhanaSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.karkhanaDaughter, karkhanaDaughter)?.apply()
        pref?.edit()?.putString(PreferenceConstants.byaparSon, byaparSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.byaparDaughter, byaparDaughter)?.apply()
        pref?.edit()?.putString(PreferenceConstants.krishiSon, krishiSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.krishiDaughter, krishiDaughter)?.apply()
        pref?.edit()?.putString(PreferenceConstants.karyalayaSon, karyalayaSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.karyalayaDaughter, karyalayaDaughter)?.apply()
        pref?.edit()?.putString(PreferenceConstants.circusSon, circusSon)?.apply()
        pref?.edit()?.putString(PreferenceConstants.circusDaughter, circusDaughter)?.apply()
    }

    fun getGhareluSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.ghareluKamdarSon, "") ?: ""
    }

    fun getGhareluDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.ghareluKamdarDaughter, "") ?: ""
    }

    fun getKarkhanaSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.karkhanaSon, "") ?: ""
    }

    fun getKarkhanaDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.karkhanaDaughter, "") ?: ""
    }

    fun getByaparSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.byaparSon, "") ?: ""
    }

    fun getByaparDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.byaparDaughter, "") ?: ""
    }

    fun getkrishiSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.krishiSon, "") ?: ""
    }

    fun getkrishiDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.krishiDaughter, "") ?: ""
    }

    fun getKaryalayaSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.karyalayaSon, "") ?: ""
    }

    fun getKaryalayaDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.karyalayaDaughter, "") ?: ""
    }

    fun getCircusDaughterCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.circusDaughter, "") ?: ""
    }

    fun getCircusSonCount(context: Context?): String {
        val pref =
            context?.getSharedPreferences(
                PreferenceConstants.section_b_preference,
                Context.MODE_PRIVATE
            )
        return pref?.getString(PreferenceConstants.circusSon, "") ?: ""
    }
}