package br.com.desafiodigitalhouse.digitalhousefoods.restaurant.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.model.Restaurant
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.repository.RestaurantRepository
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.viewmodel.RestaurantListViewModel

class RestaurantListFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var viewModel: RestaurantListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_restaurant_list, container, false)

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            RestaurantListViewModel.RestaurantListViewModelFactory(RestaurantRepository())
        ).get(RestaurantListViewModel::class.java)

        viewModel.restaurantListData.observe(viewLifecycleOwner, Observer{
            createList(it)
        })

        viewModel.getRestaurants()

    }

    private fun createList(restaurantList: List<Restaurant>) {
        val recyclerView = myView.findViewById<RecyclerView>(R.id.restaurantList)
        val manager = LinearLayoutManager(myView.context)

        val restaurantListAdapter = RestaurantListAdapter(restaurantList) {
            val intent = Intent(myView.context, RestaurantDetailsActivity::class.java)
            intent.putExtra("ID", it.id)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = restaurantListAdapter
        }
    }

}