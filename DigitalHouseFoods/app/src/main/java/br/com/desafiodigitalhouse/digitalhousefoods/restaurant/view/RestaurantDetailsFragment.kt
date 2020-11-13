package br.com.desafiodigitalhouse.digitalhousefoods.restaurant.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.repository.RestaurantRepository
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.viewmodel.RestaurantDetailsViewModel
import com.squareup.picasso.Picasso

class RestaurantDetailsFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var viewModel: RestaurantDetailsViewModel

    private lateinit var imgRestaurantDetails : ImageView
    private lateinit var txtRestaurantNameDetails : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView =  inflater.inflate(R.layout.fragment_restaurant_details, container, false)

        imgRestaurantDetails = myView.findViewById(R.id.imgRestaurantDetails)
        txtRestaurantNameDetails = myView.findViewById(R.id.txtRestaurantNameDetails)
        imgRestaurantDetails.setImageResource(R.drawable.ic_launcher_foreground)

        myView.findViewById<Button>(R.id.btnBackToRestaurantList).setOnClickListener {
            activity?.finish()
        }

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            RestaurantDetailsViewModel.RestaurantDetailsViewModelFactory(RestaurantRepository())
        ).get(RestaurantDetailsViewModel::class.java)

        val viewOwner = viewLifecycleOwner
        viewModel.restaurantData.observe(viewOwner, Observer{
            Picasso.get()
                .load(it.urlImage)
                .into(imgRestaurantDetails)
            txtRestaurantNameDetails.text = it.name
        })

        val data = arguments
        val id = data?.getInt("ID",0)
        viewModel.getRestaurantById(id!!)

    }

}