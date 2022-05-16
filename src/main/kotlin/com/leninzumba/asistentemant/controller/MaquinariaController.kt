


package com.leninzumba.asistentemant.controller

import com.leninzumba.asistentemant.model.Maquinaria
import com.leninzumba.asistentemant.service.MaquinariaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController

@RequestMapping ("/maquinaria")

class MaquinariaController {

    @Autowired
    lateinit var maquinariaService: MaquinariaService

    @GetMapping
    fun list(): List<Maquinaria>{
        return maquinariaService.list()
    }

    @PostMapping
    fun save(@RequestBody maquinaria:Maquinaria): Maquinaria{
       return maquinariaService.save(maquinaria)

    }

    @PutMapping
    fun update (@RequestBody maquinaria: Maquinaria ): Maquinaria{
        return maquinariaService.update(maquinaria)

    }

    @PatchMapping

    fun updateName (@RequestBody maquinaria: Maquinaria): Maquinaria {
        return maquinariaService.updateName( maquinaria)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return maquinariaService.delete(id)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Maquinaria?{
        return maquinariaService.getById(id)
    }




}






