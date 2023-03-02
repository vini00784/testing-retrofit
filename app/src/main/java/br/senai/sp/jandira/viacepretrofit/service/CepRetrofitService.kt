package br.senai.sp.jandira.viacepretrofit.service

import br.senai.sp.jandira.viacepretrofit.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepRetrofitService {
    // https://viacep.com.br/ws/06233030/json/
    @GET("{cep}/json/")
    fun getByCep(@Path("cep") cep: String): Call<Cep>

    // https://viacep.com.br/ws/SP/Jandira/silva/json/
    @GET("{uf}/{cidade}/{logradouro}/json/")
    fun getByCeps(
        @Path("uf") uf: String,
        @Path("cidade") cidade: String,
        @Path("logradouro") logradouro: String
    ): Call<List<Cep>>
}