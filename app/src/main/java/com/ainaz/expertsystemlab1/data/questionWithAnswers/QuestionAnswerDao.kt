package com.ainaz.expertsystemlab1.data.questionWithAnswers

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionAnswerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun insertQuestion(question: QuestionEntity): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    suspend fun insertAnswers(answer: AnswerEntity): Long

    @Transaction
    @Query("SELECT * FROM question_table")
    fun getQuestionsWithAnswers(): Flow<List<QuestionWithAnswers>>

    @Transaction
    suspend fun insertQuestionWithAnswers(question: QuestionEntity, answers: List<AnswerEntity>) {
        val questionId = insertQuestion(question)
        answers.forEach {
            it.questionId = questionId
            insertAnswers(it)
        }
    }
}