package com.survey.project.application.features.shared.repository

import android.util.Log
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.shared.model.SignupModel
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UserRepository {

    fun getDataFromDB(appDatabase: MainRoomDatabase?): Single<List<SignupModel>> =
        Single.create { e ->
            appDatabase?.appdao()?.getData()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ response ->
                    Log.e("Success", response.toString())
                    e.onSuccess((response))
                }, {
                    Log.d("errorMsg", it.message)
                    e.onError(Throwable(it.localizedMessage))
                })
        }

    fun getUserFromDB(appDatabase: MainRoomDatabase?,username:String,password:String): Single<List<SignupModel>> =
        Single.create { e ->
            appDatabase?.appdao()?.loginUser(username,password)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ response ->
                    Log.e("Success", response.toString())
                    e.onSuccess((response))
                }, {
                    Log.d("errorMsg", it.message)
                    e.onError(Throwable(it.localizedMessage))
                })
        }

    fun saveToDb(dataResponse: List<SignupModel>, appDatabase: MainRoomDatabase?): Single<List<SignupModel>>? =
        Completable.fromAction {
            appDatabase?.appdao()?.insert(dataResponse)
        }.toSingleDefault(dataResponse)
}


