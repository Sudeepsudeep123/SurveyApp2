package com.survey.project.application.features.Signup

import com.survey.project.application.features.shared.model.SignupModel
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.survey.project.application.utils.FieldValidationUtils
import io.reactivex.disposables.CompositeDisposable

class SignupPresenter : MvpBasePresenter<SignupView>() {
    private var mainInteractor: SignupInteractor? = null
    private var compositeDisposable: CompositeDisposable? = null

    // initialize mainInteractor & compositeDisposable on view attached to presenter
    override fun attachView(view: SignupView) {
        super.attachView(view)
        mainInteractor = SignupInteractor()
        compositeDisposable = CompositeDisposable()
    }

    //dispose compositeDisposable on view detach from presenter
    override fun detachView() {
        mainInteractor = null
        compositeDisposable?.dispose() //dispose all the disposables stored in compositeDisposable
        super.detachView()
    }


    fun onSubmit(
        fullName: String,
        email: String,
        etUserName: String,
        etPassword: String,
        etConfirmPassword: String,
        phone: String,
        fatherName: String,
        motherName: String,
        address: String
    ) {
        ifViewAttached { view ->
            if (FieldValidationUtils.signUpValidation(view,
                    email,
                    etUserName,
                        etPassword,
                        etConfirmPassword,
                        address)) {

                var mainModel = SignupModel(
                    fullName = fullName,
                    email = email,

                    username = etUserName,
                    password = etPassword,
                    confirm_password = etConfirmPassword,

                    phoneNumber = phone,
                    fatherName = fatherName,
                    motherName = motherName,
                    address = address
                )
                mainInteractor?.saveToDB(listOf(mainModel), view.getAppDatabase())
                    ?.subscribe({
                        //onSUccess
                            mainModel ->
                        view.onSuccess(mainModel as List<SignupModel>)
                    },
                        {
                            //onFailure
                                throwable ->
                            view.onFailure(throwable.localizedMessage ?: "")
                        })?.let { compositeDisposable?.add(it) }

            }
        }

    }
    fun getDataFromDB(){

        ifViewAttached { view ->

            mainInteractor?.getDataFromDB(view.getAppDatabase())
                    ?.subscribe({ mainModel ->
                        //onSuccess
                        view.onSuccess(mainModel as List<SignupModel>)
                    }, { throwable ->
                        //onError
                        view.onFailure(throwable.localizedMessage ?: "")
                    })?.let { compositeDisposable?.add(it) } //add disposable to compositeDisposable
            }
        }

}
