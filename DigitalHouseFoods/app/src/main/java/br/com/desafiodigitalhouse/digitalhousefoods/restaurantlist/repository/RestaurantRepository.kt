package br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.repository

import br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.model.Restaurant

class RestaurantRepository {

    fun getRestaurants(callback: (restaurants: List<Restaurant>) -> Unit) {
        callback.invoke(listOf(
            Restaurant(
                "Tony Roma's",
                "https://miro.medium.com/max/6912/0*HyF5CTiL1asWNDRz",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                "22:00"
            ),
            Restaurant(
                "Aoyama - Moema",
                "https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg",
                "Alameda dos Arapanés, 532 - Moema",
                "00:00"
            ),
            Restaurant(
                "Outback - Moema",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSy4DDwss2rJIS8EU8vEmBJ6xcz_Eif99Y7Jg&usqp=CAU",
                "Av. Moaci, 187, 187 - Moema, São Paulo",
                "00:00"
            ),
            Restaurant(
                "Sí Señor!",
                "https://miro.medium.com/max/4800/0*QBDzYqchWWGQMJ2w.jpeg",
                "Alameda Jauaperi, 626 - Moema\n",
                "01:00"
            )
        ))
    }

}