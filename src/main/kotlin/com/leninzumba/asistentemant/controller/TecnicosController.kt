package com.leninzumba.asistentemant.controller


import com.leninzumba.asistentemant.model.Tecnicos

import com.leninzumba.asistentemant.service.TecnicosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping ("/tecnicos")

class TecnicosController {

    @Autowired
    lateinit var tecnicosService: TecnicosService

    @GetMapping
    fun list(): List<Tecnicos>{
        return tecnicosService.list()
    }

    @PostMapping
    fun save(@RequestBody tecnicos: Tecnicos): Tecnicos{
        return tecnicosService.save(tecnicos)

    }

    @PutMapping
    fun update (@RequestBody tecnicos: Tecnicos ): Tecnicos{
        return tecnicosService.update(tecnicos)

    }

    @PatchMapping

    fun updateName (@RequestBody tecnicos: Tecnicos): Tecnicos {
        return tecnicosService.updateName( tecnicos)

    }

}
