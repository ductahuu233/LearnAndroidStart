package com.example.learnandroidstart.bai2

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.learnandroidstart.R
import com.example.learnandroidstart.viewmodel.DataViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var email : EditText
    private lateinit var repassword : EditText
    private lateinit var register : Button
    private lateinit var viewModel: DataViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        email = findViewById(R.id.email)
        repassword = findViewById(R.id.repassword)
        register = findViewById(R.id.signupbtn)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        viewModel.data.observe(this) { result ->
            viewModel.setData(username.text.toString())
            viewModel.setData(email.text.toString())
            viewModel.setData(password.text.toString())
            viewModel.setData(repassword.text.toString())
        }

        register.setOnClickListener {
            if (username.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty() && repassword.text.toString().isNotEmpty()){
                if (password == repassword){
                    val intent = Intent(this,LoginActivity::class.java)
                    Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
                    val bundle = Bundle()
                    bundle.putString("username",username.text.toString())
                    bundle.putString("password",username.text.toString())
                    intent.putExtras(bundle)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Mày nhập mật khẩu không khớp,nhập lại đi", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}