package miin.learning.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import miin.learning.R
import miin.learning.model.User
import miin.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            val user = User(email, password)

            if (user.isValidEmail() && user.isValidPassword()) {
                binding.errorText.apply {
                    visibility = View.VISIBLE
                    text = "Login Success"
                    setTextColor(resources.getColor(R.color.design_default_color_primary_variant))
                }
            } else {
                binding.errorText.apply {
                    visibility = View.VISIBLE
                    text = "Login Failed"
                    setTextColor(resources.getColor(R.color.design_default_color_error))
                }
            }
        }
    }
}
