package com.survey.project.application.database.typeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.survey.project.application.features.shared.model.AreaData
import com.survey.project.application.features.shared.model.AreaModel

class AreaTypeConverterClass {

    @TypeConverter
    fun fromAreaListToString(value: List<AreaData>?): String? {
        if (value == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<List<AreaData>?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun fromStringToAreaList(values: String?): List<AreaData>? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<List<AreaData>?>() {}.type
        return Gson().fromJson(values, type)
    }

    @TypeConverter
    fun fromAreaLToString(value: AreaData?): String? {
        if (value == null) {
            return null
        }

        val gson = Gson()
        val type = object : TypeToken<AreaData?>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun fromStringToArea(values: String?): AreaData? {
        if (values == null) {
            return null
        }
        val type = object : TypeToken<AreaData>() {}.type
        return Gson().fromJson(values, type)
    }
}