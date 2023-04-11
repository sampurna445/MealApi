package com.example.mealdbapi.ui.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.ingredients.MealIngredientsModel
import com.example.mealdbapi.databinding.FragmentIngredientsBinding
import com.example.mealdbapi.ui.areas.MealAreasAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<IngredientsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)

        viewModel.ingredients.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getMealIngredients()
        return binding.root
    }

    private fun setupUI(mealIngredients: MealIngredientsModel?) {
        val mealIngredientsAdapter = MealIngredientsAdapter(mealIngredients?.meals)


        binding.rvIngredients.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mealIngredientsAdapter

        }
        mealIngredientsAdapter.onItemClick = {

            val bundle = Bundle().apply {
                var itemIngredientName = it.strIngredient.toString()
               // putSerializable("MealAreaItem", it)
                putString("IngredientName",itemIngredientName)
            }

            findNavController().navigate(R.id.action_navigation_ingredients_to_ingredientsDetailsFragment, bundle)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}