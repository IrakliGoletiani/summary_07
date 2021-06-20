package com.example.summmary7

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.summmary7.data.network.RetrofitService.api
import com.example.summmary7.data.network.models.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val _data = MutableLiveData<ResultModel>()
    val data: LiveData<ResultModel> = _data

    fun getData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val response = api.getData()

                if(response.isSuccessful){
                    _data.postValue(response.body())
                } else {
                    Log.d("mainlog", "error occurred: ${response.errorBody()}")
                }
            }
        }
    }
}