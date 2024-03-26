package com.prove.triviaapp.domain.question

enum class QuestionCategory(val categoryName: String) {
    MusicalAndTheaters("Musical and theaters"),
    Television("Television"),
    VideoGames("Video games"),
    BoardGames("Board games"),
    ScienceAndNature("Science and Nature"),
    Computers("Computers"),
    Mathematics("Mathematics"),
    Mythology("Mythology"),
    Sports("Sports"),
    Geography("Geography"),
    History("History"),
    Politics("Politics"),
    Art("Art"),
    Celebrities("Celebrities"),
    Animals("Animals"),
    Vehicles("Vehicles"),
    Comics("Comics"),
    Gadgets("Gadgets"),
    AnimesAndMangas("animes and mangas"),
    Cartoon("Cartoon");

    companion object {
        fun fromCategoryName(categoryName: String): QuestionCategory {
            return entries.firstOrNull { it.categoryName.equals(categoryName, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown QuestionCategory: $categoryName")
        }
    }
}
