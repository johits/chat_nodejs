package com.example.chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chat.databinding.ActivityChatBinding

class Chat : AppCompatActivity() {

    val TAG = "Chat.kt"
    lateinit var chatAdapter : ChatAdapter
    val datas = mutableListOf<ChatData>()
    var nickName:String= ""
    var msg:String=""
    private var mBinding: ActivityChatBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("nickName") && intent.hasExtra("roomName"))
        {
            nickName = intent.getStringExtra("nickName").toString()
            var roomName = intent.getStringExtra("roomName")
            Log.e(TAG, "nickName:$nickName, roomName:$roomName")
        }
        else
        {
            Log.e(TAG, "가져온 데이터 없음")
        }

        val layoutManager = LinearLayoutManager(this)
        binding.chatRecycle.setLayoutManager(layoutManager)

        chatAdapter = ChatAdapter(this)
        binding.chatRecycle.adapter = chatAdapter


        binding.send.setOnClickListener {
            msg = binding.inputMsg.text.toString()
            datas.add(ChatData(nickName,msg))
            chatAdapter.datas = datas
            chatAdapter.notifyDataSetChanged()
            binding.inputMsg.text =null


        }

    }
}