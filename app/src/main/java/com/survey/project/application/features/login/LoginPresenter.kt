package com.survey.project.application.features.login

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.survey.project.application.features.signup.SignupInteractor
import com.survey.project.application.features.main.MainInteractor
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel
import com.survey.project.application.utils.FieldValidationUtils
import io.reactivex.disposables.CompositeDisposable

class LoginPresenter : MvpBasePresenter<LoginView>() {
    private var mainInteractor: SignupInteractor? = null
    private var compositeDisposable: CompositeDisposable? = null
    private var mainInteractor1: MainInteractor? = null


    override fun attachView(view: LoginView) {
        super.attachView(view)
        mainInteractor1 = MainInteractor()
        mainInteractor = SignupInteractor()
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        mainInteractor = null
        mainInteractor1 = null
        compositeDisposable?.dispose() //dispose all the disposables stored in compositeDisposable
        super.detachView()
    }

    fun getUserFromDb(userName: String?, password: String?) {
        ifViewAttached { view ->
            if (FieldValidationUtils.loginValidation(
                    view,
                    userName, password
                )
            ) {
                userName?.let {
                    password?.let { password ->
                        mainInteractor?.getUserFromDB(view.getAppDatabase(), it, password)
                            ?.subscribe({ mainModel ->
                                //onSuccess
                                view.onSuccess(mainModel as List<SignupModel>)
                            }, { throwable ->
                                //onError
                                view.onFailure(throwable.localizedMessage ?: "")
                            })?.let { compositeDisposable?.add(it) }
                    }
                }
            }
        }
    }

    fun getLocationFromDB() {
        ifViewAttached { view ->
            mainInteractor1?.getDataFromDB(view.getAppDatabase())
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