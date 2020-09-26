//package com.ekbana.officeautomation.database.typeConvertor
//
//import androidx.room.TypeConverter
//import com.ekbana.officeautomation.feature.shared.model.MeetingStatus
//import com.ekbana.officeautomation.feature.shared.model.Projects
//import com.ekbana.officeautomation.feature.shared.model.TeamMember
//import com.ekbana.officeautomation.feature.shared.model.response.*
//import com.ekbana.officeautomation.utils.extension.fromListToString
//import com.ekbana.officeautomation.utils.extension.fromObjectToString
//import com.ekbana.officeautomation.utils.extension.fromStringToList
//import com.ekbana.officeautomation.utils.extension.fromStringToObject
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//
//class ProfileDataConvertorClass {
//    @TypeConverter
//    fun fromActiveDataToString(value: ProfileActiveData?): String? {
//        if (value == null) {
//            return null
//        }
//
//        val type = object : TypeToken<ProfileActiveData>() {}.type
//        return Gson().toJson(value, type)
//    }
//
//    @TypeConverter
//    fun fromStringToActiveData(value: String?): ProfileActiveData? {
//        if (value == null) {
//            return null
//        }
//        val gson = Gson()
//        val type = object : TypeToken<ProfileActiveData>() {}.type
//        return gson.fromJson<ProfileActiveData>(value, type)
//    }
//
//    @TypeConverter
//    fun fromDeviceListToString(value: List<Devices>?): String? {
//        if (value == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<Devices>?>() {
//
//        }.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun fromStringToDevicesList(values: String?): List<Devices>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<Devices>?>() {}.type
//        return Gson().fromJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromBookListToString(listValues: List<Books>?): String? {
//        if (listValues == null) {
//            return null
//        }
//        val type = object : TypeToken<List<Books>?>() {}.type
//        return Gson().toJson(listValues, type)
//    }
//
//    @TypeConverter
//    fun fromStringToBooksList(values: String?): List<Books?>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<Books>?>() {}.type
//        return Gson().fromJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromProjectListToString(value: List<Projects>?): String? {
//        if (value == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<Projects>?>() {
//
//        }.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun fromStringToProjectsList(values: String?): List<Projects?>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<Projects>?>() {}.type
//        return Gson().fromJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromMeetingListToString(value: List<MeetingStatus>?): String? {
//        if (value == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<MeetingStatus>?>() {
//
//        }.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun fromStringToMeetingList(values: String?): List<MeetingStatus>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<MeetingStatus>?>() {}.type
//        return Gson().fromJson<List<MeetingStatus>>(values, type)
//    }
//
//    @TypeConverter
//    fun fromMyTeamLeadListToString(value: List<MyTeamLead>?): String? {
//        if (value == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<MyTeamLead>?>() {
//
//        }.type
//        return gson.toJson(value, type)
//    }
//
//    @TypeConverter
//    fun fromStringToMyTeamLeadList(values: String?): List<MyTeamLead>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<MyTeamLead>?>() {}.type
//        return Gson().fromJson<List<MyTeamLead>>(values, type)
//    }
//
//    @TypeConverter
//    fun fromStringToUpcomingLeavesList(values: String?): List<String?>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<String>?>() {}.type
//        return Gson().fromJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromUpcomingLeavesListToString(values: List<String>?): String? {
//        if (values == null) {
//            return null
//        }
//        val gson = Gson()
//        val type = object : TypeToken<List<String>?>() {
//
//        }.type
//        return gson.toJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromStringToTeamMemberList(values: String?): List<TeamMember>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<TeamMember>?>() {}.type
//        return Gson().fromJson<List<TeamMember>>(values, type)
//    }
//
//    @TypeConverter
//    fun fromTeamMemberListToString(values: List<TeamMember>?): String? {
//        if (values == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<TeamMember>?>() {
//
//        }.type
//        return gson.toJson(values, type)
//    }
//
//    @TypeConverter
//    fun fromStringToOaDocsList(values: String?): List<OADocsData>? {
//        if (values == null) {
//            return null
//        }
//        val type = object : TypeToken<List<OADocsData>?>() {}.type
//        return Gson().fromJson<List<OADocsData>>(values, type)
//    }
//
//    @TypeConverter
//    fun fromOaDocsListToString(values: List<OADocsData>?): String? {
//        if (values == null) {
//            return null
//        }
//
//        val gson = Gson()
//        val type = object : TypeToken<List<OADocsData>?>() {
//
//        }.type
//        return gson.toJson(values, type)
//    }
//}