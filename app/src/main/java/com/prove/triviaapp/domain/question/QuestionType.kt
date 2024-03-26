package com.prove.triviaapp.domain.question

enum class QuestionType(val type: String) {
    multiple("MultipleChoice"),
    boolean("True Or False");

    companion object {
        fun fromType(type: String): QuestionType {
            return entries.firstOrNull { it.type.equals(type, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown QuestionType: $type")
        }
    }
}