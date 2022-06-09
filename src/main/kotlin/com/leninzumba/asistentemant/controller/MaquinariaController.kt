


package com.leninzumba.asistentemant.controller

import com.leninzumba.asistentemant.dto.ChangeNombre
import com.leninzumba.asistentemant.model.Maquinaria
import com.leninzumba.asistentemant.model.Tiempos
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
     // parametro consulta
    @GetMapping("/modelo/{modelo}")
    fun lisByModelo(@PathVariable("modelo") modelo: Long): List<Maquinaria>?{
        return maquinariaService.getByModelo(modelo)
    }

    @GetMapping("/nombre/{nombre}")
    fun lisByNombre(@PathVariable("nombre") nombre: String): List<Maquinaria>?{
        return maquinariaService.getByNombre(nombre)
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

    //localhost:8081/students/changeName
    @PostMapping("/change/nombre")
    fun updateOtherNombre (@RequestBody changeNombre: ChangeNombre): String?{
        return maquinariaService.updateOtherNombre(changeNombre)
    }




}






