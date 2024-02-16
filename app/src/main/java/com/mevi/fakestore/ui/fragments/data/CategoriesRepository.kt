package com.mevi.fakestore.ui.fragments.data

import com.mevi.fakestore.core.ApiResponceStatus
import com.mevi.fakestore.core.RetrofitConnection
import com.mevi.fakestore.core.makeNetworkCall

class CategoriesRepository {

    val autservice = RetrofitConnection().getRetrofit()

    suspend fun search(
    ): ApiResponceStatus<List<String>> {
        return makeNetworkCall {
            val response = autservice.create(CategoriesApieClient::class.java)
                .categories()
            //evaluateResponce(response.codigo.toString())
            response
        }
    }
    suspend fun products(category: String): ApiResponceStatus<List<ProductsResponse>> {
        return makeNetworkCall {
            val response = autservice.create(CategoriesApieClient::class.java)
                .products(category)
            //evaluateResponce(response.codigo.toString())
            response
        }
    }
}