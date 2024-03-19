package com.catnip.layoutingexample.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.catnip.layoutingexample.R
import com.catnip.layoutingexample.presentation.foodlist.adapter.CategoryAdapter
import com.catnip.layoutingexample.databinding.FragmentHomeBinding
import com.example.layoutexaple.model.Category
import com.catnip.layoutingexample.presentation.foodlist.adapter.FoodAdapter
import com.catnip.layoutingexample.presentation.foodlist.adapter.OnItemClickedListener
import com.catnip.layoutingexample.model.Food
import com.catnip.layoutingexample.data.datasource.FoodDataSource
import com.catnip.layoutingexample.data.datasource.FoodDataSourceImpl
import androidx.recyclerview.widget.GridLayoutManager
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.catnip.layoutingexample.presentation.fooddetail.FoodDetailFragment


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var adapter: FoodAdapter? = null
    private val dataSource: FoodDataSource by lazy { FoodDataSourceImpl() }
    private var isUsingGridMode: Boolean = false
    private val categoryAdapter = CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAction()
        setListCategory()
        setButtonText(isUsingGridMode)
        bindFoodList(isUsingGridMode)
        setClickAction()
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonText(isUsingGridMode)
            bindFoodList(isUsingGridMode)
        }

    }
    private fun navigateToDetail(item: Food) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(FoodDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_navigation_home_to_detailActivity, bundle)
    }

    private fun setButtonText(usingGridMode: Boolean) {
        val drawableResId = if (usingGridMode) R.drawable.ic_vertikal else R.drawable.ic_horizontal
        val drawable = ContextCompat.getDrawable(requireContext(), drawableResId)
        binding.btnChangeListMode.setImageDrawable(drawable)
    }

    private fun bindFoodList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) FoodAdapter.MODE_GRID else FoodAdapter.MODE_LIST
        adapter = FoodAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Food> {
                override fun onItemClicked(item: Food) {
                    //navigate to detail
                    navigateToDetail(item)
                }
            })
        binding.rvAvengerList.apply {
            adapter = this@HomeFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getFoodMenu())
    }



    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.ic_all, name = "All"),
            Category(image = R.drawable.ic_chicken, name = "Chicken"),
            Category(image = R.drawable.ic_pizza, name = "Pizza"),
            Category(image = R.drawable.ic_burger, name = "Burger"),
            Category(image = R.drawable.ic_mie, name = "Mie"),
        )
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Hai Rohit", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = requireContext().getString(R.string.name)

    }


}
