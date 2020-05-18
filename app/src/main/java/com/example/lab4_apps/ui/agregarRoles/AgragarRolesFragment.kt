package com.example.lab4_apps.ui.agregarRoles

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.lab4_apps.R

class AgragarRolesFragment : Fragment() {

    companion object {
        fun newInstance() = AgragarRolesFragment()
    }

    private lateinit var viewModel: AgragarRolesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.agragar_roles_fragment, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AgragarRolesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menuagregarinvitados, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{

        val id = item!!.itemId
        if (id == R.id.btnSave){

            val action = AgragarRolesFragmentDirections.actionAgragarRolesFragmentToRolesFragment()
            findNavController().navigate(action)
        }

        return super.onOptionsItemSelected(item)
    }
}
