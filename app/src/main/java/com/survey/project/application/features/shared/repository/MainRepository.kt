package com.survey.project.application.features.shared.repository

import android.util.Log
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.AreaData
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepository {

    fun getLocationDataFromDB(appDatabase: MainRoomDatabase?): Single<List<AreaModel>> =
        Single.create { e ->
            appDatabase?.appdao()?.getAreaData()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ response ->
                    Log.e("Success", response.toString())
                    e.onSuccess((response))
                }, {
                    Log.d("errorMsg", it.message ?: "khali cha")
                    e.onError(Throwable(it.localizedMessage))
                })
        }

    fun saveLocationToDb(areaRequest: AreaModel, appDatabase: MainRoomDatabase?): Single<AreaModel>? =
        Completable.fromAction {
            appDatabase?.appdao()?.insertArea(areaRequest)
        }.toSingleDefault(areaRequest)

}