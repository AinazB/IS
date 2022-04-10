package com.ainaz.expertsystemlab1.data.questionWithAnswers

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded var question: QuestionEntity,
    @Relation(
        parentColumn = "questionId",
        entityColumn = "questionId"
    )
    val answers: List<AnswerEntity>
)