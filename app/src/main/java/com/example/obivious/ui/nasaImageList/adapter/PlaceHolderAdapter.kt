package com.example.obivious.ui.nasaImageList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.obivious.R

class PlaceHolderAdapter: RecyclerView.Adapter<PlaceHolderAdapter.PlaceHolderViewHolder>() {
    inner class PlaceHolderViewHolder(private val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolderViewHolder {
        return PlaceHolderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_place_holder, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlaceHolderViewHolder, position: Int) {
    }

    // Only display single item
    override fun getItemCount(): Int = 1
}