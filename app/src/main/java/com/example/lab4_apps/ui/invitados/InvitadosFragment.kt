package com.example.lab4_apps.ui.invitados

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

import com.example.lab4_apps.R
import com.example.lab4_apps.ui.slideshow.SlideshowFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InvitadosFragment : Fragment() {

    var txt: String = ""

    companion object {
        fun newInstance() = InvitadosFragment()
    }

    private lateinit var viewModel: InvitadosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.invitados_fragment, container, false)

        val btnAgregarInvitado: FloatingActionButton = root.findViewById(R.id.btnAddInvitado)

        btnAgregarInvitado.setOnClickListener {
            val action = InvitadosFragmentDirections.actionInvitadosFragmentToAgregarInvitados()
            findNavController().navigate(action)
        }

        var nombreInvitado: String = InvitadosFragmentArgs.fromBundle(arguments!!).nombre
        var telefonoInvitado: String = InvitadosFragmentArgs.fromBundle(arguments!!).telefono
        var correoInvitado: String = InvitadosFragmentArgs.fromBundle(arguments!!).correo

        var texto: String = "Invitado 1\nNombre: $nombreInvitado\nTelefono: $telefonoInvitado\nCorreo Electronico: $correoInvitado\n\n"


        txt+=texto


        var invitados: TextView = root.findViewById(R.id.txtInvitados)
        invitados.text = txt


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InvitadosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
