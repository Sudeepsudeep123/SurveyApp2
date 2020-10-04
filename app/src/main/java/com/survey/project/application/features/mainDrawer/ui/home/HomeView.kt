package com.survey.project.application.features.mainDrawer.ui.home

import com.hannesdorfmann.mosby3.mvp.MvpView
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.base.BaseView
import com.survey.project.application.features.shared.model.AreaModel

interface HomeView : MvpView {
    fun getAppDatabase(): MainRoomDatabase?
    fun onFailure(message: String)
    fun populateLocationsInView(list: List<AreaModel>)
}