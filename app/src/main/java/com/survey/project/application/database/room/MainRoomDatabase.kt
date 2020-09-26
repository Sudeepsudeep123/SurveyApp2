package com.survey.project.application.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.survey.project.application.database.typeConverter.AreaTypeConverterClass
import com.survey.project.application.features.shared.model.AreaModel
import com.survey.project.application.features.shared.model.SignupModel
import com.survey.project.application.utils.constants.DbConstants

@Database(entities = [SignupModel::class, AreaModel::class],version = 1)
@TypeConverters(
    AreaTypeConverterClass::class
)
abstract class MainRoomDatabase : RoomDatabase() {
    abstract fun appdao(): AppDao

    companion object {
        private var appDatabase: MainRoomDatabase? = null

        fun getAppDatabase(context: Context?) =
            if (appDatabase != null && appDatabase?.isOpen == true) {
                appDatabase
            } else {
                if (context != null)
                    Room.databaseBuilder(context, MainRoomDatabase::class.java, DbConstants.dbName)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                else
                    null
            }
    }
}