package com.example.learnandroidstart.bai2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.learnandroidstart.R
import com.example.learnandroidstart.viewmodel.DataViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var loginBtn : Button
    private lateinit var btnSwapRegister : Button
    private lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginbtn)
        btnSwapRegister = findViewById(R.id.btnSwapRegister)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        viewModel.data.observe(this) { result ->
            viewModel.setData(username.text.toString())
            viewModel.setData(password.text.toString())
        }

        loginBtn.setOnClickListener {
            val result = intent.extras
            if (result != null){
                val userName = result.getString("username")
                val passWord = result.getString("password")
                val checkUsername : Boolean = userName.equals(username.text.toString())
                val checkPassword : Boolean = passWord.equals(username.text.toString())

                if (checkUsername && checkPassword){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Login UnSuccessful", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnSwapRegister.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}