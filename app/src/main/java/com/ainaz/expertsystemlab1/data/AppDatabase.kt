package com.ainaz.expertsystemlab1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ainaz.expertsystemlab1.data.questionWithAnswers.AnswerEntity
import com.ainaz.expertsystemlab1.data.gis.GisDao
import com.ainaz.expertsystemlab1.data.gis.GisEntity
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionAnswerDao
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionEntity

@Database(
    version = 2,
    entities = [GisEntity::class, QuestionEntity::class, AnswerEntity::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getGisDao(): GisDao

    abstract fun getQuestionAnswerDao(): QuestionAnswerDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}