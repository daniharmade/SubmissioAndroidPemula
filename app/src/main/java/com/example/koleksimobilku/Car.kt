package com.example.koleksimobilku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val name: String,
    val description: String,
    val photo: Int,
    val price: String,
    val fuel: String,
    val capacity: String,
    val yearscondition: String
) : Parcelable
