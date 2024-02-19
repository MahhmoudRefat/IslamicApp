package com.example.islamicapp.api.sourcesResponse

import com.google.gson.annotations.SerializedName

data class radiochannel(
    @SerializedName("radios")
    val radios: List<Radio>
)