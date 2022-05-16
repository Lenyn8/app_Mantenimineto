
package com.leninzumba.asistentemant.service


import com.leninzumba.asistentemant.model.Tecnicos

import com.leninzumba.asistentemant.repository.TecnicosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service




@Service
class TecnicosService {
    @Autowired
    lateinit var tecnicosRepository: TecnicosRepository
    fun list (): List <Tecnicos>{
        return tecnicosRepository.findAll()

    }

    fun save (tecnicos: Tecnicos): Tecnicos{
        return tecnicosRepository.save(tecnicos)


    }

    fun update (tecnicos: Tecnicos):Tecnicos {
        tecnicosRepository.findById(tecnicos.id) ?: throw  Exception()

        return tecnicosRepository.save(tecnicos)
    }

    fun updateName (tecnicos: Tecnicos): Tecnicos {
        val response=  tecnicosRepository.findById(tecnicos.id) ?: throw  Exception()
        response.apply {
            nombre = tecnicos.nombre
        }
        return tecnicosRepository.save(response)

    }


    fun delete (id:Long): Boolean{
        tecnicosRepository.deleteById(id)
        return true
    }




}