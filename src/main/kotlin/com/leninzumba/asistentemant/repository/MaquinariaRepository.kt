

package com.leninzumba.asistentemant.repository

import com.leninzumba.asistentemant.model.Maquinaria
import org.springframework.data.jpa.repository.JpaRepository

interface MaquinariaRepository: JpaRepository <Maquinaria, Long> {

    fun findById (id:Long?): Maquinaria?



}