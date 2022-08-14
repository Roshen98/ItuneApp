package com.roger.assignment_2.view.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roger.assignment_2.view.model.SongDetail
import com.roger.assignment_2.view.model.SongItem
import com.roger.assignment_2.view.remote.API
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

private const val TAG = "SongViewModel"

class SongViewModel: ViewModel() {

    private var _resultCount: Int = 0

    private val _songDetail = MutableLiveData<List<SongItem>>()

    private val _errorMessages = MutableLiveData("")

    val errorMessages: LiveData<String>
        get() = _errorMessages

    val songDetail: LiveData<List<SongItem>>
        get() = _songDetail

    var resultCount: Int
     get() = _resultCount
     set(value) { _resultCount = value}

    fun detailsRock(){
        API.songApi.rockDetails()
            .enqueue(
                object: Callback<SongDetail> {
                    override fun onResponse(
                        call: Call<SongDetail>,
                        response: Response<SongDetail>
                    ) {
                        if(response.isSuccessful){
                            response.body()?.let {
                                _resultCount = it.resultCount
                                _songDetail.value = it.results
                                Log.d(TAG, "onResponse: ${it.results}")

                            } ?: kotlin.run { _errorMessages.value = response.message()
                            }
                        }
                        else{
                            _errorMessages.value = response.message()
                        }
                    }

                    override fun onFailure(call: Call<SongDetail>, t: Throwable) {
                        t.printStackTrace()
                        _errorMessages.value = t.message ?: "Unknown error"
                    }
                }
            )
    }

    fun detailsClassic(){
        API.songApi.classicDetails()
            .enqueue(
                object: Callback<SongDetail> {
                    override fun onResponse(
                        call: Call<SongDetail>,
                        response: Response<SongDetail>
                    ) {
                        if(response.isSuccessful){
                            response.body()?.let {
                                _resultCount = it.resultCount
                                _songDetail.value = it.results
                            } ?: kotlin.run { _errorMessages.value = response.message()
                            }
                        }
                        else{
                            _errorMessages.value = response.message()
                        }
                    }

                    override fun onFailure(call: Call<SongDetail>, t: Throwable) {
                        t.printStackTrace()
                        _errorMessages.value = t.message ?: "Unknown error"
                    }
                }
            )
    }

    fun detailsPop(){
        API.songApi.popDetails()
            .enqueue(
                object: Callback<SongDetail> {
                    override fun onResponse(
                        call: Call<SongDetail>,
                        response: Response<SongDetail>
                    ) {
                        if(response.isSuccessful){
                            response.body()?.let {
                                _resultCount = it.resultCount

                                _songDetail.value = it.results
                            } ?: kotlin.run { _errorMessages.value = response.message()
                            }
                        }
                        else{
                            _errorMessages.value = response.message()
                        }
                    }

                    override fun onFailure(call: Call<SongDetail>, t: Throwable) {
                        t.printStackTrace()
                        _errorMessages.value = t.message ?: "Unknown error"
                    }
                }
            )
    }
}