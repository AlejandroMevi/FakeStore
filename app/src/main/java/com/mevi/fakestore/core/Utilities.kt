package com.mevi.fakestore.core

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mevi.fakestore.R
import com.mevi.fakestore.ui.MainActivity
import com.mevi.fakestore.ui.ProductsResponse


class Utilities {

    fun loadFragment(activity: Activity, fragment: Fragment, tag: String) {
        (activity as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag)
            .commit()
    }

    fun loadFragmentBundel(activity: Activity, fragment: Fragment, tag: String, bundle: Bundle) {
        fragment.arguments = bundle
        (activity as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    fun showBottomSheetDialog(
        item: ProductsResponse,
        requireActivity: FragmentActivity,
        requireContext: Context
    ) {
        val bottomSheetDialog = BottomSheetDialog(requireContext)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_description)
        val descriptiontxt = bottomSheetDialog.findViewById<TextView>(R.id.description_product )
        val imageView = bottomSheetDialog.findViewById<ImageView>(R.id.imageProduct)
        val titletxt = bottomSheetDialog.findViewById<TextView>(R.id.title_product)
        val pricetxt = bottomSheetDialog.findViewById<TextView>(R.id.price_product)
        val categorytxt = bottomSheetDialog.findViewById<TextView>(R.id.category)
        val rating = bottomSheetDialog.findViewById<AppCompatRatingBar>(R.id.rating)

        if (descriptiontxt != null) {
            descriptiontxt.text = item.description
        }
        if (titletxt != null) {
            titletxt.text = item.title
        }
        if (pricetxt != null) {
            pricetxt.text = "$ ${item.price}"
        }
        if (categorytxt != null) {
            categorytxt.text = item.category
        }
        if (rating != null) {
            rating.rating = item.rating?.rate?.toFloat() ?: 0.00f
        }
        if (imageView != null) {
            Glide.with(requireContext)
                .load(item.image?.replace("http://", "https://"))
                .placeholder(R.drawable.ic_generico)
                .error(R.drawable.ic_generico)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }


        bottomSheetDialog.show()
    }

}