package br.com.desafiodigitalhouse.digitalhousefoods.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.desafiodigitalhouse.digitalhousefoods.R
import br.com.desafiodigitalhouse.digitalhousefoods.login.view.LoginFragment

class RegisterActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        manager = supportFragmentManager
        addFragment(RegisterFragment())

    }

    private fun addFragment(fragment: Fragment){
        val viewId = R.id.mainContainerRegister
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

}