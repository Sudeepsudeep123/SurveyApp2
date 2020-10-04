package com.survey.project.application.features.main

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.survey.project.application.features.shared.model.AreaData
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.utils.FieldValidationUtils
import io.reactivex.disposables.CompositeDisposable

class MainPresenter : MvpBasePresenter<MainView>() {
    private var mainInteractor: MainInteractor? = null
    private var compositeDisposable: CompositeDisposable? = null

    override fun attachView(view: MainView) {
        super.attachView(view)
        mainInteractor = MainInteractor()
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        mainInteractor = null
        compositeDisposable?.dispose() //dispose all the disposables stored in compositeDisposable
        super.detachView()
    }

    fun saveLocationToDb(userName: String?, provence: String, zone: String, district: String) {
        ifViewAttached { view ->
            if (FieldValidationUtils.areaValidation(
                    view,
                    provence, zone, district
                )
            ) {
                var mainData = AreaData(
                    username = userName,
                    provence = provence,
                    zone = zone,
                    district = district
                )
                var areaModel = AreaModel(area = mainData)
                mainInteractor?.saveLocationToDb(areaModel, view.getAppDatabase())
                    ?.subscribe({ mainModel ->
                        view.onSuccess(mainModel as AreaModel)
                    },
                        { throwable ->
                            view.onFailure(throwable.localizedMessage ?: "")
                        })?.let { compositeDisposable?.add(it) }
            }
        }
    }


    fun getLocationFromDB() {
        ifViewAttached { view ->
            mainInteractor?.getDataFromDB(view.getAppDatabase())
                ?.subscribe({ mainModel ->
                    //onSuccess
                    view.onGetLocation(mainModel as List<AreaModel>)
                }, { throwable ->
                    //onError
                    view.onFailure(throwable.localizedMessage ?: "")
                })?.let { compositeDisposable?.add(it) }
        }
    }
}
