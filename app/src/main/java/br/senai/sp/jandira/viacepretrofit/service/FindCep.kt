package br.senai.sp.jandira.viacepretrofit.service

import br.senai.sp.jandira.viacepretrofit.model.Cep
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun findCep(cep: String, onComplete: (String, Int) -> Unit) {
    var logradouro = ""

    val call = RetrofitFactory()
        .retrofitService()
        .getByCep(cep)

    call.enqueue(object: Callback<Cep> {
        override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
            logradouro = response.body()!!.logradouro ?: "CEP não encontrado"
            onComplete.invoke(logradouro, 100)
        }

        override fun onFailure(call: Call<Cep>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}