package practica.aplicacion.guess2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_lugares.*
import kotlinx.android.synthetic.main.activity_personajes.*
import java.util.*

class Lugares : AppCompatActivity() {
    /**
     *Creacion de los textview correspondientes a los puntajes y vidas.
     */
    var puntaje: Int = 0
    var vida: Int = 3
    var conteo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)
        val random = Random()
        var numeroGenerado = random.nextInt(13)

        establecerImagen(numeroGenerado)


        // Flecha atras
        val actionbar: ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

    }
    // Flecha atras
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    /**
     * Arreglo en el cual se encuentran las respuestas correctas a ingresar
     */
    val imagenes = arrayOf("china", "egipto", "grecia", "japon", "londres", "machupichu", "niagara", "nuevayork", "paris", "roma", "stonehenge", "sidney", "venecia", "saopaulo")

    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenLugares.setImageResource(img)
        confirmacion(numero)
    }

    /**
     * funcion eque confirma la informacion ingresada y valida si la respuesta es correcta o no.
     */
    fun confirmacion(numero: Int)
    {
        val boton = findViewById<Button>(R.id.btnConfirmarLugares)
        val texto = findViewById<EditText>(R.id.respuestaLugares)

        // Empieza cambio de textview
        val receptor = findViewById<TextView>(R.id.txtVidasLugares)
        val receptorPuntaje = findViewById<TextView>(R.id.txtPuntajeLugares)
        val receptorConteo = findViewById<TextView>(R.id.txtConteoLugares)

        receptorPuntaje.setText("Puntaje: " + puntaje)
        receptorConteo.setText("" + conteo)
        receptor.setText("Vidas: " + vida)

        boton.setOnClickListener(){
            val respuesta = texto.text.toString()

            if (respuesta == imagenes[numero])
            {
                val otroRandom = Random()
                var numeroGenerar = otroRandom.nextInt(13)

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
