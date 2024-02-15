package com.mevi.fakestore.core

import android.app.Activity
import androidx.fragment.app.Fragment
import com.mevi.fakestore.R
import com.mevi.fakestore.ui.MainActivity


class Utilities {

    fun loadFragment(activity: Activity, fragment: Fragment, tag: String) {
        (activity as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment, tag)
            .commit()
    }
}