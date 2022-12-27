package com.mrhi2022.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    // 1. MVC [ Model - View - Controller ] - 각 파일의 코드별로 역할을 구분하여 작성하는 것이 특징
    //   1) Model        - 데이터를 저장하는 클래스나 데이터를 DB/네트워크/파일 등에서 불러오거나 저장하는 등의 작업을 하는 코드를 작성하는 파일들 [ex. Item 클래스, Person 클래스, Retrofit 작업 클래스, DB작업 클래스...]
    //   2) View         - 사용자가 볼 화면을 구현하는 목적의 코드가 있는 파일들 [ activity_main.xml, fragment_my.xml ]
    //   3) Controller   - 뷰와 모델 사이에서 연결하는 역할, 클릭 같은 이벤트를 처리하며 뷰의 요청에 따라 model 데이터를 제어하여 뷰에게 보여주는 역할 [ Activity, Fragment (이 둘은 view의 역할도 함) ]

    // app 모듈에서 만든 Flat Design 에서 MainActivity.kt에 작성한 코드들을 크게 3가지 역할로 구분해보면..
    //  #1 화면구현                                                                                               -- view 역할
    //  #2 클릭이벤트 처리                                                                                         -- controller 역할
    //  #3 SharedPreferences 를 이용하여 데이터를 디바이스에 영구적으로 저장하고 불러오는 Business Logic 을 가진 기능      --  model 역할

    // 역할별 파일들에 대한 구분을 쉽게하기 위해 java폴더 안에 파일의 역할별로 package 를 나누어 제작해보기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}