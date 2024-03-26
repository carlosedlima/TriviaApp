package com.prove.triviaapp.domain.question

data class Question(
    val type: QuestionType,
    val difficulty: QuestionDifficulty,
    val category: QuestionCategory,
    val question: String,
    val correct_answer: String,
    val incorrect_answers: List<String>
)