package com.example.obivious.ui.nasaDetail

import androidx.lifecycle.ViewModel
import com.example.obivious.BR
import com.example.obivious.R
import com.example.obivious.base.BaseFragment
import com.example.obivious.databinding.FragmentDetailBinding
import com.example.obivious.ui.nasaImageList.data.NasaImage

class NasaDetailFragment : BaseFragment<FragmentDetailBinding>() {
    companion object {
        const val NASA_DATA_EXTRA = "nasa_data_extra"
    }

    override fun getViewModel(): ViewModel? = null

    override fun getLayoutId(): Int = R.layout.fragment_detail

    override fun bindData() {
        arguments?.let {
            val data = it.getParcelable<NasaImage>(NASA_DATA_EXTRA)
            data.let { nasaImage ->
                viewBinder.setVariable(BR.nasaImage, nasaImage)
                viewBinder.executePendingBindings()
            }
        }
    }
}