package practica.aplicacion.guess2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_futbol.*
import kotlinx.android.synthetic.main.activity_lugares.*
import java.util.*

class Lugares : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lugares)

        val userInput: EditText = findViewById<EditText>(R.id.etLugares)
        val resp = userInput

        val random = Random()
        var numeroGenerado = random.nextInt(13)

        establecerImagen(2)

        btnConfirmarLugares.setOnClickListener {
            val respuesta = "grecia"
            if(respuesta == userInput.toString()){
                establecerImagen(numeroGenerado+1)
            }
        }
    }

    val imagenes = arrayOf("china", "egipto", "grecia", "japon", "londres", "machupichu", "niagara", "nuevayork", "paris", "roma", "stonehenge", "sidney", "venecia", "saopaulo")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenLugares.setImageResource(img)
    }
}
