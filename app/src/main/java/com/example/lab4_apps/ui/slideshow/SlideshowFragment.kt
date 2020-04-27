package com.example.lab4_apps.ui.slideshow

import android.os.Bundle
import android.view.*
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.lab4_apps.R


class SlideshowFragment : Fragment() {

    private lateinit var slideshowViewModel: SlideshowViewModel

    //enable options menu in this fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        slideshowViewModel = ViewModelProviders.of(this).get(SlideshowViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)

        var btnSi: ImageButton = root.findViewById<ImageButton>(R.id.btnSi)
        var btnNo: ImageButton = root.findViewById<ImageButton>(R.id.btnNo)


        val listaConfirmados: ArrayList<Int> = arrayListOf()
        val listaNoConfirmados: ArrayList<Int> = arrayListOf()

        val listaRegistrando: Array<String> = arrayOf("Registrando (1/10)", "Registrando (2/10)", "Registrando (3/10)", "Registrando (4/10)", "Registrando (5/10)", "Registrando (6/10)", "Registrando (7/10)", "Registrando (8/10)", "Registrando (9/10)", "Registrando (10/10)")
        val listaInvitados: Array<String> = arrayOf("Invitado 1", "Invitado 2", "Invitado 3", "Invitado 4", "Invitado 5", "Invitado 6", "Invitado 7", "Invitado 8", "Invitado 9", "Invitado 10")
        val listaTelefonos: Array<String> = arrayOf("58394872", "48938274", "482710485", "39284751", "40928416", "31029455", "55554029", "55432100", "50009841", "58883726")
        val listaCorreos: Array<String> = arrayOf("persona1@zvent.com", "persona2@zvent.com", "persona3@zvent.com", "persona4@zvent.com", "persona5@zvent.com", "persona6@zvent.com", "persona7@zvent.com","persona8@zvent.com",  "persona9@zvent.com", "persona10@zvent.com")

        var txtNombre: TextView = root.findViewById<TextView>(R.id.txtNombre)
        var txtTelefono: TextView = root.findViewById<TextView>(R.id.txtTelefono)
        var txtEmail: TextView = root.findViewById<TextView>(R.id.txtEmail)

        var i:Int = 0

        (activity as AppCompatActivity).supportActionBar?.title = listaRegistrando[0]
        txtNombre.text = listaInvitados[0]
        txtTelefono.text = listaTelefonos[0]
        txtEmail.text = listaCorreos[0]

        btnSi.setOnClickListener(){
            if(i>=10){
                val action = SlideshowFragmentDirections.actionNavSlideshowToNavResultado(listaConfirmados.toIntArray(), listaNoConfirmados.toIntArray())
                findNavController().navigate(action)

            }else {
                (activity as AppCompatActivity).supportActionBar?.title = listaRegistrando[i]
                txtNombre.text = listaInvitados[i]
                txtTelefono.text = listaTelefonos[i]
                txtEmail.text = listaCorreos[i]
                listaConfirmados.add(i)

                i++

            }

        }

        btnNo.setOnClickListener(){
            if(i>=10){
                val action = SlideshowFragmentDirections.actionNavSlideshowToNavResultado(listaConfirmados.toIntArray(), listaNoConfirmados.toIntArray())
                findNavController().navigate(action)

            } else {
                (activity as AppCompatActivity).supportActionBar?.title = listaRegistrando[i]
                txtNombre.text = listaInvitados[i]
                txtTelefono.text = listaTelefonos[i]
                txtEmail.text = listaCorreos[i]
                listaNoConfirmados.add(i)

                i++
            }
        }
        return root
    }



    //inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater!!.inflate(R.menu.menushare, menu)

        //hide some items from this fragment (e.g. sort)
        menu!!.findItem(R.id.action_share).isVisible = false

        super.onCreateOptionsMenu(menu, inflater)
    }





}
