package com.example.documentosapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class DocumentoDto (
    @Json(name = "Numero")
    val numero : Int?,
    @Json(name = "Rnc")
    val rnc : String,
    @Json(name = "NombreCliente")
    val nombreCliente : String,
    @Json(name = "Monto")
    val total : Int,
)


