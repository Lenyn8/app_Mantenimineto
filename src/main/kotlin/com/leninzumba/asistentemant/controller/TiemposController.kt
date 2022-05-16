
package com.leninzumba.asistentemant.controller


import com.leninzumba.asistentemant.model.Tiempos

import com.leninzumba.asistentemant.service.TiemposService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping ("/tiempos")

class TiemposController {

    @Autowired
    lateinit var tiemposService: TiemposService

    @GetMapping
    fun list(): List<Tiempos>{
        return tiemposService.list()
    }

    @PostMapping
    fun save(@RequestBody tiempos: Tiempos): Tiempos{
        return tiemposService.save(tiempos)

    }

    @PutMapping
    fun update (@RequestBody tiempos: Tiempos ): Tiempos{
        return tiemposService.update(tiempos)

    }

    @PatchMapping

    fun updateName (@RequestBody tiempos: Tiempos): Tiempos {
        return tiemposService.updateName(tiempos)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return tiemposService.delete(id)
    }

}
