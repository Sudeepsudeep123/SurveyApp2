package com.survey.project.application.features.shared.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.survey.project.application.utils.constants.DbConstants

data class AreaData (
    @SerializedName("username")
    var username: String? = null,

    @SerializedName("provence")
    var provence: String? = null,

    @SerializedName("zone")
    var zone: String? = null,

    @SerializedName("district")
    var district: String? = null
)