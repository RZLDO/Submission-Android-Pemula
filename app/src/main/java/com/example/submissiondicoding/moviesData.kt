package com.example.submissiondicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class moviesData(
    val name:String,
    val desc:String,
    val imageData: String,
    val detail: String
) : Parcelable