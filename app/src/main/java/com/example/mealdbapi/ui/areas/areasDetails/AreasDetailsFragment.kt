package com.example.mealdbapi.ui.areas.areasDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealdbapi.R
import com.example.mealdbapi.data.model.areasDetail.AreasDetailsModel
import com.example.mealdbapi.data.model.mealcategoriesDetails.MealcategoryDetailModel
import com.example.mealdbapi.databinding.FragmentAreasDetailsBinding
import com.example.mealdbapi.databinding.FragmentMealcategoriesDetailsBinding
import com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails.MealcategoriesDetailsAdapter
import com.example.mealdbapi.ui.mealcategories.mealcategoriesDetails.MealcategoriesDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AreasDetailsFragment : Fragment() {

    private  val viewModel by viewModels<AreasDetailsViewModel>()
    private var _binding: FragmentAreasDetailsBinding? = null
    var input : String = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAreasDetailsBinding.inflate(inflater, container, false)

        input = this.arguments?.get("AreaName").toString()


        viewModel.getAreasDetails(input)

        viewModel.areasDetails.observe(viewLifecycleOwner) {
            setupUI(it)
        }




        return binding.root
    }

    private fun setupUI(areasDetails: AreasDetailsModel?) {

        val areasDetailsAdapter = AreasDetailsAdapter(areasDetails?.meals)


        binding.rvAreasDetails.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = areasDetailsAdapter
        }

    }


}