package com.zenika.handson.grenoblehandsonhotwire.web

import com.mitchellbosecke.pebble.PebbleEngine
import com.zenika.handson.grenoblehandsonhotwire.entities.City
import com.zenika.handson.grenoblehandsonhotwire.entities.GeoPosition
import com.zenika.handson.grenoblehandsonhotwire.services.WeatherService
import com.zenika.handson.grenoblehandsonhotwire.web.vm.CityRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CityController(private val weatherService: WeatherService) {

    @GetMapping("/city/{cityId}")
    fun cityPage(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("city", City("GRENOBLE", GeoPosition(45.0, 5.0)))
        return "city"
    }

    @GetMapping("/city/add")
    fun addCity(): String {
        return "add-city"
    }

    @GetMapping("/frames/city/{cityId}/weather-daily")
    fun cityWeatherDailyFrame(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("degreeUnit", "C°")
        model.addAttribute("weathers", weatherService.getDailyWeatherForCity(cityId))
        return "frames/city-weather-daily"
    }

    @GetMapping("/frames/city/{cityId}/weather-hourly")
    fun cityWeatherHourlyFrame(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("degreeUnit", "C°")
        model.addAttribute("weathers", weatherService.getHourlyWeatherForCity(cityId))
        return "frames/city-weather-hourly"
    }

    @PostMapping("/frames/city/add")
    fun addCityFrame(body: CityRequest, model: Model): String {
        model.addAttribute("cityNameError", "not bueno")
        model.addAttribute("latitudeError", "not bueno")
        model.addAttribute("longitudeError", "not bueno")
        return "add-city"
    }
}
