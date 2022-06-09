import com.leninzumba.asistentemant.model.Canchitas
import com.leninzumba.asistentemant.service.CanchitasService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/*
import com.leninzumba.asistentemant.model.Canchitas

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController

@RequestMapping("/canchitas")

class CanchitasService {

    @Autowired
    lateinit var canchitasService: CanchitasService

    @PostMapping
    fun save(@RequestBody canchitas: Canchitas): Canchitas {
        return canchitasService.save(canchitas)

    }

    @GetMapping
    fun list(): List<Canchitas>{
        return canchitasService.list()
    }

    @GetMapping("/nombre/{nombre}")
    fun lisByNombre(@PathVariable("nombre") nombre: String): List<Canchitas>?{
        return canchitasService.lisByNombre(nombre)
    }

    @GetMapping("/hora/{hora}")
    fun lisByHora(@PathVariable("hora") hora: Int): List<Canchitas>?{
        return canchitasService.lisByHora(hora)
    }

    @GetMapping("/cancha/{cancha}")
    fun lisByCancha(@PathVariable("cancha") cancha: String): List<Canchitas>?{
        return canchitasService.lisByCancha(cancha)
    }


}
*/

@RestController
@RequestMapping ("/canchitas")

class CanchitasController {

    @Autowired
    lateinit var canchitasService: CanchitasService

    @PostMapping
    fun save(@RequestBody canchitas: Canchitas): Canchitas {
        return canchitasService.save(canchitas)
    }

    @GetMapping
    fun list(): List<Canchitas>{
        return canchitasService.list()
    }

    @GetMapping ("/nombre/{nombre}")
    fun listByNombre (@PathVariable("nombre") nombre: String):List<Canchitas>? {
        return canchitasService.getByNombre(nombre)
    }

    @GetMapping ("/hora/{hora}")
    fun listByHora (@PathVariable("hora") hora: Int):List<Canchitas>? {
        return canchitasService.getByHora(hora)
    }

    @GetMapping ("/cancha/{cancha}")
    fun listByCancha (@PathVariable("cancha") cancha: String):List<Canchitas>? {
        return canchitasService.getByCancha(cancha)
    }


}