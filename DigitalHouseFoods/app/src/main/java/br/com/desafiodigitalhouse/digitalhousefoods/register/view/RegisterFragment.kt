package br.com.desafiodigitalhouse.digitalhousefoods.register.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.login.view.LoginActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val inputLayoutNameRegister = view.findViewById<TextInputLayout>(R.id.inputLayoutNameRegister)
        val edtNameRegister = view.findViewById<TextInputEditText>(R.id.edtNameRegister)

        val inputLayoutEmailRegister = view.findViewById<TextInputLayout>(R.id.inputLayoutEmailRegister)
        val edtEmailRegister = view.findViewById<TextInputEditText>(R.id.edtEmailRegister)

        val inputLayoutPasswordRegister = view.findViewById<TextInputLayout>(R.id.inputLayoutPasswordRegister)
        val edtPasswordRegister = view.findViewById<TextInputEditText>(R.id.edtPasswordRegister)

        val inputLayoutRepeatPasswordRegister = view.findViewById<TextInputLayout>(R.id.inputLayoutRepeatPasswordRegister)
        val edtRepeatPasswordRegister = view.findViewById<TextInputEditText>(R.id.edtRepeatPasswordRegister)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val name = edtNameRegister.text.toString()
            val email = edtEmailRegister.text.toString()
            val password = edtPasswordRegister.text.toString()
            val repeatPassword = edtRepeatPasswordRegister.text.toString()

            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
            var isValid = true

            if (name.isEmpty()) {
                inputLayoutNameRegister.error = getString(R.string.name_error)
                isValid = false
            } else inputLayoutNameRegister.error = null

            if (!email.matches(emailPattern.toRegex())) {
                inputLayoutEmailRegister.error = getString(R.string.email_error)
                isValid = false
            } else inputLayoutEmailRegister.error = null

            if (password != repeatPassword) {
                inputLayoutPasswordRegister.error = getString(R.string.passwords_error)
                inputLayoutRepeatPasswordRegister.error = getString(R.string.passwords_error)
                isValid = false
            } else {

                if (password.length < 6) {
                    inputLayoutPasswordRegister.error = getString(R.string.password_error)
                    isValid = false
                } else inputLayoutPasswordRegister.error = null

                if (repeatPassword.length < 6) {
                    inputLayoutRepeatPasswordRegister.error = getString(R.string.password_error)
                    isValid = false
                } else inputLayoutRepeatPasswordRegister.error = null

            }

            if(isValid) {
                val intent = Intent(view.context, LoginActivity::class.java)
                intent.putExtra("ACCOUNT_CREATED", 1)
                startActivity(intent)
                activity?.finish()
            }

        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}