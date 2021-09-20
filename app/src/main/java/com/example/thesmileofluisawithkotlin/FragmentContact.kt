package com.example.thesmileofluisawithkotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentContact.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentContact : Fragment() {
    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contact, container, false)
        val etNameContact: EditText
        val etEmailContact: EditText
        val etPhone: EditText
        val etMessage: EditText
        val imgEmail: ImageView
        val imgWhat: ImageView
        val btnSend: Button
        etNameContact = view.findViewById(R.id.etNameContact)
        etEmailContact = view.findViewById(R.id.etEmailContact)
        etPhone = view.findViewById(R.id.etPhone)
        etMessage = view.findViewById(R.id.etMessage)
        imgEmail = view.findViewById(R.id.imgEmail)
        imgWhat = view.findViewById(R.id.imgWhat)
        btnSend = view.findViewById(R.id.btnSend)
        btnSend.setOnClickListener {
            val name = etNameContact.text.toString()
            val email = etEmailContact.text.toString()
            val phone = etPhone.text.toString()
            val message = etMessage.text.toString()
            if (name.isEmpty()) {
                etNameContact.error = "Campo vacío"
            } else if (email.isEmpty()) {
                etEmailContact.error = "Campo vacío"
            } else if (phone.isEmpty()) {
                etPhone.error = "Campo vacío"
            } else if (message.isEmpty()) {
                etMessage.error = "Campo vacío"
            } else {
                val builder = AlertDialog.Builder(container!!.context)
                builder.setTitle("Atención")
                builder.setMessage("Vas a enviar estos datos por correo electrónico.¿Estás seguro de ello?")
                builder.setNegativeButton("CANCELAR", null)
                builder.setPositiveButton("OK") { dialog, which ->
                    val adresses = arrayOf("rbc_1993@gmail.com")
                    val subject = "Reclamaciones"
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.setDataAndType(Uri.parse("mailto"), "text/plain")
                    intent.putExtra(Intent.EXTRA_EMAIL, adresses)
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                    intent.putExtra(Intent.EXTRA_TEXT, "\nNombre: $name\nEmail: $email\nTeléfono: $phone\nMensaje: $message")
                    startActivity(Intent.createChooser(intent, "Elige un cliente de correo"))
                }
                val dialog = builder.create()
                dialog.show()
            }
        }
        imgEmail.setOnClickListener {
            val adress = arrayOf("rbc_1993@gmail.com")
            val subject = "asunto"
            val text = ""
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, adress)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Elige un cliente de correo"))
        }
        imgWhat.setOnClickListener {
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=34697246008")
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            startActivity(intent)
        }
        return view
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentContact.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): FragmentContact {
            val fragment = FragmentContact()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}