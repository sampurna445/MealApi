package com.example.mealdbapi.ui.mealcategories

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
import com.example.mealdbapi.data.model.mealcategories.MealcategoriesModel

import com.example.mealdbapi.databinding.FragmentMealcategoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealcategoriesFragment : Fragment() {

    private var _binding: FragmentMealcategoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<MealcategoriesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMealcategoriesBinding.inflate(inflater, container, false)


        viewModel.mealcategories.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getMealcategories()
        return binding.root
    }

    private fun setupUI(mealcategories: MealcategoriesModel?) {
        val mealcategoriesAdapter = MealcategoriesAdapter(mealcategories?.meals)


        binding.rvMealcategoreis.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mealcategoriesAdapter
        }
        mealcategoriesAdapter.onItemClick = {

            val bundle = Bundle().apply {
                var itemMealCategory = it.strCategory.toString()
               // putSerializable("MealCategoryItem", it.strCategory.toString())
                putString("MealCategory",itemMealCategory)
            }

            findNavController().navigate(R.id.action_navigation_mealcategories_to_mealcategoriesDetails, bundle)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}