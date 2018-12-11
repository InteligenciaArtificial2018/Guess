package practica.aplicacion.guess2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tema.*

class Tema : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tema)

        btnFutbol.setOnClickListener{
            val futbol = Intent(this, Futbol::class.java)

            startActivity(futbol)
        }

        btnLugares.setOnClickListener{
            val lugares = Intent(this, Lugares::class.java)

            startActivity(lugares)
        }

        btnPersonajes.setOnClickListener{
            val personajes = Intent(this, Personajes::class.java)

            startActivity(personajes)
        }

        btnMarcas.setOnClickListener{
            val marcas = Intent(this, Marcas::class.java)

            startActivity(marcas)
        }
    }
}
