package br.com.desafiodigitalhouse.digitalhousefoods.meal.repository

import br.com.desafiodigitalhouse.digitalhousefoods.meal.model.Meal

class MealRepository {

    private val mealList = listOf(
        Meal(
            1,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            2,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            3,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            4,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            5,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            6,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            7,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            8,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            9,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            10,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            11,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            12,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            13,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            14,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            15,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        ),
        Meal(
            16,
            "Salada com molho Gengibre",
            "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg"
        )
    )

    fun getMeals(callback: (restaurants: List<Meal>) -> Unit) {
        callback.invoke(mealList)
    }

    fun getMealById(id: Int, callback: (meal: Meal?) -> Unit) {
        callback.invoke(mealList.firstOrNull{it.id == id})
    }

}