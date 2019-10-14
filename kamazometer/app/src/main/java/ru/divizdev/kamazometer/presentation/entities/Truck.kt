package ru.divizdev.kamazometer.presentation.entities

data class Truck(
        val brand: String,
        val number: String,
        val tonnage: String,
        val status: String,
        val type: String,
        val loadType: String
)

fun getTrucks(): List<Truck> {
    val result = mutableListOf<Truck>(
            Truck("Volvo FH", "B345KK777", "20 тн", "Авторизовано", "Борт", "Боковая"),
            Truck("Man TGX", "E830CT50", "10 тн", "Авторизовано", "Борт", "Боковая"),
            Truck("Scania P440", "А866CB123", "10 тн", "Авторизовано", "Тент", "Задняя")
    )

    return result
}