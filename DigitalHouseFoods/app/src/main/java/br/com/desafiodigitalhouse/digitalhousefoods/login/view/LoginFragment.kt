package br.com.desafiodigitalhouse.digitalhousefoods.login.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.register.view.RegisterActivity
import br.com.desafiodigitalhouse.digitalhousefoods.restaurant.view.RestaurantListActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
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
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        val inputLayoutEmailLogin = view.findViewById<TextInputLayout>(R.id.inputLayoutEmailLogin)
        val edtEmailLogin = view.findViewById<TextInputEditText>(R.id.edtEmailLogin)

        val inputLayoutPasswordLogin = view.findViewById<TextInputLayout>(R.id.inputLayoutPasswordLogin)
        val edtPasswordLogin = view.findViewById<TextInputEditText>(R.id.edtPasswordLogin)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnNavigateToRegisterScreen = view.findViewById<Button>(R.id.btnNavigateToRegisterScreen)

        edtEmailLogin.setText("")
        edtPasswordLogin.setText("")

        btnLogin.setOnClickListener {

            var isValid = true

            val email = edtEmailLogin.text.toString()
            val password = edtPasswordLogin.text.toString()

            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            if (!email.matches(emailPattern.toRegex())) {
                inputLayoutEmailLogin.error = getString(R.string.email_error)
                isValid = false
            } else {
                inputLayoutEmailLogin.error = null
            }

            if (password.length < 6) {
                inputLayoutPasswordLogin.error = getString(R.string.password_error)
                isValid = false
            } else {
                inputLayoutPasswordLogin.error = null
            }

            if(isValid){
                val intent = Intent(view.context, RestaurantListActivity::class.java)
                startActivity(intent)
            }
        }

        btnNavigateToRegisterScreen.setOnClickListener {
            val intent = Intent(view.context, RegisterActivity::class.java)
            startActivity(intent)
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}