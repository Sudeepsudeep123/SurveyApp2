package com.survey.project.application.features.signup

import com.survey.project.application.database.room.MainRoomDatabase
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.survey.project.application.features.shared.model.SignupModel

interface SignupView :MvpView{
    fun onSuccess(mainModel: List<SignupModel>)
    fun onFailure(message:String)
    fun getAppDatabase(): MainRoomDatabase?
    fun showToast(messageInt: Int)
}