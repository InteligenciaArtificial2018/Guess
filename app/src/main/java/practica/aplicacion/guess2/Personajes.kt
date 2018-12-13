package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
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

        establecerImagen(numeroGenerado)
        confirmacion(numeroGenerado)


    }


    val imagenes = arrayOf("aquaman", "arrow", "batman", "capitan america", "chapulin colorado", "daredevil", "el acertijo", "el guason", "el zorro", "flash", "gatubela", "hellboy", "hulk", "ironman", "loki", "mujer maravilla", "pantera negra", "robin", "spiderman", "tarzan", "thor", "tortugas ninja", "wolverine")


    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenPersonajes.setImageResource(img)
    }


    fun confirmacion(numero: Int)
    {

        val boton = findViewById<Button>(R.id.btnConfirmarPersonajes)
        val texto = findViewById<EditText>(R.id.respuestaPersonajes)
        boton.setOnClickListener(){
            val respuesta = texto.text.toString()
            if (respuesta == imagenes[numero])
            {
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
