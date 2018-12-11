package practica.aplicacion.guess2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_futbol.*
import java.util.*

class Futbol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_futbol)

        val random = Random()
        var numeroGenerado = random.nextInt(27)

        establecerImagen(numeroGenerado)
    }


    val imagenes = arrayOf("baca", "bale", "bocajunior", "dembele", "dybala", "elis", "falcao", "gabrieljesus", "gago", "griezman", "ibrahimovic", "icardi", "james", "kaka", "kroos", "mata", "mbappe", "modric", "neymar", "pirlo", "ramos", "realmadrid", "river", "robben", "ronaldinho", "salah", "suarez", "tevez")

    fun establecerImagen( numero:Int){
        var img = getResources().getIdentifier(imagenes[numero], "mipmap", getPackageName())
        imagenFutbol.setImageResource(img)
    }
}
