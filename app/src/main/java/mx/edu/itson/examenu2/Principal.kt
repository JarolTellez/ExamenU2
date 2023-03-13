package mx.edu.itson.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Principal : AppCompatActivity() {


    var adapter: RegalosAdapter? = null

    var detalles= ArrayList<Detalles>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)




            cargarRegalos()

            adapter=RegalosAdapter(this,detalles)

            var gridDetalles:GridView =findViewById(R.id.grid_Regalos) as GridView


            gridDetalles.adapter= adapter


        }

        fun cargarRegalos(){


            detalles.add(Detalles(R.drawable.cumplebotanas,""))

    }



}

class RegalosAdapter:BaseAdapter{
    var detalles=ArrayList<Detalles>()
    var contexto: Context?=null

    constructor(context: Context,detalles:ArrayList<Detalles>){
        this.detalles=detalles;
        this.contexto=context
    }


    override fun getItem(p0: Int): Any {
        return detalles[p0]
    }

    override fun getItemId(p0: Int): Long {

    }



    override fun getCount(): Int {
        return detalles.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var  regalo=detalles[p0]
        var inflador=LayoutInflater.from(contexto)
        var vista=inflador.inflate(R.layout.activity_regalos,null)

        var imagen=vista.findViewById(R.id.iv_regalo_imagen)as ImageView
        var nombre=vista.findViewById(R.id.tv_regalo_nombre)as TextView
        var precio=vista.findViewById(R.id.tv_regalo_precio) as TextView

        vista.setOnClickListener {
            var intent:Intent=Intent(contexto,DetalleRegalos::class.java)
            intent.putExtra("nombre",regalo.titulo)
            intent.putExtra("imagen",regalo.image)
            intent.putExtra("precio",regalo.precio)
            contexto!!.startActivity(intent)

        }
        return vista
    }
}




