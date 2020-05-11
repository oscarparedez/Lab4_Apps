package com.example.lab4_apps.ui.agregarInvitados

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.lab4_apps.R
import kotlinx.android.synthetic.main.agregar_invitados_fragment.*

class AgregarInvitados : Fragment() {
//    var arrayListNombres:ArrayList<String> = arrayListOf()
//    var arrayListTelefonos:ArrayList<String> = arrayListOf()
//    var arrayListEmails:ArrayList<String> = arrayListOf()

    companion object {
        fun newInstance() = AgregarInvitados()
    }

    public lateinit var btnGuardar: MenuItem

    private lateinit var viewModel: AgregarInvitadosViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val root = inflater.inflate(R.layout.agregar_invitados_fragment, container, false)

        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgregarInvitadosViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menuagregarinvitados, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        val nombre= inputNombre.text.toString()
        val email= inputCorreo.text.toString()
        val telefono= inputTelefono.text.toString()

        val id = item!!.itemId
        if (id == R.id.btnSave){

            val action = AgregarInvitadosDirections.actionNavAgregarInvitadosToNavInvitados(nombre, email, telefono)
            findNavController().navigate(action)
        }

        return super.onOptionsItemSelected(item)
    }

}
