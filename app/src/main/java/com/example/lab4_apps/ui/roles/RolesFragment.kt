package com.example.lab4_apps.ui.roles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.lab4_apps.R
import com.example.lab4_apps.ui.invitados.InvitadosFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RolesFragment : Fragment() {

    companion object {
        fun newInstance() = RolesFragment()
    }

    private lateinit var viewModel: RolesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.roles_fragment, container, false)

        val btnAgregarRol: FloatingActionButton = root.findViewById(R.id.btnAddRol)

        btnAgregarRol.setOnClickListener {
            val action = RolesFragmentDirections.actionRolesFragmentToAgragarRolesFragment()
            findNavController().navigate(action)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RolesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
