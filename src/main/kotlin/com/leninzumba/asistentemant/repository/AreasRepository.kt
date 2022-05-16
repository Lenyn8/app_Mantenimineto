

package com.leninzumba.asistentemant.repository

import com.leninzumba.asistentemant.model.Areas

import org.springframework.data.jpa.repository.JpaRepository

interface AreasRepository: JpaRepository <Areas, Long> {

    fun findById (id:Long?): Areas?



}