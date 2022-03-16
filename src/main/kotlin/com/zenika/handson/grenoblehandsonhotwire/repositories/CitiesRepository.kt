package com.zenika.handson.grenoblehandsonhotwire.repositories

import com.zenika.handson.grenoblehandsonhotwire.entities.City


interface CitiesRepository {
    fun findAll(): List<City>
    fun getByName(name: String): City?
    fun save(city: City): City
}
