package com.example.myapplication.model
import kotlinx.serialization.Serializable

@Serializable
data class BaseModel<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
