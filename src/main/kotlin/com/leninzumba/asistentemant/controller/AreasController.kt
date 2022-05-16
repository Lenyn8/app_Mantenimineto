package com.leninzumba.asistentemant.controller


import com.leninzumba.asistentemant.model.Areas

import com.leninzumba.asistentemant.service.AreasService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping ("/areas")

class AreasController {

    @Autowired
    lateinit var areasService: AreasService

    @GetMapping
    fun list(): List<Areas>{
        return areasService.list()
    }

    @PostMapping
    fun save(@RequestBody areas: Areas): Areas{
        return areasService.save(areas)

    }

    @PutMapping
    fun update (@RequestBody areas: Areas ): Areas{
        return areasService.update(areas)

    }

    @PatchMapping

    fun updateName (@RequestBody areas: Areas): Areas {
        return areasService.updateName( areas)

    }

}


