package com.example.lab4_apps.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lab4_apps.R
import com.example.lab4_apps.ui.gallery.GalleryFragment
import com.example.lab4_apps.ui.sampledata.ResultadoFragmentArgs
import com.example.lab4_apps.ui.slideshow.SlideshowFragment


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        var textoResultado : String = HomeFragmentArgs.fromBundle(arguments!!).text

        Toast.makeText(activity, textoResultado, Toast.LENGTH_SHORT).show()

        val btnIniciar: Button = root.findViewById(R.id.btnIniciar)

        btnIniciar.setOnClickListener(){
            findNavController().navigate(R.id.nav_slideshow)
        }

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val action = HomeFragmentDirections.actionNavHomeToNavGallery()
        findNavController().navigate(action)
        return super.onOptionsItemSelected(item)
    }
    
}
