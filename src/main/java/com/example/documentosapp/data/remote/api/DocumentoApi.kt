package com.example.documentosapp.data.remote.api

import com.example.documentosapp.data.remote.dto.DocumentoDto
import retrofit2.http.GET

interface DocumentoApi {

    @GET("documentos")
    suspend fun getDocumento():List<DocumentoDto>

}