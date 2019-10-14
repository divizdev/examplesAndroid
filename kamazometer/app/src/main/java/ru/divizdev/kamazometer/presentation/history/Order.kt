package ru.divizdev.kamazometer.presentation.history

data class Order(
        val orderId: String,
        val status:String,
        val date: String,
        val from: String,
        val to: String,
        val sum: String = "15 000 \u20BD"
)