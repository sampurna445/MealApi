package com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.mealcategories.MealModel
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import com.example.mealdbapi.databinding.FragmentMealcategoriesBinding

import com.example.mealdbapi.databinding.FragmentMealcategoriesDetailsBinding
import com.example.mealdbapi.ui.mealcategories.MealcategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealcategoriesDetails : Fragment() {


    private  val viewModel by viewModels<MealcategoriesDetailsViewModel>()
    private var _binding: FragmentMealcategoriesDetailsBinding? = null
var input : String = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealcategoriesDetailsBinding.inflate(inflater, container, false)

        input = this.arguments?.get("MealCategory").toString()
     //   var mealcategoriesDetails = arguments?.getSerializable("MealCategoryItem") as MealModel

        viewModel.getMealcategoriesDetails(input)

        viewModel.mealcategoriesDetails.observe(viewLifecycleOwner) {
            setupUI(it)
        }




        return binding.root
    }

    private fun setupUI(mealcategoriesDetails: MealcategoryDetailModel?) {
            //binding.testing.text = mealcategoriesDetails?.meals?.size.toString()
      //  binding.testing.text = mealcategoriesDetails?.meals?.component1()?.strMeal.toString()


        val mealcategoriesDetailsAdapter = MealcategoriesDetailsAdapter(mealcategoriesDetails?.meals)


        binding.rvMealCategoriesDetails.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mealcategoriesDetailsAdapter
        }

    }


}