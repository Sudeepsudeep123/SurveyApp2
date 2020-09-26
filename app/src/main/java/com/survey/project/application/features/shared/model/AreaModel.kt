package com.survey.project.application.features.shared.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.survey.project.application.utils.constants.DbConstants

@Entity(tableName = DbConstants.areaTable)
data class AreaModel (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("Area")
    var area: List<AreaData>? = null
    
)