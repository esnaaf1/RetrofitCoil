package com.example.retrofitcoil

import android.net.http.HttpException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope


import kotlinx.coroutines.launch
import com.example.retrofitcoil.network.Api
import java.io.IOException
import java.util.ListResourceBundle


//sealed interface NasaUiSate {
//    data class Success(val photos: String) : NasaUiSate
//    object Error : NasaUiSate
//    object Loading : NasaUiSate
//}

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

    private fun getPhotos() {

        viewModelScope.launch {
            try {
                val listResult = Api.retrofitService.getPhotos()

                if (listResult.isNotEmpty()) {

                    uiState1 = listResult[0].img_src
                    uiState2 = listResult[1].img_src
                    uiState3 = listResult[2].img_src
                    uiState4 = listResult[3].img_src
                    uiState5 = listResult[4].img_src
                }

                Log.d("API CALL RESULT: ", "$uiState1")
                Log.d("API CALL RESULT: ", "$uiState2")
                Log.d("API CALL RESULT: ", "$uiState3")
                Log.d("API CALL RESULT: ", "$uiState4")
                Log.d("API CALL RESULT: ", "$uiState5")
            } catch (e: IOException) {
                Log.d("API CALL RESULT: ", "IO ERROR")
            }

        }
    }
}
