package com.ainaz.expertsystemlab1.data.questionWithAnswers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question_table")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true) var questionId: Long = 0,
    var questionText: String = "",
    var hint: String = "",
    var isAnswered: Boolean = false,
    var isVisible: Boolean = true,
)