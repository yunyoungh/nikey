package com.example.nikey.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.nikey.R
import com.example.nikey.datas.Room

// 2) 상속받은 뒤, Adapter 주 생성자에서 필요한 재료 받고
class RoomAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: List<Room>

// 1) ArrayAdapater<Room(뿌려줄 데이터클래스)>()를 상속받고
// 3) ArrayAdapter<Room>(mContext, resId, mList) 생성자에서 필요한 재료 순으로 부모에게 넘기기
) : ArrayAdapter<Room>(mContext, resId, mList) {

    // 4) 객체로 변환해주는 변수를 멤버변수로 생성
    val inf = LayoutInflater.from(mContext)

    // 5) getView 오버라이딩
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // 6) convertView 변수를 tempRow에 옮겨닮아서 null인경우 새로운 inflate해서 담기
        // 이렇게 사용하는 이유는 listView를 재사용성하기 위해
        var tempRow = convertView
        if(tempRow == null) {
            tempRow = inf.inflate(R.layout.room_list_item, null)
        }

        // tempRow는 맞지만 null은 절대 아니다 (= !!)
        val row = tempRow!!

        // 실제 데이터가 있는 목록이 반영되도록 Adapter 클래스의 getView 함수를 수정
        // 뿌려줄 row 안에 있는 텍스트 뷰 변수로 담기
        val data = mList[position]
        val word = row.findViewById<TextView>(R.id.nd_word)
        val detail = row.findViewById<TextView>(R.id.nd_detail)

        word.text = data.nd_word
        detail.text = data.nd_detail

        return row
    }

}
