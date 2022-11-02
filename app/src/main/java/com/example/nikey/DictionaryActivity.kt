package com.example.nikey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nikey.datas.Room
import com.example.nikey.RoomDetailActivity
import com.example.nikey.SearchActivity
import com.example.nikey.adapters.RoomAdapter
import kotlinx.android.synthetic.main.activity_dictionary.*

class DictionaryActivity : BaseActivity() {
    // 액티비티에서 실제 목록을 담아줄 ArrayList를 만들고 실제 데이터들을 담기
    val mRoomList = ArrayList<Room>()

    // 만들어둔 Adapter 클래스를 액티비티에 있는 리스트뷰와 연결
    lateinit var mRoomAdapter: RoomAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

//        // 검색페이지로 이동하는 버튼이벤트
//        searchbutton.setOnClickListener {
//            val intent = Intent(this, SearchActivity::class.java)
//            startActivity(intent)
//        }

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        // 메인화면의 이벤트관련 코드를 모아두는 장소
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄이 눌리는 시점의 이벤트
        roomListView.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedRoom = mRoomList[i]
            // 선택된 목록정보를 가져왔으면 이제 화면 이동
            val myIntent = Intent(mContext, RoomDetailActivity::class.java)
            // 정보를 담아주기
            myIntent.putExtra("roomInfo", clickedRoom)
            // 화면 전환
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        // 실제로 뿌려줄 데이터들 ArrayList 변수에 추가
        // 단어, 상세
        mRoomList.add(Room("존맛탱", "매우 맛있음을 뜻하는 ‘존맛’ 에 강조하는 의미로‘탱’을 붙인 말.", "이 떡볶이 존맛탱 / JMT, 존맛탱구리"))
        mRoomList.add(Room("어쩔티비", "어쩌라고 티비나 봐에서 시작된 어쩌라고 + 가전제품의 줄임말.", "응 어쩔 세탁기? 저쩔 스타일러!"))
        mRoomList.add(Room("캘박", "확정된 일정을 캘린더에 박제해서 잊지 않겠다는 뜻.", "홍대입구 8번 출구 오후 5시 이번주 수요일 캘박한다? "))
        mRoomList.add(Room("낄끼빠빠", "낄 때 끼고 빠질 때 빠져라", "낄끼빠빠"))
        mRoomList.add(Room("답정너", "답은 정해져 있고 너는 대답만 해라", "너 답정너하고 있는 거지"))
        mRoomList.add(Room("비담", "비주얼 담당", "우리 집의 비담은 나야"))
        mRoomList.add(Room("취존", "취향 존중", "민초 취존해줘"))
        mRoomList.add(Room("할많하않", "할말은 많지만 하지 않겠다.", "할많하않"))
        mRoomList.add(Room("개이득", "개-: 강조 표현 + 이득", "아싸 개이득"))
        mRoomList.add(Room("주린이", "주식 + -린이(어린이에서 파생)", "나 주식 시작했어. 나도 이제 주린이야."))
        mRoomList.add(Room("뉴비", "New + Baby, 새로운 것에 입문하는 사람", "너 이 게임 뉴비야?"))
        mRoomList.add(Room("딸바보", "딸만 바라보는 바보", "형은 딸이 그렇게 좋아? 딸바보 다 됐네"))
        mRoomList.add(Room("ㅇㅋ", "‘오키’에서 자음만 작성한 것, 오키 = okay, 동의하는 표현", "ㅇㅋ. 이따가봐."))
        mRoomList.add(Room("댕댕이", "멍멍이의 변형 인터넷 용어로 멍과 댕의 모양이 비슷해서 만들어진 말", "저 댕댕이 귀엽다"))


        // Adapter 클래스를 객체화
        // BaseActivity의 mContext, 어떤 리스트를 보여줄건지, 목록변수릐 이름
        // Lateinit var로 초기화를 미뤘던 변수의 실제 초기화 코드
        // (mContext=어떤화면에서?, room_list_item=어떤모양으로그릴지?, mRoomList=어떤목록?)
        mRoomAdapter = RoomAdapter(mContext, R.layout.room_list_item, mRoomList)

        // 객체화된 adapter변수를 리스트뷰의 어댑터로 지정
        // 실제 목록을 리스트뷰에 뿌려준다.
        roomListView.adapter = mRoomAdapter
    }
}