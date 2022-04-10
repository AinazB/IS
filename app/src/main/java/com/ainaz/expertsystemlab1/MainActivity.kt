package com.ainaz.expertsystemlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.RoomDatabase
import com.ainaz.expertsystemlab1.data.AppDatabase

class MainActivity : AppCompatActivity() {
    val database by lazy { AppDatabase.getDatabase(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}