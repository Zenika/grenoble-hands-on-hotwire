package com.zenika.handson.grenoblehandsonhotwire.web.vm

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull


class CityRequest(
    @NotNull val name: String,
    @NotNull @Min(-180) @Max(180) val longitude: Double,
    @NotNull @Min(-180) @Max(180) val latitude: Double
)
