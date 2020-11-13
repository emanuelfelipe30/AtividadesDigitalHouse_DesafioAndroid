package br.com.desafiodigitalhouse.digitalhousefoods.restaurant.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.model.Restaurant
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.repository.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class RestaurantListViewModel(
    private val repository: RestaurantRepository
): ViewModel() {

    val restaurantListData = MutableLiveData<List<Restaurant>>()

    fun getRestaurants() {
        repository.getRestaurants {
            restaurantListData.value = it
        }
    }

    class RestaurantListViewModelFactory(
        private val repository: RestaurantRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RestaurantListViewModel(repository) as T
        }

    }
}