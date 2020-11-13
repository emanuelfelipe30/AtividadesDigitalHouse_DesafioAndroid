package br.com.desafiodigitalhouse.digitalhousefoods.meal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.desafiodigitalhouse.digitalhousefoods.meal.model.Meal
import br.com.desafiodigitalhouse.digitalhousefoods.meal.repository.MealRepository
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.model.Restaurant
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.repository.RestaurantRepository

@Suppress("UNCHECKED_CAST")
class MealListViewModel(
    private val repository: MealRepository
): ViewModel() {

    val mealListData = MutableLiveData<List<Meal>>()

    fun getMeals() {
        repository.getMeals {
            mealListData.value = it
        }
    }

    class MealListViewModelFactory(
        private val repository: MealRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MealListViewModel(repository) as T
        }

    }
}