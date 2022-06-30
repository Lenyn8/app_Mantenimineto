import com.leninzumba.asistentemant.service.MaquinariaService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class MaquinariaServiceTest{

    @Autowired
    lateinit var maquinariaService: MaquinariaService

    @Test
    fun validateSerialIsValid(){
        val response =  maquinariaService.validateSerialNumber("786456789")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun validateSerialIsInvalid(){
        val response = maquinariaService.validateSerialNumber("32154697")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateSerialIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            val response = maquinariaService.validateSerialNumber("")

        }
    }

    @Test
    fun validateSerialIsincomplete(){
        Assertions.assertThrows(Exception::class.java) {
            val response = maquinariaService.validateSerialNumber("1")

        }
    }




}