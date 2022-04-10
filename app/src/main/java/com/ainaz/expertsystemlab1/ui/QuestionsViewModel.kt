package com.ainaz.expertsystemlab1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ainaz.expertsystemlab1.data.AppDatabase
import com.ainaz.expertsystemlab1.data.gis.GisEntity
import com.ainaz.expertsystemlab1.data.questionWithAnswers.AnswerEntity
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionEntity
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionWithAnswers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class QuestionsViewModel(private val database: AppDatabase) : ViewModel() {

    val questionsWithAnswers: MutableStateFlow<List<QuestionWithAnswers>> =
        MutableStateFlow(listOf())

    val gisList: MutableStateFlow<List<GisEntity>> = MutableStateFlow(listOf())

    fun getQuestions() = viewModelScope.launch {
        database.getQuestionAnswerDao().getQuestionsWithAnswers().collect {
            questionsWithAnswers.emit(it)
        }
    }

    fun getFilteredGisList(
        prise: Int = 0,
        producerCountry: String,
        archPrinciple: String,
        territoryCoverage: String,
        subjectArea: String,
        graphType: String,
        dbmsIntegration: Boolean,
        clientServer: Boolean,
        cloudComputation: Boolean,
        mobilePlatforms: Boolean
    ) = viewModelScope.launch {
        database.getGisDao().getFilteredGisList(
            prise = prise,
            producerCountry = producerCountry,
            archPrinciple = archPrinciple,
            territoryCoverage = territoryCoverage,
            subjectArea = subjectArea,
            graphType = graphType,
            dbmsIntegration = dbmsIntegration,
            clientServer = clientServer,
            cloudComputation = cloudComputation,
            mobilePlatforms = mobilePlatforms
        ).collect {
            gisList.emit(it)
        }
    }

    fun getFilteredGisListTest(
        mobilePlatforms: Boolean
    ) = viewModelScope.launch {
        database.getGisDao().getFilteredGisListTest(
            mobilePlatforms = mobilePlatforms
        ).collect {
            gisList.emit(it)
        }
    }

//    @Entity(tableName = "gis_table")
//    class GisEntity(
//        @PrimaryKey(autoGenerate = true)
//        val id: Long = 0,
//        val prise: Int?,
//        val producerCountry: String?,
//        val archPrinciple: String?,
//        val territoryCoverage: String?,
//        val subjectArea: String?,
//        val graphType: String?,
//        val dbmsIntegration: String?,
//        val clientServer: String?,
//        val cloudComputation: String?,
//        val mobilePlatforms: String?
//    )

    fun insertGis() = viewModelScope.launch {
        database.getGisDao().addGis(
            GisEntity(
                prise = 5000,
                name = "ARGO",
                producerCountry = "Россия",
                archPrinciple = "Открытый",
                territoryCoverage = "локальные",
                subjectArea = "земельная",
                graphType = "векторные гис",
                dbmsIntegration = false,
                clientServer = false,
                cloudComputation = false,
                mobilePlatforms = false
            )
        )
    }

}


class QuestionsViewModelFactory(private val database: AppDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return QuestionsViewModel(database) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}