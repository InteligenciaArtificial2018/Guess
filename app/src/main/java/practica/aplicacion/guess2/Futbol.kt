package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import java.util.*

class Futbol : AppCompatActivity() {
    // Validacion de los nombres de correctos de cada una de las imagenes los cuales seran comparados
// con las respuestas almacenadas en la base de datos//

    var puntaje: Int = 0
    var vida: Int = 3
    var conteo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futbol)

        val random = Random()
        var numeroGenerado = random.nextInt(27)

        establecerImagen(numeroGenerado)
        confirmacion(numeroGenerado)

        // Flecha atras
        val actionbar: ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
    }
    // Flecha atras
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    val imagenes = arrayOf("baca", "bale", "bocajunior", "dembele", "dybala", "elis", "falcao", "gabrieljesus", "gago", "griezman", "ibrahimovic", "icardi", "james", "kaka", "kroos", "mata", "mbappe", "modric", "neymar", "pirlo", "ramos", "realmadrid", "river", "robben", "ronaldinho", "salah", "suarez", "tevez")

    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenFutbol.setImageResource(img)
        confirmacion(numero)

    }

    fun confirmacion(numero: Int)
    {
        val boton = findViewById<Button>(R.id.btnConfirmarFutbol)
        val texto = findViewById<EditText>(R.id.respuestaFutbol)

        // Empieza cambio de textview
        val receptor = findViewById<TextView>(R.id.txtVidasFutbol)
        val receptorPuntaje = findViewById<TextView>(R.id.txtPuntajeFutbol)
        val receptorConteo = findViewById<TextView>(R.id.txtConteoFutbol)

        receptorPuntaje.setText("Puntaje: " + puntaje)
        receptorConteo.setText("" + conteo)
        receptor.setText("Vidas: " + vida)

        boton.setOnClickListener(){
            val respuesta = texto.text.toString()

            if (respuesta == imagenes[numero])
            {
                val otroRandom = Random()
                var numeroGenerar = otroRandom.nextInt(27)

                establecerImagen(numeroGenerar)

                conteo = conteo + 1
                puntaje = puntaje + 5

                receptorConteo.setText("" + conteo)
                receptorPuntaje.setText("Puntaje: " + puntaje)
                texto.setText("")

                Toast.makeText(this, "Respuesta correcta", Toast.LENGTH_LONG).show()

            }
            else
            {
                Toast.makeText(this, "Respuesta incorrecta", Toast.LENGTH_LONG).show()

                vida = (vida - 1)
                receptor.setText("Vidas: " + vida)

                if(vida == 0){
                    setContentView(R.layout.activity_gameover)
                }
            }

            // Termina cambio textview
//            Toast.makeText(this, imagenes[2], Toast.LENGTH_LONG).show()
        }
    }
}