package br.senai.sp.jandira.viacepretrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.viacepretrofit.model.Cep
import br.senai.sp.jandira.viacepretrofit.service.CepRetrofitService
import br.senai.sp.jandira.viacepretrofit.service.RetrofitFactory
import br.senai.sp.jandira.viacepretrofit.service.findCep
import br.senai.sp.jandira.viacepretrofit.ui.theme.ViaCepRetrofitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViaCepRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var cepState by remember {
        mutableStateOf("")
    }

    var resultState by remember {
        mutableStateOf("Resultado aqui...")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = cepState,
            onValueChange = {
                cepState = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Digite o CEP")
            }
        )

        Button(
            onClick = {
                findCep(cepState) { result, x ->
                    resultState = result
                    Log.i("ds3m", x.toString())
                }.toString()
            }
        ) {
            Text(text = "Buscar")
        }

        Text(
            text = resultState
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ViaCepRetrofitTheme {
        Greeting("Android")
    }
}