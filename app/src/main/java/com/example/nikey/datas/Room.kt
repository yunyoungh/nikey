package com.example.nikey.datas

import java.io.Serializable

// Listview가 뿌려줄 데이터들을 묶어서 표현하는 데이터 클래스 생성
class Room (
    // 클래스의 생성자에서 변수들을 나열해서 클래스가 가져야하는 정보 항목들로 설정
//    val nd_id: Int,
    val nd_word: String,
    val nd_detail: String,
    val nd_ex: String,
) : Serializable {
}