package br.com.desafiodigitalhouse.digitalhousefoods.meal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import com.squareup.picasso.Picasso

class MealDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_meal_details, container, false)

        val imgMealDetails = myView.findViewById<ImageView>(R.id.imgMealDetails)
        val txtMealNameDetails = myView.findViewById<TextView>(R.id.txtMealNameDetails)
        val txtMealDescription = myView.findViewById<TextView>(R.id.txtMealDescription)
        val btnBackToRestaurantDetails = myView.findViewById<Button>(R.id.btnBackToRestaurantDetails)

        Picasso.get()
            .load("https://i.pinimg.com/originals/a7/a6/74/a7a6747da45f879ba4757bac8af599c6.jpg")
            .into(imgMealDetails)

        txtMealNameDetails.text = myView.context.getString(R.string.meal_name)
        txtMealDescription.text = myView.context.getString(R.string.meal_description)
        btnBackToRestaurantDetails.setOnClickListener {
            activity?.finish()
        }

        return myView
    }

}