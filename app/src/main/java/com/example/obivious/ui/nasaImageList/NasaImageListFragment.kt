package com.example.obivious.ui.nasaImageList

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.obivious.R
import com.example.obivious.base.BaseFragment
import com.example.obivious.databinding.FragmentNasaImageListBinding
import com.example.obivious.ui.nasaImageList.adapter.NasaImageAdapter
import com.example.obivious.ui.nasaImageList.adapter.PlaceHolderAdapter
import com.example.obivious.ui.nasaDetail.NasaDetailFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NasaImageListFragment : BaseFragment<FragmentNasaImageListBinding>() {
    private val viewModel: NasaImageListViewModel by viewModel()

    private val adapter = ConcatAdapter()
    private val titleAdapter = PlaceHolderAdapter()
    private val imagesAdapter = NasaImageAdapter {
        val bundle = Bundle()
        bundle.putParcelable(NasaDetailFragment.NASA_DATA_EXTRA, it)
        findNavController().navigate(R.id.action_nasaImageListFragment_to_nasaDetailFragment, bundle)
    }

    override fun getViewModel(): ViewModel = viewModel

    override fun getLayoutId(): Int = R.layout.fragment_nasa_image_list

    override fun bindData() {
        viewBinder.rvCharacters.adapter = adapter
        adapter.addAdapter(titleAdapter)
        adapter.addAdapter(imagesAdapter)
        viewModel.list.observe(viewLifecycleOwner) {
            imagesAdapter.updateImages(it)
        }
        viewModel.getList()
    }
}