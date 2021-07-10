package com.example.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


 private var mBinding: ActivityMainBinding? = null

//매번 null 체크를 할 필요 없이 바인딩 변수 재 선언
 private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrance.setOnClickListener {
            var nickName = binding.nickName.text.toString()
            var roomName = binding.roomName.text.toString()
            val intent = Intent(this, Chat::class.java)
            intent.putExtra("roomName", roomName)
            intent.putExtra("nickName", nickName)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}