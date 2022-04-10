package com.ainaz.expertsystemlab1.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ainaz.expertsystemlab1.MainActivity
import com.ainaz.expertsystemlab1.R
import com.ainaz.expertsystemlab1.data.AppDatabase
import com.ainaz.expertsystemlab1.data.questionWithAnswers.AnswerEntity
import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionEntity
import com.ainaz.expertsystemlab1.databinding.FragmentQuestoinsBinding
import com.ainaz.expertsystemlab1.ui.QuestionsViewModel
import com.ainaz.expertsystemlab1.ui.QuestionsViewModelFactory
import com.ainaz.expertsystemlab1.ui.result.ResultFragment
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class QuestionsFragment : Fragment() {
    private var _binding: FragmentQuestoinsBinding? = null
    private val binding get() = _binding!!
    private var adapter = QuestionAdapter()

    private val viewModel: QuestionsViewModel by activityViewModels {
        QuestionsViewModelFactory((activity as MainActivity).database)
    }

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = (requireActivity() as MainActivity).database
        viewModel.getQuestions()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestoinsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter.setHasStableIds(true)
        binding.questions.adapter = adapter
        binding.getResult.setOnClickListener { getResult() }
        binding.insertGis.setOnClickListener { insertData() }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.questionsWithAnswers.collect {
                adapter.setQuestions(it)
            }
        }
//        runBlocking {
//            val question0 = QuestionEntity(
//                questionText = "Выберите страну-производителя:",
//                hint = "Страна производства ГИС"
//            )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question0,
//                listOf(
//                    AnswerEntity(questionId = question0.questionId, answer = "Россия"),
//                    AnswerEntity(questionId = question0.questionId, answer = "Япония"),
//                    AnswerEntity(questionId = question0.questionId, answer = "Китай"),
//                    AnswerEntity(questionId = question0.questionId, answer = "США"),
//                    AnswerEntity(questionId = question0.questionId, answer = "Германия"),
//                    AnswerEntity(questionId = question0.questionId, answer = "Южная Корея"),
//                )
//            )
//
//            //1
//            val question1 =
//                QuestionEntity(questionText = "Выберите архитектурный принцип построения:")
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question1,
//                listOf(
//                    AnswerEntity(questionId = question1.questionId, answer = "Открытый"),
//                    AnswerEntity(questionId = question1.questionId, answer = "Закрытый"),
//                )
//            )
//
//            //2
//            val question2 =
//                QuestionEntity(
//                    questionText = "Выберите необходимый территоральный охват:",
//                    hint = "территоральный охват - максимальная область работы ГИС"
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question2,
//                listOf(
//                    AnswerEntity(questionId = question2.questionId, answer = "глобальные"),
//                    AnswerEntity(questionId = question2.questionId, answer = "субконтинентальные"),
//                    AnswerEntity(questionId = question2.questionId, answer = "национальные"),
//                    AnswerEntity(questionId = question2.questionId, answer = "субрегиональные"),
//                    AnswerEntity(questionId = question2.questionId, answer = "локальные"),
//                    AnswerEntity(questionId = question2.questionId, answer = "сублокальные"),
//                )
//            )
//
//            //3
//            val question3 =
//                QuestionEntity(
//                    questionText = "Выберите необходимую предметную область:",
//                    hint = "Предметная область - область применения ГИС, специализация"
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question3,
//                listOf(
//                    AnswerEntity(questionId = question3.questionId, answer = "природоохранная"),
//                    AnswerEntity(questionId = question3.questionId, answer = "земельная"),
//                    AnswerEntity(
//                        questionId = question3.questionId,
//                        answer = "мониторинга водных ресурсов"
//                    ),
//                    AnswerEntity(questionId = question3.questionId, answer = "георазведка"),
//                )
//            )
//
//            //4
//            val question4 =
//                QuestionEntity(
//                    questionText = "Выберите тип используемой графики:",
//                    hint = "Выделяют два вида компьютерной графики — растровую и векторную. Растровое изображение представляет собой массив отдельных точек (видеопикселов или просто пикселов). Объекты описываются векторами фиксированной длины (точка — координатами, линия — координатами ее начала и конца, ломаная — координатами всех ее вершин и т.д.), отсюда название — векторная графика."
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question4,
//                listOf(
//                    AnswerEntity(questionId = question4.questionId, answer = "векторные гис"),
//                    AnswerEntity(questionId = question4.questionId, answer = "растровые гис"),
//                    AnswerEntity(questionId = question4.questionId, answer = "гибридные гис"),
//                )
//            )
//
//            //5
//            val question5 =
//                QuestionEntity(
//                    questionText = "Нужна ли поддержка интегрирования субд?",
//                    hint = "Система управления базами данных (СУБД) — совокупность программных и лингвистических средств общего или специального назначения, обеспечивающих управление созданием и использованием баз данных."
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question5,
//                listOf(
//                    AnswerEntity(questionId = question5.questionId, answer = "Нужна"),
//                    AnswerEntity(questionId = question5.questionId, answer = "Не нужна"),
//                )
//            )
//
//            //6
//            val question6 =
//                QuestionEntity(
//                    questionText = "Нужна ли поддержка клиент-серверного взаимодействия?",
//                    hint = "Клиент-серверное взаимодействие — это обмен данными между клиентом и сервером."
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question6,
//                listOf(
//                    AnswerEntity(questionId = question6.questionId, answer = "Нужна"),
//                    AnswerEntity(questionId = question6.questionId, answer = "Не нужна"),
//                )
//            )
//
//            //7
//            val question7 =
//                QuestionEntity(
//                    questionText = "Нужна ли поддержка облачных вычислений?",
//                    hint = "Облачные вычисления — это предоставление вычислительных служб (в том числе серверов, хранилища, баз данных, сетей, программного обеспечения, аналитики и интеллектуального анализа) через Интернет (\"облако\")."
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question7,
//                listOf(
//                    AnswerEntity(questionId = question7.questionId, answer = "Нужна"),
//                    AnswerEntity(questionId = question7.questionId, answer = "Не нужна"),
//                )
//            )
//
//            //8
//            val question8 =
//                QuestionEntity(
//                    questionText = "Нужна ли поддержка мобильных платформ?",
//                    hint = "Поддержка устройств мобильных платформ, например устройств ios/android"
//                )
//            database.getQuestionAnswerDao().insertQuestionWithAnswers(
//                question = question8,
//                listOf(
//                    AnswerEntity(questionId = question8.questionId, answer = "Нужна"),
//                    AnswerEntity(questionId = question8.questionId, answer = "Не нужна"),
//                )
//            )
//
//        }

    }


    //    @Query(
//        """SELECT *
//                FROM gis_table
//                WHERE prise <= :prise
//                AND producerCountry IN (:producerCountry)
//                AND archPrinciple IN (:archPrinciple)
//                AND territoryCoverage IN (:territoryCoverage)
//                AND subjectArea IN (:subjectArea)
//                AND graphType IN (:graphType)
//                AND dbmsIntegration = :dbmsIntegration
//                AND clientServer = :clientServer
//                AND cloudComputation = :cloudComputation
//                AND mobilePlatforms = :mobilePlatforms
//                """
//    )
    private fun getResult() {
        val country = adapter.items[0].answers.first { it.isSelected }.answer
        val archPrinciple = adapter.items[1].answers.first { it.isSelected }.answer
        val coverage = adapter.items[2].answers.first { it.isSelected }.answer
        val area = adapter.items[3].answers.first { it.isSelected }.answer
        val graphType = adapter.items[4].answers.first { it.isSelected }.answer
        val dbms = adapter.items[5].answers.first { it.isSelected }.answer == "Нужна"
        val clientServer = adapter.items[6].answers.first { it.isSelected }.answer == "Нужна"
        val cloud = adapter.items[7].answers.first { it.isSelected }.answer == "Нужна"
        val mobile = adapter.items[8].answers.first { it.isSelected }.answer == "Нужна"

//        viewModel.getFilteredGisList(
//            0,
//            producerCountry = country,
//            archPrinciple = archPrinciple,
//            territoryCoverage = coverage,
//            subjectArea = area,
//            graphType = graphType,
//            dbmsIntegration = dbms,
//            clientServer = clientServer,
//            cloudComputation = cloud,
//            mobilePlatforms = mobile
//        )
        viewModel.getFilteredGisListTest(mobile)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, ResultFragment())
            .addToBackStack(ResultFragment::class.java.simpleName)
            .commit()
    }

    fun insertData() {
        viewModel.insertGis()
    }
}
