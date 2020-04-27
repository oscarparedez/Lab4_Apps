package com.example.lab4_apps.ui.sampledata

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

import com.example.lab4_apps.R


class ResultadoFragment : Fragment() {
//    var listaConfirmados: IntArray
//    var listaNoConfirmados: IntArray = arrayOf()
//    val fragment = SlideshowFragment.newInstance(listaConfirmados, listaNoConfirmados)

//    override fun onAttach(context: Context) {
//        if (context != null) {
//            super.onAttach(context)
//        }
//        arguments?.getIntegerArrayList("listaConfirmados")?.let {
//            listaConfirmados = it
//        }
//        arguments?.getIntegerArrayList("listaNoConfirmados")?.let {
//            listaNoConfirmados = it
//        }
//
    var textoAInicio: String = ""

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root =  inflater.inflate(R.layout.fragment_resultado, container, false)

        var listaConfirmados = ResultadoFragmentArgs.fromBundle(arguments!!).listaConfirmados
        var listaNoConfirmados = ResultadoFragmentArgs.fromBundle(arguments!!).listaNoConfirmados

        val listaInvitados: Array<String> = arrayOf("Invitado 1", "Invitado 2", "Invitado 3", "Invitado 4", "Invitado 5", "Invitado 6", "Invitado 7", "Invitado 8", "Invitado 9", "Invitado 10")

        val cantConfirmados: Int = listaConfirmados.size
        val cantNoConfirmados: Int = listaNoConfirmados.size
        val invitados: Int = cantConfirmados + cantNoConfirmados

        val txtInvitados: TextView = root.findViewById(R.id.txtInvitados)
        txtInvitados.text = "Invitados: $invitados"

        val txtRegistrados: TextView = root.findViewById(R.id.txtRegistrados)
        txtRegistrados.text = "Registrados: $cantConfirmados"

        val btnReiniciar: Button = root.findViewById(R.id.btnReiniciar)
        val btnVerInvitados: Button = root.findViewById(R.id.btnVerInvitados)

        btnReiniciar.setOnClickListener(){
            findNavController().navigate(R.id.nav_slideshow)
        }

        var textoToast: String = "| "
        btnVerInvitados.setOnClickListener(){
            for (i in 0..listaConfirmados.size-1){
                textoToast+=listaInvitados[listaConfirmados[i]]+" SI | "
            }
            for (i in 0..listaNoConfirmados.size-1){
                textoToast+=listaInvitados[listaNoConfirmados[i]]+" NO | "
            }
            textoToast = textoToast.substring(0, textoToast.length-1)
            Toast.makeText(context, textoToast, Toast.LENGTH_SHORT).show()
            textoAInicio = textoToast
            textoToast = ""



        }

        return root
    }

    //enable options menu in this fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }
    //inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menushare, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    //handle item clicks of menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //get item id to handle item clicks
        val id = item!!.itemId
        //handle item clicks
        if (id == R.id.action_share){
            //do your action here, im just showing toast
//            Toast.makeText(activity, "Mensaje Compartido", Toast.LENGTH_SHORT).show()
            val action = ResultadoFragmentDirections.actionNavResultadoToNavHome(textoAInicio)
            findNavController().navigate(action)
        }

        return super.onOptionsItemSelected(item)
    }



}
