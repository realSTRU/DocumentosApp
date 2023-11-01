package com.example.documentosapp.ui.documento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.documentosapp.data.remote.dto.DocumentoDto
import com.example.documentosapp.data.repository.DocumentoRepository
import com.example.documentosapp.util.Resource
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class DocumentoListState(
    val isLoading: Boolean = false,
    val documentos: List<DocumentoDto> = emptyList(),
    val error: String = ""
)

@HiltViewModel
class DocumentosViewModel @Inject constructor(
    private val documentoRepository: DocumentoRepository
): ViewModel(){
    private val _uiState = MutableStateFlow(DocumentoListState())
    val uiState : StateFlow<DocumentoListState> = _uiState.asStateFlow()

    init {
        documentoRepository.getDocumento().onEach { result ->
            when(result)
            {
                is Resource.Loading -> {
                    _uiState.update {it.copy(isLoading = true)}
                }
                is Resource.Success -> {
                    _uiState.update { it.copy(documentos = result.data?: emptyList()) }
                }
                is Resource.Error -> {
                    _uiState.update { it.copy(error=result.message?:"Anonymous Error.") }
                }
            }

        }.launchIn(viewModelScope)
    }
}