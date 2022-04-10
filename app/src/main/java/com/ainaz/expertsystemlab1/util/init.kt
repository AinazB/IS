//import com.ainaz.expertsystemlab1.data.questionWithAnswers.AnswerEntity
//import com.ainaz.expertsystemlab1.data.questionWithAnswers.QuestionEntity
//
////viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//    //0
//    val question0 = QuestionEntity(
//        questionText = "Выберите страну-производителя:",
//        hint = "Страна производства ГИС"
//    )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question0,
//        listOf(
//            AnswerEntity(questionId = question0.questionId, answer = "Россия"),
//            AnswerEntity(questionId = question0.questionId, answer = "Япония"),
//            AnswerEntity(questionId = question0.questionId, answer = "Китай"),
//            AnswerEntity(questionId = question0.questionId, answer = "США"),
//            AnswerEntity(questionId = question0.questionId, answer = "Германия"),
//            AnswerEntity(questionId = question0.questionId, answer = "Южная Корея"),
//        )
//    )
//
//    //1
//    val question1 =
//        QuestionEntity(questionText = "Выберите архитектурный принцип построения:")
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question1,
//        listOf(
//            AnswerEntity(questionId = question1.questionId, answer = "Открытый"),
//            AnswerEntity(questionId = question1.questionId, answer = "Закрытый"),
//        )
//    )
//
//    //2
//    val question2 =
//        QuestionEntity(
//            questionText = "Выберите необходимый территоральный охват:",
//            hint = "территоральный охват - максимальная область работы ГИС"
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question2,
//        listOf(
//            AnswerEntity(questionId = question2.questionId, answer = "глобальные"),
//            AnswerEntity(questionId = question2.questionId, answer = "субконтинентальные"),
//            AnswerEntity(questionId = question2.questionId, answer = "национальные"),
//            AnswerEntity(questionId = question2.questionId, answer = "субрегиональные"),
//            AnswerEntity(questionId = question2.questionId, answer = "локальные"),
//            AnswerEntity(questionId = question2.questionId, answer = "сублокальные"),
//        )
//    )
//
//    //3
//    val question3 =
//        QuestionEntity(
//            questionText = "Выберите необходимую предметную область:",
//            hint = "Предметная область - область применения ГИС, специализация"
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question3,
//        listOf(
//            AnswerEntity(questionId = question3.questionId, answer = "природоохранная"),
//            AnswerEntity(questionId = question3.questionId, answer = "земельная"),
//            AnswerEntity(
//                questionId = question3.questionId,
//                answer = "мониторинга водных ресурсов"
//            ),
//            AnswerEntity(questionId = question3.questionId, answer = "георазведка"),
//        )
//    )
//
//    //4
//    val question4 =
//        QuestionEntity(
//            questionText = "Выберите тип используемой графики:",
//            hint = "Выделяют два вида компьютерной графики — растровую и векторную. Растровое изображение представляет собой массив отдельных точек (видеопикселов или просто пикселов). Объекты описываются векторами фиксированной длины (точка — координатами, линия — координатами ее начала и конца, ломаная — координатами всех ее вершин и т.д.), отсюда название — векторная графика."
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question4,
//        listOf(
//            AnswerEntity(questionId = question4.questionId, answer = "векторные гис"),
//            AnswerEntity(questionId = question4.questionId, answer = "растровые гис"),
//            AnswerEntity(questionId = question4.questionId, answer = "гибридные гис"),
//        )
//    )
//
//    //5
//    val question5 =
//        QuestionEntity(
//            questionText = "Нужна ли поддержка интегрирования субд?",
//            hint = "Система управления базами данных (СУБД) — совокупность программных и лингвистических средств общего или специального назначения, обеспечивающих управление созданием и использованием баз данных."
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question5,
//        listOf(
//            AnswerEntity(questionId = question5.questionId, answer = "Нужна"),
//            AnswerEntity(questionId = question5.questionId, answer = "Не нужна"),
//        )
//    )
//
//    //6
//    val question6 =
//        QuestionEntity(
//            questionText = "Нужна ли поддержка клиент-серверного взаимодействия?",
//            hint = "Клиент-серверное взаимодействие — это обмен данными между клиентом и сервером."
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question6,
//        listOf(
//            AnswerEntity(questionId = question6.questionId, answer = "Нужна"),
//            AnswerEntity(questionId = question6.questionId, answer = "Не нужна"),
//        )
//    )
//
//    //7
//    val question7 =
//        QuestionEntity(
//            questionText = "Нужна ли поддержка облачных вычислений?",
//            hint = "Облачные вычисления — это предоставление вычислительных служб (в том числе серверов, хранилища, баз данных, сетей, программного обеспечения, аналитики и интеллектуального анализа) через Интернет (\"облако\")."
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question7,
//        listOf(
//            AnswerEntity(questionId = question7.questionId, answer = "Нужна"),
//            AnswerEntity(questionId = question7.questionId, answer = "Не нужна"),
//        )
//    )
//
//    //8
//    val question8 =
//        QuestionEntity(
//            questionText = "Нужна ли поддержка мобильных платформ?",
//            hint = "Поддержка устройств мобильных платформ, например устройств ios/android"
//        )
//    database.getQuestionAnswerDao().insertQuestionWithAnswers(
//        question = question8,
//        listOf(
//            AnswerEntity(questionId = question8.questionId, answer = "Нужна"),
//            AnswerEntity(questionId = question8.questionId, answer = "Не нужна"),
//        )
//    )
