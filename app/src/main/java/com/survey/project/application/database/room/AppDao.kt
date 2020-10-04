package com.survey.project.application.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel
import com.survey.project.application.utils.constants.DbConstants
import io.reactivex.Single

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(signupModel: List<SignupModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArea(signupModel: AreaModel)

    @Query("SELECT * FROM ${DbConstants.userTable}")
    fun getData(): Single<List<SignupModel>>

    @Query("SELECT * FROM ${DbConstants.areaTable}" )
    fun getAreaData(): Single<List<AreaModel>>

    @Query("SELECT * FROM ${DbConstants.userTable}  WHERE username = :username AND password = :password")
    fun loginUser(username: String?, password: String?): Single<List<SignupModel>>



}