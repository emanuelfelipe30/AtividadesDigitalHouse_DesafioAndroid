package br.com.desafiodigitalhouse.digitalhousefoods.meal.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.meal.model.Meal
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.model.Restaurant
import com.squareup.picasso.Picasso

class MealViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val imgMeal = view.findViewById<ImageView>(R.id.imgMeal)
    private val txtMealName = view.findViewById<TextView>(R.id.txtMealName)

    fun bind(meal: Meal) {

        Picasso.get()
            .load(meal.urlImage)
            .into(imgMeal)

        txtMealName.text = meal.name

    }

}