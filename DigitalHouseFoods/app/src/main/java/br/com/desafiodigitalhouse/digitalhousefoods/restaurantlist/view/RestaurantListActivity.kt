package br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.desafiodigitalhouse.digitalhousefoods.R

class RestaurantListActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)

        manager = supportFragmentManager
        addFragment(RestaurantListFragment())

    }

    private fun addFragment(fragment: Fragment){
        val viewId = R.id.mainContainerRestaurantList
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

}