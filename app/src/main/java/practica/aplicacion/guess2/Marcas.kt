package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.*
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_marcas.*
import practica.aplicacion.guess2.R.id.imagenMarcas
import java.util.*

/**
 * clase correspondiente a la opcion de marcas.
 */
class Marcas : AppCompatActivity() {
    /**
     * creacion de las variables de puntaje
     */
    var puntaje: Int = 0
    var vida: Int = 3
    var conteo: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marcas)
        val random = Random()
        var numeroGenerado = random.nextInt(18)


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
     * Arreglo en la cual se encuentran la lista de las respuestas correctas.
     */
    val imagenes = arrayOf("android", "apple", "facebook", "ferrari", "gmail", "honda", "lacoste", "mcdonald", "mercedes", "messenger", "nike", "pepsi", "playstation", "skype", "starbucks", "twitter", "windows", "warner", "xbox")

    /**
     * funciones en la que se compara si la respuesta en el arreglo y la ingresada por el usuario
     * es correcta.
     */
    fun establecerImagen(numero: Int) {
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenMarcas.setImageResource(img)
        confirmacion(numero)
    }

    fun confirmacion(numero: Int)
    {
        val boton = findViewById<Button>(R.id.btnConfirmarMarcas)
        val texto = findViewById<EditText>(R.id.respuestaMarcas)

        // Empieza cambio de textview
        val receptor = findViewById<TextView>(R.id.txtVidasMarcas)
        val receptorPuntaje = findViewById<TextView>(R.id.txtPuntajeMarcas)
        val receptorConteo = findViewById<TextView>(R.id.txtConteoMarcas)

        receptorPuntaje.setText("Puntaje: " + puntaje)
        receptorConteo.setText("" + conteo)
        receptor.setText("Vidas: " + vida)

        boton.setOnClickListener(){
            val respuesta = texto.text.toString()

            if (respuesta == imagenes[numero])
            {
                val otroRandom = Random()
                var numeroGenerar = otroRandom.nextInt(18)

                establecerImagen(numeroGenerar)

                conteo = conteo + 1
                puntaje = puntaje + 5

                receptorConteo.setText("" + conteo)
                receptorPuntaje.setText("Puntaje: " + puntaje)
                texto.setText("")
                /**
                 * Mensajes de confirmacion de las respuestas ingresadas por el usuario.
                 */
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
