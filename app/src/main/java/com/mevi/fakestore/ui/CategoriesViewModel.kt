package com.mevi.fakestore.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mevi.fakestore.core.ApiResponceStatus
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {

    private val repository = CategoriesRepository()

    var status = MutableLiveData<ApiResponceStatus<Any>?>(null)
        private set

    var data = MutableLiveData<List<String>?>(null)
        private set

    fun getListCategories() {
        viewModelScope.launch {
            status.value = ApiResponceStatus.Loading()
            val responce = repository.search()
            if (responce is ApiResponceStatus.Success) {
                data.value = responce.data
            }
            status.value = responce as ApiResponceStatus<Any>
        }
    }
}