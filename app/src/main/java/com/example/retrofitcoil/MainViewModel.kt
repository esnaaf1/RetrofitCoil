package com.example.retrofitcoil

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope


import kotlinx.coroutines.launch
import com.example.retrofitcoil.network.Api
import retrofit2.HttpException
import java.io.IOException

class MainViewModel: ViewModel() {
    var uiState1: String by mutableStateOf("")
    var uiState2: String by mutableStateOf("")
    var uiState3: String by mutableStateOf("")
    var uiState4: String by mutableStateOf("")
    var uiState5: String by mutableStateOf("")
        private set

    init {
        getPhotos()
    }

   fun getPhotos() {

        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getPhotos()

                if (listResult.isNotEmpty()) {

                    uiState1 = listResult[0].url
                    uiState2 = listResult[1].url
                    uiState3 = listResult[2].url
                    uiState4 = listResult[3].url
                    uiState5 = listResult[4].url
                }
// for debugging purposes
//                Log.d("API CALL RESULT: ", "$uiState1")
//                Log.d("API CALL RESULT: ", "$uiState2")
//                Log.d("API CALL RESULT: ", "$uiState3")
//                Log.d("API CALL RESULT: ", "$uiState4")
//                Log.d("API CALL RESULT: ", "$uiState5")
            } catch (e: IOException) {
                Log.d("API CALL RESULT: ", "IO ERROR")
            } catch(e: HttpException) {
                Log.d("API CALL RESULT: ","Server timeout or exceeding the request limit")
            }

        }
    }
}
