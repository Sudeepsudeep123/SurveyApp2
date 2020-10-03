package com.survey.project.application.features.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.survey.project.application.R
import com.survey.project.application.database.room.MainRoomDatabase
import com.survey.project.application.features.signup.SignupActivity
import com.survey.project.application.features.main.MainActivity
import com.survey.project.application.features.mainDrawer.DrawerActivity
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpActivity<LoginView, LoginPresenter>(), LoginView,
    View.OnClickListener {
    var userName: String? = ""
    var password: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setListener()
    }

    private fun setListener() {
        btnLogin.setOnClickListener(this)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view) {
            btnLogin -> {
                userName = etUserName.editText?.text.toString()
                password = etPassword.editText?.text.toString()
                presenter.getDataFromDB(userName, password)

            }
            btnRegister -> {
                val intent = Intent(
                    this,
                    SignupActivity::class.java
                )
                startActivity(intent)
            }
        }
    }

    override fun createPresenter() = LoginPresenter()

    override fun onSuccess(mainModel: List<SignupModel>) {
        Log.e("here", mainModel.toString())
        if (mainModel.isNotEmpty()) {
//            val intent = Intent(
//                this,
//                MainActivity::class.java
//            )
//            intent.putExtra("username", mainModel[0].username)
//            startActivity(intent)
            presenter.getLocationFromDB()

        } else {
            Toast.makeText(this, "Username/Password Invalid", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onGetLocation(mainModel: List<AreaModel>) {
        if (mainModel.isEmpty()) {
            val intent = Intent(
                this,
                MainActivity::class.java
            )
            intent.putExtra("username", userName)
            startActivity(intent)

        } else {

            for (a in 0 until mainModel?.size) {
                var areaData = mainModel[a].area
                for (a in 0 until areaData?.size!!) {
                    Log.e("username", areaData[a].username)
                    if (areaData[a].username.equals(userName)) {

                        var intentDrawer = Intent(this, DrawerActivity::class.java)
                        intentDrawer.putExtra("username", userName)
                        intentDrawer.putExtra("provence", areaData[a].provence)
                        intentDrawer.putExtra("zone", areaData[a].zone)
                        intentDrawer.putExtra("district", areaData[a].district)

                        startActivity(intentDrawer)
                    } else {
                        val intent = Intent(
                            this,
                            MainActivity::class.java
                        )
                        intent.putExtra("username", userName)
                        startActivity(intent)
                    }
                }


            }
        }
    }


    override fun onFailure(message: String) {
        Log.e("here", message + "asd")
        Toast.makeText(this, "Username/Password Invalid", Toast.LENGTH_SHORT).show()
    }

    override fun getAppDatabase(): MainRoomDatabase? = MainRoomDatabase.getAppDatabase(this)
    override fun showToast(messageInt: Int) {
        Toast.makeText(this, messageInt, Toast.LENGTH_SHORT).show()
    }

}