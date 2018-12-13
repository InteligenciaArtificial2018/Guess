package practica.aplicacion.guess2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_lugares.*
import kotlinx.android.synthetic.main.activity_personajes.*
import java.util.*

class Lugares : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)
        val random = Random()
        var numeroGenerado = random.nextInt(22)

        establecerImagen(numeroGenerado)
        confirmacion(numeroGenerado)

    }

    val imagenes = arrayOf("china", "egipto", "grecia", "japon", "londres", "machupichu", "niagara", "nuevayork", "paris", "roma", "stonehenge", "sidney", "venecia", "saopaulo")

    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenLugares.setImageResource(img)
    }


    fun confirmacion(numero: Int)
    {

        val boton = findViewById<Button>(R.id.btnConfirmarLugares)
        val texto = findViewById<EditText>(R.id.respuestaLugares)
        boton.setOnClickListener() {
            val respuesta = texto.text.toString()
            if (respuesta == imagenes[numero]) {
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_LONG).show()
            }
//            Toast.makeText(this, imagenes[2], Toast.LENGTH_LONG).show()
        }
    }
}
