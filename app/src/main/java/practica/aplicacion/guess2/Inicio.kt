package practica.aplicacion.guess2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio.*

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        btnJugar.setOnClickListener{
            val tema = Intent(this, Tema::class.java)

            startActivity(tema)
        }

        btnRespuestas.setOnClickListener{
            val respuestas = Intent(this, Respuestas::class.java)

            startActivity(respuestas)
        }

        btnAcerca.setOnClickListener{
            val acerca = Intent(this, Acerca::class.java)

            startActivity(acerca)
        }
    }
}
