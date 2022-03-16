package com.zenika.handson.grenoblehandsonhotwire.repositories.memory

import com.zenika.handson.grenoblehandsonhotwire.entities.City
import com.zenika.handson.grenoblehandsonhotwire.entities.GeoPosition
import com.zenika.handson.grenoblehandsonhotwire.repositories.CitiesRepository
import org.springframework.stereotype.Repository

@Repository
class CitiesRepositoryMemory : CitiesRepository {

    val cities = listOf(
        City("GRENOBLE",  GeoPosition(45.183916, 5.703630)),
        City("SINGAPOUR",  GeoPosition(1.295600, 103.858995)),
        City("BORDEAUX",  GeoPosition(44.848089, -0.571017)),
        City("BREST",  GeoPosition(48.389397, -4.499237)),
        City("MONTREAL",  GeoPosition(45.523000, -73.581700)),
        City("LYON",  GeoPosition(45.767443, 4.858798)),
        City("RENNES",  GeoPosition(48.113409, -1.661249)),
        City("NANTES",  GeoPosition(47.207408, -1.556187)),
        City("LILLE", GeoPosition( 50.648670, 3.075520)),
        City("PARIS", GeoPosition( 48.878932, 2.328487))
    )

    override fun findAll(): List<City> {
        return cities
    }

    override fun getByName(name: String): City? {
        return cities.first { it.name == name }
    }

    override fun save(city: City): City {
        TODO("Not yet implemented")
    }

}
