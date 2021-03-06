package br.com.desafiodigitalhouse.digitalhousefoods.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.desafiodigitalhouse.digitalhousefoods.R
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        manager = supportFragmentManager
        addFragment(LoginFragment())

        if(intent.getIntExtra("ACCOUNT_CREATED", 0) == 1){
            val view = findViewById<View>(R.id.mainContainerLogin)
            Snackbar.make(view, R.string.account_created, Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun addFragment(fragment: Fragment){
        val viewId = R.id.mainContainerLogin
        val transition = manager.beginTransaction()
        transition.replace(viewId, fragment)
        transition.commit()
    }

}