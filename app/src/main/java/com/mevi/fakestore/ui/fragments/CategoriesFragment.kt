package com.mevi.fakestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.card.MaterialCardView
import com.mevi.fakestore.core.Constants
import com.mevi.fakestore.core.Utilities
import com.mevi.fakestore.databinding.FragmentCategoriesBinding
import com.mevi.fakestore.ui.fragments.vm.CategoriesViewModel


class CategoriesFragment : Fragment(), ListCategoriesdapter.OnClickListener {

    private lateinit var binding: FragmentCategoriesBinding
    private val vm: CategoriesViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoriesService()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        addObservers()
        return binding.root
    }

    private fun categoriesService() {
        vm.data.value = null
        vm.getListCategories()
    }

    private fun addObservers() {
        vm.data.observe(viewLifecycleOwner) { response ->
            if (response != null) {
                setDataKardex(response as ArrayList<String>)
            }

        }
    }


    private fun setDataKardex(listCategories: ArrayList<String>) {
        binding.listCategories.adapter = ListCategoriesdapter(listCategories, this)
    }

    override fun onClick(item: String, position: Int, cardviewlista: MaterialCardView) {
        val bundle = Bundle()
        bundle.putString(Constants.ITEM, item)
        Utilities().loadFragmentBundel(requireActivity(), ProductsFragment(), "WebView", bundle)
     }
}