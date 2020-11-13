package br.com.desafiodigitalhouse.digitalhousefoods.restaurant.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.meal.view.MealListFragment

class RestaurantDetailsActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        val restaurantId = intent.getIntExtra("ID", 0)

        if(restaurantId == 0){
            finish()
        } else {

            manager = supportFragmentManager
            val restaurantDetailsFragment = RestaurantDetailsFragment()
            val data = Bundle()
            data.putInt("ID", restaurantId)
            restaurantDetailsFragment.arguments = data
            addFragment(restaurantDetailsFragment, R.id.mainContainerRestaurantDetails)
            addFragment(MealListFragment(), R.id.mainContainerMealList)

        }

    }


    private fun addFragment(fragment: Fragment, viewId: Int){
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

}