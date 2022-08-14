package com.roger.assignment_2.view.remote


import com.roger.assignment_2.view.model.SongDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(ROCK)
    fun rockDetails() : Call<SongDetail>

    @GET(CLASSIC)
    fun classicDetails() : Call<SongDetail>

    @GET(POP)
    fun popDetails() : Call<SongDetail>
}
