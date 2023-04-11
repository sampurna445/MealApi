package com.example.mealdbapi.ui.areas

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
import com.example.mealdbapi.data.model.areas.MealAreasModel
import com.example.mealdbapi.databinding.FragmentAreasBinding
import com.example.mealdbapi.ui.mealcategories.MealcategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AreasFragment : Fragment() {

    private var _binding: FragmentAreasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<AreasViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentAreasBinding.inflate(inflater, container, false)

        viewModel.areas.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getMealAreas()
        return binding.root
    }

    private fun setupUI(mealAreas: MealAreasModel?) {
        val mealAreasAdapter = MealAreasAdapter(mealAreas?.meals)


        binding.rvAreas.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mealAreasAdapter

        }
        mealAreasAdapter.onItemClick = {

            val bundle = Bundle().apply {
                var itemAreaName = it.strArea.toString()
                //putSerializable("MealAreaItem", it)
                putString("AreaName",itemAreaName)
            }

            findNavController().navigate(R.id.action_navigation_areas_to_areasDetailsFragment, bundle)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}