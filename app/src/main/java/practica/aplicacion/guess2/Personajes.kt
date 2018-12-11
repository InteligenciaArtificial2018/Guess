package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_personajes.*
import java.util.*

class Personajes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personajes)
        val random = Random()
        var numeroGenerado = random.nextInt(22)

        establecerImagen(numeroGenerado)
    }

    val imagenes = arrayOf("aquaman", "arrow", "batman", "capitanamerica", "chapulincolorado", "daredevil", "elacertijo", "elguason", "elzorro", "flash", "gatubela", "hellboy", "hulk", "ironman", "loki", "mujermaravilla", "panteranegra", "robin", "spiderman", "tarzan", "thor", "tortugasninja", "wolverine")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenPersonajes.setImageResource(img)
    }
}
