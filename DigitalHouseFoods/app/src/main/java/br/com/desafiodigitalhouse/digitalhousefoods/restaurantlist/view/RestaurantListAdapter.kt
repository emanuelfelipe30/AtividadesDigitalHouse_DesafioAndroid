package br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.restaurantlist.model.Restaurant

class RestaurantListAdapter(private val dataSet: List<Restaurant>, private val listener: (Restaurant) -> Unit):
    RecyclerView.Adapter<RestaurantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list_item, parent, false)

        return RestaurantViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}