package com.example.documentosapp.data.repository

import com.example.documentosapp.data.remote.api.DocumentoApi
import com.example.documentosapp.data.remote.dto.DocumentoDto
import com.example.documentosapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException


class DocumentoRepository @Inject constructor(private val api: DocumentoApi) {
    fun getDocumento(): Flow<Resource<List<DocumentoDto>>> = flow{
        try{
            emit(Resource.Loading())

            val documentos = api.getDocumento()

            emit(Resource.Success(documentos))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "Error HTTP"))

        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verificar conexion"))
        }
    }
}