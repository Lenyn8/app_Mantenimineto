

package com.leninzumba.asistentemant.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name= "maquinaria")
class Maquinaria {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long ? = null
    var nombre: String? = null
    var modelo: Long? = null


    @Column(name= "areas_id")
    var areasId : Long? = null
    @Column(name= "tecnicos_id")
    var tecnicosId : Long? = null








}