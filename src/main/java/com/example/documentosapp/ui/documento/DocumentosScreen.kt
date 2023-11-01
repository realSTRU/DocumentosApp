package com.example.documentosapp.ui.documento

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.documentosapp.data.remote.dto.DocumentoDto

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DocumentosScreen (documentos : List<DocumentoDto>){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Historial", color = Color.White) },
            )
        },
        content ={
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(top = 70.dp)
                ) {
                    Text(
                        "Numero",
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        "Nombre",
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        "RNC",
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        "Total",
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                )
                {
                    items(documentos) { documento ->
                        Surface(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            color = Color.DarkGray,
                            shadowElevation = 3.dp,
                            shape = RoundedCornerShape(8.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                RowItem(documento = documento)
                            }

                        }

                    }
                }
            }

        }
    )

}

@Composable
fun RowItem (documento : DocumentoDto)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(documento.numero.toString(), modifier = Modifier.weight(1f).padding(start = 4.dp),style = MaterialTheme.typography.bodySmall)
        Text(documento.nombreCliente, modifier = Modifier.weight(1f),style = MaterialTheme.typography.bodySmall)
        Text(documento.rnc, modifier = Modifier.weight(1.3f).padding(start = 15.dp , end = 6.dp),style = MaterialTheme.typography.labelSmall)
        Text(documento.total.toString(), modifier = Modifier.weight(1f).padding(start = 20.dp),style = MaterialTheme.typography.bodySmall)
    }
}