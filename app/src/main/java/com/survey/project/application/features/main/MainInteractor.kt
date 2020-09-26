package com.survey.project.application.features.main

import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.repository.MainRepository
import com.survey.project.application.features.shared.repository.UserRepository

class MainInteractor {
    var mainRepository = MainRepository()
    fun saveToDB(areaRequest: List<AreaModel>, appDatabase: MainRoomDatabase?) =
        mainRepository?.saveToDb(areaRequest, appDatabase)

    fun getDataFromDB(appDatabase: MainRoomDatabase?) =
        mainRepository?.getLocationDataFromDB(appDatabase)


}