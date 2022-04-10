package com.ainaz.expertsystemlab1.data.questionWithAnswers

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "answer_table")
data class AnswerEntity(
    @PrimaryKey(autoGenerate = true) var answerId: Long = 0,
    var questionId: Long = 0,
    var answer: String = "",
    var isSelected: Boolean = false,
    var isVisible: Boolean = true
)