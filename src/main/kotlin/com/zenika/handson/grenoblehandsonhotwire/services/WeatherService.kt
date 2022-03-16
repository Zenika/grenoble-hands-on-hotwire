package com.zenika.handson.grenoblehandsonhotwire.services

import com.zenika.handson.grenoblehandsonhotwire.repositories.CitiesRepository
import com.zenika.handson.grenoblehandsonhotwire.repositories.WeatherRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class WeatherService(private val cityRepository: CitiesRepository, private val weatherRepository: WeatherRepository) {

    @Cacheable(cacheNames = ["dailyWeather"])
    fun getDailyWeatherForCity(name: String) = cityRepository.getByName(name)
            ?.let { weatherRepository.getDailyWeather(it) }

    @Cacheable(cacheNames = ["hourlyWeather"])
    fun getHourlyWeatherForCity(name: String) = cityRepository.getByName(name)
            ?.let { weatherRepository.getHourlyWeather(it) }

}
