package com.survey.project.application.features.Signup

import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.SignupModel
import com.survey.project.application.features.shared.repository.UserRepository


//
class SignupInteractor {

    fun saveToDB(signUpResponse: List<SignupModel>, appDatabase: MainRoomDatabase?) =
        UserRepository?.saveToDb(signUpResponse, appDatabase)

    fun getDataFromDB(appDatabase: MainRoomDatabase?) = UserRepository?.getDataFromDB(appDatabase)

    fun getUserFromDB(appDatabase: MainRoomDatabase?, userName: String, password: String) =
        UserRepository?.getUserFromDB(appDatabase, userName, password)

}
