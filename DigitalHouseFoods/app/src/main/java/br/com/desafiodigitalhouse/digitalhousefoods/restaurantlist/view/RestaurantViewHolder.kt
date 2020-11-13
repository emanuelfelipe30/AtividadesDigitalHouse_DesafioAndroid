package br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.view

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.model.Restaurant
import com.squareup.picasso.Picasso

class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val imgRestaurant = view.findViewById<ImageView>(R.id.imgRestaurant)
    private val txtRestaurantName = view.findViewById<TextView>(R.id.txtRestaurantName)
    private val txtRestaurantAddress = view.findViewById<TextView>(R.id.txtRestaurantAddress)
    private val txtRestaurantCloseHour = view.findViewById<TextView>(R.id.txtRestaurantCloseHour)

    fun bind(restaurant: Restaurant) {

        Picasso.get()
            .load(restaurant.urlImage)
            .into(imgRestaurant)

        txtRestaurantName.text = restaurant.name
        txtRestaurantAddress.text = restaurant.address
        txtRestaurantCloseHour.text = itemView.context.getString(R.string.closes_at, restaurant.closeHour)

    }

}