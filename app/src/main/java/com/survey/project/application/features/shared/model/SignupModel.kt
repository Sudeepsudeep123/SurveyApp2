package com.survey.project.application.features.shared.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.survey.project.application.utils.constants.DbConstants
import com.google.gson.annotations.SerializedName

@Entity(tableName = DbConstants.userTable, indices = [Index(value = ["username"], unique = true)])
data class SignupModel(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("fullName")
    var fullName: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("username")
    var username: String? = null,

    @SerializedName("password")
    var password: String? = null,

    @SerializedName("confirm_password")
    var confirm_password: String? = null,


    @SerializedName("phoneNumber")
    var phoneNumber: String? = null,

    @SerializedName("fatherName")
    var fatherName: String? = null,

    @SerializedName("motherName")
    var motherName: String? = null,

    @SerializedName(" ")
    var address: String? = null

)