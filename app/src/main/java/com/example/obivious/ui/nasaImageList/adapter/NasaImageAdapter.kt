package com.example.obivious.ui.nasaImageList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.obivious.BR
import com.example.obivious.databinding.ItemNasaImageBinding
import com.example.obivious.ui.nasaImageList.data.NasaImage

class NasaImageAdapter(private val callback: (nasaImage: NasaImage) -> Unit) :
    RecyclerView.Adapter<NasaImageAdapter.NasaImageViewHolder>() {
    private val nasaImages = mutableListOf<NasaImage>()

    inner class NasaImageViewHolder(private val binding: ItemNasaImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            with(binding) {
                setVariable(BR.nasaImage, nasaImages[adapterPosition])
                executePendingBindings()
                root.setOnClickListener {
                    callback.invoke(nasaImages[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImageViewHolder =
        NasaImageViewHolder(
            ItemNasaImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: NasaImageViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = nasaImages.size

    fun updateImages(newData: List<NasaImage>) {
        val startIndex = nasaImages.size
        nasaImages.addAll(newData)
        notifyItemRangeInserted(startIndex, nasaImages.size)
    }
}