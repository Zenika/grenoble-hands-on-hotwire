package com.zenika.handson.grenoblehandsonhotwire.web

import com.zenika.handson.grenoblehandsonhotwire.entities.City
import com.zenika.handson.grenoblehandsonhotwire.entities.GeoPosition
import com.zenika.handson.grenoblehandsonhotwire.services.WeatherService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class CityController(private val weatherService: WeatherService) {

    @GetMapping("/city/{cityId}")
    fun cityPage(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("city", City("GRENOBLE", GeoPosition(45.0, 5.0)))
        return "city"
    }

    @GetMapping("/frames/city/{cityId}/weather-daily")
    fun cityWeatherDailyFrame(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("weathers", weatherService.getDailyWeatherForCity(cityId))
        return "frames/city-weather-daily"
    }

    private fun createResponse(body: String) =
        ResponseEntity.ok().header("Content-Type", "text/vnd.turbo-stream.html").body(body)

    @GetMapping("/frames/city/{cityId}/weather-hourly")
    fun cityWeatherHourlyFrame(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("weathers", weatherService.getHourlyWeatherForCity(cityId))
        return "frames/city-weather-hourly"
    }
}
