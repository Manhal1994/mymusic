package com.example.mymusic.ui.presentation.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymusic.domain.use_case.GetChart
import com.example.mymusic.ui.presentation.util.PaletteUtils.getDominantGradient
import com.example.mymusic.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import okio.IOException
import java.net.URL
import javax.inject.Inject


/**
 * Created by ManhalKhwashki on 3/16/2024.
 */

@HiltViewModel
class HomeActivityViewModel @Inject constructor(val GetChart: GetChart) : ViewModel() {

    private var _state = mutableStateOf<HomeActivityState>(HomeActivityState())
    val state: State<HomeActivityState> = _state

    private var _trackDetailBgState = mutableStateOf<Bitmap?>(null)
     val trackDetailBgState: State<Bitmap?> = _trackDetailBgState

    private var _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        onEvent(HomeActivityEvent.GetChart)
    }

   private fun onEvent(event: HomeActivityEvent) {
        when (event) {
            is HomeActivityEvent.GetChart -> getChart()
        }
    }

   private fun getChart() {
        viewModelScope.launch {
            GetChart().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            chart = result.data!!
                        )
                        result.message?.let {
                            _eventFlow.emit(UiEvent.ShowSnackbar(message = it))

                        }

                    }
                    is Resource.Loading-> {
                        _state.value = _state.value.copy(
                            isLoading = result .isLoading,
                        )
                    }
                    is Resource.Error-> {
                        _state.value = _state.value.copy(
                            isLoading = false,
                        )
                        result.message?.let {
                            _eventFlow.emit(UiEvent.ShowSnackbar(message = it))

                        }
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
    }

    fun decodeUrlImage(width : Int, height: Int){
        viewModelScope.launch(Dispatchers.IO) {
        try {
            val url =
                URL("https://e-cdns-images.dzcdn.net/images/artist/c1eaf89e540f70dc017b206e70ac60c8/500x500-000000-80-0-0.jpg")
            val imageBitmap: Bitmap =
                BitmapFactory.decodeStream(url.openConnection().getInputStream())


            val backgroundDominantColorBitmap = getDominantGradient(imageBitmap, height, width)
            _trackDetailBgState.value = backgroundDominantColorBitmap
        }
        catch ( e: IOException){

            e.printStackTrace();

        }
        }

    }


}