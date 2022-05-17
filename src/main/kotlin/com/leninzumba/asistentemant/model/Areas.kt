

package com.leninzumba.asistentemant.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name= "areas")

class Areas {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long? = null
    var name: String? = null
    var direccion: String? = null
    @Column(name= "maquinaria_Id")
    var maquinariaId : Long? = null




}