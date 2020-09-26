package com.survey.project.application.features.base

import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

abstract class BaseFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>(), BaseView{
}