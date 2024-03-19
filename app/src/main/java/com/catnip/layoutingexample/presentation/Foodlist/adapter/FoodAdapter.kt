package com.catnip.layoutingexample.presentation.foodlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.avengerslist.base.ViewHolderBinder
import com.catnip.layoutingexample.model.Food
import com.catnip.layoutingexample.databinding.ItemFoodBinding
import com.catnip.layoutingexample.databinding.ItemFoodGridBinding

class FoodAdapter(
    private val listener: OnItemClickedListener<Food>,
    private val listMode: Int = MODE_LIST
) :
    RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this, object : DiffUtil.ItemCallback<Food>() {
            override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
                //membandingkan apakah item tersebut sama
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
                // yang dibandingkan adalah kontennya
                return oldItem.hashCode() == newItem.hashCode()
            }

        }
    )

    fun submitData(data: List<Food>) {
        asyncDataDiffer.submitList(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //membuat instance of view holder
        return if (listMode == MODE_GRID) FoodGridItemViewHolder(
            ItemFoodGridBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listener
        ) else {
            FoodListItemViewHolder(
                ItemFoodBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ), listener
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<Food>).bind(asyncDataDiffer.currentList[position])
    }
}

interface OnItemClickedListener<T> {
    fun onItemClicked(item: T)
}

