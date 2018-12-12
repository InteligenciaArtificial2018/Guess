package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_personajes.*
import java.util.*

class Personajes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personajes)
        val random = Random()
        var numeroGenerado = random.nextInt(22)

        establecerImagen(0)
        confirmacion(0)
    }


    val imagenes = arrayOf("aquaman", "arrow", "batman", "capitanamerica", "chapulincolorado", "daredevil", "elacertijo", "elguason", "elzorro", "flash", "gatubela", "hellboy", "hulk", "ironman", "loki", "mujermaravilla", "panteranegra", "robin", "spiderman", "tarzan", "thor", "tortugasninja", "wolverine")
    val respuestas = arrayOf("aquaman ")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenPersonajes.setImageResource(img)
    }
    fun confirmacion(numero: Int)
    {

        val boton = findViewById<Button>(R.id.btnConfirmarPersonajes)
        val texto = findViewById<TextView>(R.id.respuestaPersonajes)
        val respuesta = texto.text

        boton.setOnClickListener(){
            if (respuesta == respuestas[numero])
            {
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, respuesta, Toast.LENGTH_LONG).show()
            }
        }
    }
}
