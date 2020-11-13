package br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.model.Restaurant
import br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.repository.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class RestaurantViewModel(
    private val repository: RestaurantRepository
): ViewModel() {

    val restaurantListData = MutableLiveData<List<Restaurant>>()

    fun getRestaurants() {
        repository.getRestaurants {
            restaurantListData.value = it
        }
    }

    class RestaurantViewModelFactory(
        private val repository: RestaurantRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantViewModel(repository) as T
        }

    }
}