package com.example.mealdbapi.ui.ingredients.ingredientsDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealdbapi.data.model.ingredientsDetails.IngredientsDetailsModel
import com.example.mealdbapi.databinding.FragmentIngredientsDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IngredientsDetailsFragment : Fragment() {


    private  val viewModel by viewModels<IngredientsDetailsViewModel>()
    private var _binding: FragmentIngredientsDetailsBinding? = null
    var input : String = ""

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIngredientsDetailsBinding.inflate(inflater, container, false)

        input = this.arguments?.get("IngredientName").toString()


        viewModel.getIngredientsDetails(input)

        viewModel.ingredientsDetails.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        return binding.root
    }

    private fun setupUI(ingredientsDetails: IngredientsDetailsModel?) {

        val ingredeintsDetailsAdapter = IngredientsDetailsAdapter(ingredientsDetails?.meals)


        binding.rvIngredientsDetails.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ingredeintsDetailsAdapter
        }

    }


}