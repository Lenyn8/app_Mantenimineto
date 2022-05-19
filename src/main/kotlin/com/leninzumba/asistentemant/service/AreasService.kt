
package com.leninzumba.asistentemant.service

import com.leninzumba.asistentemant.model.Areas

import com.leninzumba.asistentemant.repository.AreasRepository
import com.leninzumba.asistentemant.repository.MaquinariaRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class AreasService {
    @Autowired
    lateinit var areasRepository: AreasRepository

    @Autowired
    lateinit var maquinariaRepository: MaquinariaRepository

    fun list(): List<Areas> {
        return areasRepository.findAll()

    }

    fun save(areas: Areas): Areas {
        try {
            areas.name?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Campo AREAS no debe ser vacio")



            return areasRepository.save(areas)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }


    }


    fun update(areas: Areas): Areas {
        areasRepository.findById(areas.id) ?: throw Exception()

        return areasRepository.save(areas)
    }

    fun updateName(areas: Areas): Areas {
        try {


            val response = areasRepository.findById(areas.id)
                ?: throw Exception("El id ${areas.id} en AREA no existe")
            response.apply {
                this.name = areas.name
            }
            return areasRepository.save(areas)
          } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
          }




    }

    fun delete(id: Long): Boolean {
        areasRepository.deleteById(id)
        return true
    }


}