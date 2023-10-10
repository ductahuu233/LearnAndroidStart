package com.example.learnandroidstart.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import com.example.learnandroidstart.R
import com.example.learnandroidstart.viewmodel.DataViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var edtInput : EditText
    private lateinit var btnSend : Button
    private lateinit var tvPrice : TextView
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    //dùng viewModel để lưu dữ liệu đã có
    private lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtInput = findViewById(R.id.edtInputMua)
        btnSend = findViewById(R.id.btnSendGui)
        tvPrice = findViewById(R.id.tvPriceGia)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)

        viewModel.data.observe(this) { result ->
            tvPrice.text = result
            viewModel.setData(edtInput.text.toString())
        }

        //đăng ký activityResultLauncher
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                val resultData = intent?.getStringExtra("price")
                tvPrice.text = resultData
            }
        }

        btnSend.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name",edtInput.text.toString().trim())
            activityResultLauncher.launch(intent)
            //startActivity(intent) : khi dùng activityResultLaucher không được dùng startActivity
        }
    }
}