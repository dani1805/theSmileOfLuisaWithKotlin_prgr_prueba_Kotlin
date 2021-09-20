package com.example.thesmileofluisawithkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesmileofluisawithkotlin.adapters.MaskAdapter
import com.example.thesmileofluisawithkotlin.models.Mask
import com.example.thesmileofluisawithkotlin.utills.CustomItemClick
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMask.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMask : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var fragmentAdapterMask: MaskAdapter? = null
    private lateinit var rvFragmentMask: RecyclerView

    private lateinit var listener : CustomItemClick

    var mask = java.util.ArrayList<Mask?>()
    var maskCart = java.util.ArrayList<Mask?>()
    var maskFav = java.util.ArrayList<Mask?>()

    private val list = ArrayList<Mask>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_mask, container, false)

        var spinner : Spinner = view.findViewById(R.id.spMask)

        var btnCart : Button = view.findViewById(R.id.btnCart)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.spCollection,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {

                if (position == 0) {

                    doMaskPrint()

                } else if (position == 1) {

                    doMaskEspecial()

                } else if (position == 2) {

                    doMaskSpring()

                } else if (position == 3) {

                    doMaskSmoothies()

                } else {

                    doMaskColours()

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        rvFragmentMask = view.findViewById(R.id.rvMask)

        rvFragmentMask.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(context, 2)
        rvFragmentMask.layoutManager = layoutManager

        btnCart.setOnClickListener {
            val intent = Intent(context, ListBuyActivity::class.java)
            intent.putExtra("maskC", maskCart)
            Log.i("hola", "hola")
            startActivity(intent)
        }

        fragmentAdapterMask = MaskAdapter(mask, view.context, object : CustomItemClick {
            override fun onItemClick(position: Int) {
                maskCart.add(mask[position])
                Log.i("lista", mask.toString())

                val toast = Toast.makeText(context, "Mascarilla añadida al carrito", Toast.LENGTH_SHORT)
                toast.show()

            }

            override fun onLongItemClick(position: Int) {
                maskFav.add(mask[position])
                Log.i("fav", maskCart.toString())
                
                val toast = Toast.makeText(context, "Mascarilla añadida al listado de favoritos", Toast.LENGTH_SHORT)
                toast.show()

            }
        })

        rvFragmentMask.adapter = fragmentAdapterMask

        return view
    }

    private fun doMaskPrint() {

        Log.i("posicion", maskCart.toString())

        mask.clear()
        mask.add(Mask("Mascarilla Print", "Colección Mascarillas Print", 7, R.drawable.animal_print_2))
        mask.add(Mask("Mascarilla Print", "Colección Mascarillas Print", 5, R.drawable.animal_print_4))
        fragmentAdapterMask!!.notifyDataSetChanged()

    }

    private fun doMaskEspecial() {

        mask.clear()
        mask.add(Mask("Mascarillas especiales", "Colección eventos especiales", 5, R.drawable.especial))
        mask.add(Mask("Mascarillas especiales", "Colección eventos especiales", 4, R.drawable.especial_2))
        mask.add(Mask("Mascarillas especiales", "Colección eventos especiales", 2, R.drawable.especial_3))
        fragmentAdapterMask!!.notifyDataSetChanged()
    }

    private fun doMaskSpring() {

        mask.clear()
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5, R.drawable.flores))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5, R.drawable.flores_2))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 3, R.drawable.flores_3))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 4, R.drawable.flores_4))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 3, R.drawable.flores_5))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 7, R.drawable.flores_6))
        mask.add(Mask("Mascarillas Spring", "Colección Mascarillas Spring", 5, R.drawable.flores_8))
        fragmentAdapterMask!!.notifyDataSetChanged()

    }

    private fun doMaskSmoothies() {

        mask.clear()
        mask.add(Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa))
        mask.add(Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa_1))
        mask.add(Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa_2))
        mask.add(Mask("Mascarillas lisas", "Colección mascarillas lisas para ellos y ellas", 4, R.drawable.lisa_3))
        fragmentAdapterMask!!.notifyDataSetChanged()

    }

    private fun doMaskColours() {

        mask.clear()
        mask.add(Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 4, R.drawable.lunares_1))
        mask.add(Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 9, R.drawable.lunares_2))
        mask.add(Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 6, R.drawable.lunares_3))
        mask.add(Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 6, R.drawable.lunares_4))
        mask.add(Mask("Mascarillas de lunares", "Colección de mascarillas de lunares", 3, R.drawable.lunares_5))
        fragmentAdapterMask!!.notifyDataSetChanged()

    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menuInflater.inflate(R.menu.other_toolbar, menu)
        return true
    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHome().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}