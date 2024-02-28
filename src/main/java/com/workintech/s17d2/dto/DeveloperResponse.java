package com.workintech.s17d2.dto;

import com.workintech.s17d2.DependencyInjection.controller.Experience;

public record DeveloperResponse(Integer id, String name, Double salary, Experience experience) {

}
