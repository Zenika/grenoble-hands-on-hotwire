package com.zenika.handson.grenoblehandsonhotwire.web

import com.zenika.handson.grenoblehandsonhotwire.repositories.CitiesRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController(val citiesRepository: CitiesRepository) {

    @GetMapping
    fun home(): String {
        return "home"
    }

    @GetMapping("/frames/cities")
    fun citiesList(model: Model): String {
        model.addAttribute("cities", citiesRepository.findAll())
        return "frames/cities"
    }
}
