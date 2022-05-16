
package com.leninzumba.asistentemant.service


import com.leninzumba.asistentemant.model.Tecnicos

import com.leninzumba.asistentemant.repository.TecnicosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class TecnicosService {
    @Autowired
    lateinit var tecnicosRepository: TecnicosRepository
    fun list (): List <Tecnicos>{
        return tecnicosRepository.findAll()

    }

    fun save (tecnicos: Tecnicos): Tecnicos{
        try {
            tecnicos.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Campo TECNICOS no debe ser vacio")

            return tecnicosRepository.save(tecnicos)
        }

        catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun update (tecnicos: Tecnicos):Tecnicos {
        tecnicosRepository.findById(tecnicos.id) ?: throw  Exception()

        return tecnicosRepository.save(tecnicos)
    }

    fun updateName (tecnicos: Tecnicos): Tecnicos {
        try {


            val response = tecnicosRepository.findById(tecnicos.id)
                ?: throw Exception("El id ${tecnicos.id} en TECNICOS no existe")
            response.apply {
                this.nombre = tecnicos.nombre
            }
            return tecnicosRepository.save(tecnicos)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }


    fun delete (id:Long): Boolean{
        tecnicosRepository.deleteById(id)
        return true
    }




}