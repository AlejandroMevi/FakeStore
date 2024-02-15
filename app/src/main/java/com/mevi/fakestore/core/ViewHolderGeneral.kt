package com.mevi.fakestore.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolderGeneral<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}