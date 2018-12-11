package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_marcas.*
import java.util.*

class Marcas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcas)
        val random = Random()
        var numeroGenerado = random.nextInt(18)

        establecerImagen(numeroGenerado)
    }

    val imagenes = arrayOf("android", "apple", "facebook", "ferrari", "gmail", "honda", "lacoste", "mcdonald", "mercedes", "messenger", "nike", "pepsi", "playstation", "skype", "starbucks", "twitter", "windows", "warner", "xbox")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenMarcas.setImageResource(img)
    }
}
