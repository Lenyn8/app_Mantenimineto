

package com.leninzumba.asistentemant.repository

import com.leninzumba.asistentemant.model.Maquinaria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface MaquinariaRepository: JpaRepository <Maquinaria, Long> {


    fun findById (id:Long?): Maquinaria?

    //parametros para consultar
    @Query (nativeQuery = true)
    fun getlistModelo (@Param("modelo")modelos : Long? ) : List <Maquinaria>?

    @Query (nativeQuery = true)
    fun getlistNombre (@Param("nombre")nombre : String? ) : List <Maquinaria>?

    @Transactional
    @Modifying
    @Query(nativeQuery=true)
    fun setOtherNombre (@Param("nombre")  nombre:String?, @Param("nuevoNombre")  nuevoNombre :String?) : Integer?



}