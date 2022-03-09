package com.hungryduck.foodtruck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoodtruckApplication

fun main(args: Array<String>) {
    runApplication<FoodtruckApplication>(*args)
}
