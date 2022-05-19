package com.leninzumba.asistentemant.service


import com.leninzumba.asistentemant.model.Maquinaria
import com.leninzumba.asistentemant.model.Tecnicos
import com.leninzumba.asistentemant.model.Tiempos
import com.leninzumba.asistentemant.repository.MaquinariaRepository


import com.leninzumba.asistentemant.repository.TiemposRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class TiemposService {
    @Autowired
    lateinit var tiemposRepository: TiemposRepository
    @Autowired
    lateinit var maquinariaRepository: MaquinariaRepository

 
    fun list (): List <Tiempos>{
        return tiemposRepository.findAll()

    }

    fun save (tiempos:Tiempos): Tiempos{
        try {
            tiempos.contador?.takeIf { it >=0 }
                ?: throw Exception("Campo TIMEPOS no debe ser vacio")

            maquinariaRepository.findById(tiempos.maquinariaId)
                ?: throw Exception("Campo AREAS no debe ser vacio")


            return tiemposRepository.save(tiempos)
        }

        catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }



    }

    fun update (tiempos: Tiempos):Tiempos {
        tiemposRepository.findById(tiempos.id) ?: throw  Exception()

        return tiemposRepository.save(tiempos)
    }



    fun updateName (tiempos: Tiempos): Tiempos {
        try {


            val response = tiemposRepository.findById(tiempos.id)
                ?: throw Exception("El id ${tiempos.id} en TIEMPOS no existe")
            response.apply {
                this.contador = tiempos.contador
            }
            return tiemposRepository.save(tiempos)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        tiemposRepository.deleteById(id)
        return true
    }




}