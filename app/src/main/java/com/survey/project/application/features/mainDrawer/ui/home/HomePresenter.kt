package com.survey.project.application.features.mainDrawer.ui.home

import android.util.Log
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.survey.project.application.features.main.MainInteractor
import com.survey.project.application.features.main.MainView
import com.survey.project.application.features.shared.model.AreaModel
import io.reactivex.disposables.CompositeDisposable

class HomePresenter : MvpBasePresenter<HomeView>()  {
    private var mainInteractor: MainInteractor? = null
    private var compositeDisposable: CompositeDisposable? = null

    override fun attachView(view: HomeView) {
        super.attachView(view)
        mainInteractor = MainInteractor()
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        mainInteractor = null
        compositeDisposable?.dispose() //dispose all the disposables stored in compositeDisposable
        super.detachView()
    }
    fun getLocationFromDB() {
        ifViewAttached { view ->
            mainInteractor?.getDataFromDB(view.getAppDatabase())
                ?.subscribe({ mainModel ->
                    //onSuccess
                    Log.d("mainmodelkosize",mainModel.size.toString())
                    view.populateLocationsInView(mainModel as List<AreaModel>)
                }, { throwable ->
                    //onError
                    view.onFailure(throwable.localizedMessage ?: "")
                })?.let { compositeDisposable?.add(it) }
        }
    }
}