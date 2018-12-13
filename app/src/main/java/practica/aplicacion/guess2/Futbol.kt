package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import java.util.*

class Futbol : AppCompatActivity() {
    // Validacion de los nombres de correctos de cada una de las imagenes los cuales seran comparados
// con las respuestas almacenadas en la base de datos//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futbol)

        val random = Random()
        var numeroGenerado = random.nextInt(27)

        establecerImagen(numeroGenerado)
        confirmacion(numeroGenerado)
    }


    val imagenes = arrayOf("baca", "bale", "bocajunior", "dembele", "dybala", "elis", "falcao", "gabrieljesus", "gago", "griezman", "ibrahimovic", "icardi", "james", "kaka", "kroos", "mata", "mbappe", "modric", "neymar", "pirlo", "ramos", "realmadrid", "river", "robben", "ronaldinho", "salah", "suarez", "tevez")

    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenFutbol.setImageResource(img)
    }

    fun confirmacion(numero: Int) {

        val boton = findViewById<Button>(R.id.btnConfirmarFutbol)
        val texto = findViewById<EditText>(R.id.respuestaFutbol)
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