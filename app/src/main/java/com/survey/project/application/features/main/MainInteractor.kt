package com.survey.project.application.features.main

import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.repository.MainRepository

class MainInteractor {
    var mainRepository = MainRepository()

    fun saveLocationToDb(areaRequest: AreaModel, appDatabase: MainRoomDatabase?) =
        mainRepository?.saveLocationToDb(areaRequest, appDatabase)

    fun getDataFromDB(appDatabase: MainRoomDatabase?) =
        mainRepository?.getLocationDataFromDB(appDatabase)
}