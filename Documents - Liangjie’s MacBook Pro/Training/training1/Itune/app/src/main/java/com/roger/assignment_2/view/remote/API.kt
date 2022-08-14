package com.roger.assignment_2.view.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    val songApi: Service by lazy{
        initRetrofit()
    }

    private fun initRetrofit(): Service{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }
}