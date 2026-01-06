package com.example.coccoc.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") var title: String? = null,
    @SerializedName("authors") var authors: ArrayList<Authors> = arrayListOf(),
    @SerializedName("url") var url: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("news_site") var newsSite: String? = null,
    @SerializedName("summary") var summary: String? = null,
    @SerializedName("published_at") var publishedAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("featured") var featured: Boolean? = null,
    @SerializedName("launches") var launches: ArrayList<String> = arrayListOf(),
    @SerializedName("events") var events: ArrayList<String> = arrayListOf()

)

data class Authors(

    @SerializedName("name") var name: String? = null,
    @SerializedName("socials") var socials: String? = null

)
