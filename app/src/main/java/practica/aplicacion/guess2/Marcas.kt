package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_marcas.*
import practica.aplicacion.guess2.R.id.imagenMarcas
import java.util.*

class Marcas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcas)
        val random = Random()
        var numeroGenerado = random.nextInt(18)


        establecerImagen(numeroGenerado)
        confirmacion(numeroGenerado)
    }

    val imagenes = arrayOf("android", "apple", "facebook", "ferrari", "gmail", "honda", "lacoste", "mcdonald", "mercedes", "messenger", "nike", "pepsi", "playstation", "skype", "starbucks", "twitter", "windows", "warner", "xbox")

    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenMarcas.setImageResource(img)
    }

    fun confirmacion(numero: Int) {

        val boton = findViewById<Button>(R.id.btnConfirmarMarcas)
        val texto = findViewById<EditText>(R.id.respuestaMarcas)
        boton.setOnClickListener() {
            val respuesta = texto.text.toString()
            if (respuesta == imagenes[numero]) {
                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_LONG).show()
            }
//            Toast.makeText(this, imagenes[2], Toast.LENGTH_LONG).show()
        }
    }
}
