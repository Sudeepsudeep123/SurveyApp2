package com.survey.project.application.features.main

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel

interface MainView:MvpView {
    fun onSuccess(mainModel: AreaModel)
    fun onGetLocation(mainModel: List<AreaModel>)
    fun onFailure(message:String)
    fun getAppDatabase(): MainRoomDatabase?
    fun showToast(messageInt: Int)
}