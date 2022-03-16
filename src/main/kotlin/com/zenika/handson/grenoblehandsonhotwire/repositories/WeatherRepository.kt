package com.zenika.handson.grenoblehandsonhotwire.repositories

import com.zenika.handson.grenoblehandsonhotwire.entities.City
import com.zenika.handson.grenoblehandsonhotwire.entities.HourlyWeather
import com.zenika.handson.grenoblehandsonhotwire.entities.Weather

interface WeatherRepository {
    fun getDailyWeather(city: City): List<Weather>
    fun getHourlyWeather(city: City): List<HourlyWeather>
}
