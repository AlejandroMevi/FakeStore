package com.mevi.fakestore.ui

import com.mevi.fakestore.core.ApiResponceStatus
import com.mevi.fakestore.core.RetrofitConnection
import com.mevi.fakestore.core.makeNetworkCall

class CategoriesRepository {

    val autservice = RetrofitConnection().getRetrofit()

    suspend fun search(
    ): ApiResponceStatus<List<String>> {
        return makeNetworkCall {
            val response = autservice.create(CategoriesApieClient::class.java)
                .searchBooks()
            //evaluateResponce(response.codigo.toString())
            response
        }
    }
}