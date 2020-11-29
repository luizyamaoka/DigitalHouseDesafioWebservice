package br.com.digitalhouse.desafiowebservice.extension

fun Double.toPrice() = String.format("$%.2f", this)