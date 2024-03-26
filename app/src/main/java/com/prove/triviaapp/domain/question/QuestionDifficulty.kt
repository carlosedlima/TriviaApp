package com.prove.triviaapp.domain.question

enum class QuestionDifficulty(val difficulty: String) {
    Easy("easy"),
    Medium("medium"),
    Hard("hard");

    companion object {
        fun fromDifficulty(difficulty: String): QuestionDifficulty {
            return entries.firstOrNull { it.difficulty.equals(difficulty, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown QuestionDifficulty: $difficulty")
        }
    }
}