package com.survey.project.application.features.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.survey.project.application.R
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.login.LoginActivity
import com.survey.project.application.features.shared.model.SignupModel
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : MvpActivity<SignupView, SignupPresenter>(), SignupView,
    View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setListener()
    }

    private fun setListener() {
        btnSubmit.setOnClickListener(this)
        btnData.setOnClickListener(this)

    }

    override fun createPresenter() = SignupPresenter()

    override fun onSuccess(mainModel: List<SignupModel>) {

        Log.e("data", mainModel.toString())
        Toast.makeText(this, "New account Created", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, LoginActivity::class.java))
    }


    override fun onFailure(message: String) {
        Log.e("failure", message)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getAppDatabase(): MainRoomDatabase? = MainRoomDatabase.getAppDatabase(this)
    override fun showToast(messageInt: Int) {
        Toast.makeText(this, messageInt, Toast.LENGTH_SHORT).show()
    }


    override fun onClick(view: View?) {
        when (view) {
            btnSubmit -> {

                presenter.onSubmit(
                    etFullName.editText?.text.toString(),
                    etEmail.editText?.text.toString(),
                    etUserName.editText?.text.toString(),
                    etPassword.editText?.text.toString(),
                    etConfirmPassword.editText?.text.toString(),
                    etPhone.editText?.text.toString(),
                    etFatherName.editText?.text.toString(),
                    etMotherName.editText?.text.toString(),
                    etAddress.editText?.text.toString()
                )
            }

            btnData -> {
                presenter.getDataFromDB()
            }
        }
    }
}