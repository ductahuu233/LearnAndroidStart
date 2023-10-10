package com.example.learnandroidstart.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.learnandroidstart.R
import com.example.learnandroidstart.viewmodel.DataViewModel

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvCanMua : TextView
    private lateinit var edtInput : EditText
    private lateinit var btnSend : Button
    private lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tvCanMua = findViewById(R.id.tvTenSanPham)
        edtInput = findViewById(R.id.edtInput)
        btnSend = findViewById(R.id.btnSend)

        viewModel = ViewModelProvider(this)[DataViewModel::class.java]

        val result = intent.getStringExtra("name")
        tvCanMua.text = result

        btnSend.setOnClickListener {
            val price = edtInput.text.toString().trim()
            viewModel.setData(price)
            val intent = Intent()
            intent.putExtra("price",price)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}