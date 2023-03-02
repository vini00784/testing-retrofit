package br.senai.sp.jandira.viacepretrofit.model

import com.google.gson.annotations.SerializedName

data class Cep(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    @SerializedName("localidade") val cidade: String, // Essa anotação avisa para o GSON que no Json original o nome é localidade, mas o meu atributo do obj se chama cidade.
    @SerializedName("uf") val estado: String
)
