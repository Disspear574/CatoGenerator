package cats.presentation

import android.net.http.HttpException
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cats.domain.usecase.GenerateNewCatUseCase
import cats.domain.usecase.GetCatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(
    private val getCatUseCase: GetCatUseCase,
    private val generateNewCatUseCase: GenerateNewCatUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CatsState())
    val state: StateFlow<CatsState> = _state

    init {
        getCats()
    }

    private fun getCats() {
        viewModelScope.launch {

            try {
                val result = getCatUseCase.execute()
                if (result.image.isNotEmpty()) {
                    _state.update { it.copy(cat = result) }
                }
            } catch (e: Exception) {
                val error = e.localizedMessage
                _state.update {
                    it.copy(error = "Exception : $error, \n Проверьте подключение к интернету")
                }
            }

        }
    }

    fun generateNewCat() {
        viewModelScope.launch {
            try {
                generateNewCatUseCase.execute()
                getCats()
            } catch (_: Exception) {}


        }
    }
}