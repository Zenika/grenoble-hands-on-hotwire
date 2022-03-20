package com.zenika.handson.grenoblehandsonhotwire.web

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.spring.reactive.PebbleReactiveView
import com.mitchellbosecke.pebble.spring.reactive.PebbleReactiveViewResolver
import com.zenika.handson.grenoblehandsonhotwire.entities.City
import com.zenika.handson.grenoblehandsonhotwire.entities.GeoPosition
import com.zenika.handson.grenoblehandsonhotwire.services.WeatherService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.io.StringWriter
import java.time.Duration
import java.util.*

@Controller
class CityController(private val weatherService: WeatherService, private val pebbleEngine: PebbleEngine) {

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

    @GetMapping("/frames/city/{cityId}/weather-hourly")
    fun cityWeatherHourlyFrame(@PathVariable cityId: String, model: Model): String {
        model.addAttribute("mode", "simple")
        model.addAttribute("weathers", weatherService.getHourlyWeatherForCity(cityId))
        return "frames/city-weather-hourly"
    }
}
