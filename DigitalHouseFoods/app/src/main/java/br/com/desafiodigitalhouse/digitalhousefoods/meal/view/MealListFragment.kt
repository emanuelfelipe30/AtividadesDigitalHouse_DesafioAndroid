package br.com.desafiodigitalhouse.digitalhousefoods.meal.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.meal.model.Meal
import br.com.desafiodigitalhouse.digitalhousefoods.meal.repository.MealRepository
import br.com.desafiodigitalhouse.digitalhousefoods.meal.viewmodel.MealListViewModel

class MealListFragment : Fragment() {

    private lateinit var myView: View
    private lateinit var viewModel: MealListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView =  inflater.inflate(R.layout.fragment_meal_list, container, false)

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            MealListViewModel.MealListViewModelFactory(MealRepository())
        ).get(MealListViewModel::class.java)

        viewModel.mealListData.observe(viewLifecycleOwner, Observer{
            createList(it)
        })

        viewModel.getMeals()

    }

    private fun createList(mealList: List<Meal>) {
        val recyclerView = myView.findViewById<RecyclerView>(R.id.mealList)
        val manager = GridLayoutManager(myView.context, 2)

        val mealListAdapter = MealListListAdapter(mealList) {
            val intent = Intent(myView.context, MealDetailsActivity::class.java)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
            adapter = mealListAdapter
        }
    }

}