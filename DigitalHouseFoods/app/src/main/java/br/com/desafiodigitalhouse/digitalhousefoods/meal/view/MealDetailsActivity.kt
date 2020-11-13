package br.com.desafiodigitalhouse.digitalhousefoods.meal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.view.RestaurantListFragment

class MealDetailsActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_details)

        manager = supportFragmentManager
        addFragment(MealDetailsFragment())

    }

    private fun addFragment(fragment: Fragment){
        val viewId = R.id.mainContainerMealtDetails
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

}