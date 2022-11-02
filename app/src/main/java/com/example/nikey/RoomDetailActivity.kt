package com.example.nikey

import android.os.Bundle
import com.example.nikey.datas.Room
import com.example.nikey.BaseActivity
import com.example.nikey.R
import kotlinx.android.synthetic.main.activity_room_detail.*
import kotlinx.android.synthetic.main.room_list_item.*
import kotlinx.android.synthetic.main.room_list_item.nd_detail
import kotlinx.android.synthetic.main.room_list_item.nd_word

class RoomDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_detail)

        setValues()
        setupEvents()
    }

    override fun setValues() {

    }

    override fun setupEvents() {

        // roomInfo를 serializable로 받는다
        // 그냥 받은 채로 변수에 넣으면 오류가 나서 casting을 해줘야 한다
        val room = intent.getSerializableExtra("roomInfo") as Room

        // activity_room_detail.xml에 설정했던 view에 따라 매핑
        nd_word.text = "${room.nd_word}"
        nd_detail.text = "${room.nd_detail}"
        nd_ex.text = "${room.nd_ex}"
    }
}