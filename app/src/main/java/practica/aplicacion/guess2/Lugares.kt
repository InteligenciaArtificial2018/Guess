package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_lugares.*
import java.util.*

class Lugares : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)
        val random = Random()
        var numeroGenerado = random.nextInt(13)

        establecerImagen(numeroGenerado)
    }

    val imagenes = arrayOf("china", "egipto", "grecia", "japon", "londres", "machupichu", "niagara", "nuevayork", "paris", "roma", "stonehenge", "sidney", "venecia", "saopaulo")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenLugares.setImageResource(img)
    }
}
