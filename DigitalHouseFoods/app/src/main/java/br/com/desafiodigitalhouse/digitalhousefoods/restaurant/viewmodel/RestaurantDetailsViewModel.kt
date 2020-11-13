package br.com.desafiodigitalhouse.digitalhousefoods.restaurant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.model.Restaurant
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.repository.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class RestaurantDetailsViewModel(
    private val repository: RestaurantRepository
): ViewModel() {

    val restaurantData = MutableLiveData<Restaurant>()

    fun getRestaurantById(id: Int) {
        repository.getRestaurantById(id) {
            restaurantData.value = it
        }
    }

    class RestaurantDetailsViewModelFactory(
        private val repository: RestaurantRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantDetailsViewModel(repository) as T
        }

    }
}