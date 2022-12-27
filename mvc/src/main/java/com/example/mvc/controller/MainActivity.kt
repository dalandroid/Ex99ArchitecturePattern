package com.example.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvc.model.Item
import com.example.mvc.model.ItemModel
import com.mrhi2022.mvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 1. MVC [Model - View - Controller ] - 각파일에 코드별로 역할을 구분하여 작성하는 것이 특징
    //  1) Model        - 데이터를 저장하는 클래스나 데이터를 DB/네트워크/파일 등에서 불러오거나 저장하는 등의 작업을 하는 코드를 작성한 파일들
    //  2) View         - 사용자가 볼 화면을 구현하는 목적의 코드가 있는 파일들 [ activity_main.xml, fragment_my.xml ]
    //  3) Controller   - view 와 model 사이에서 연결하는 역할, 클릭같은 이벤트를 처리하며 뷰의 요청에 따라 model 데이터를 제어하여 뷰에게 보여주는 역할 [ Activity, Fragment (이 둘은 view 의 역할도 함) ]

    // app 모듈에서 만든 Flat Design 에서 MainActivity.kt에 작성한 코드들을 크게 3가지 역할로 구분해보면..
    // #1 화면구현              : view 의 역할
    // #2 클릭이벤트 처리        : controller 의 역할
    // #3 sharedPreferences 를 이용하여 데이터를 디바이스에 영구적으로 저장하고 불러오는 Business Logic    : model 의 역할

    // 역할별 파일들에 대한 구분을 쉽게하기 위해 java 폴더 안에 파일의 역할별로 package 를 나누어 제작

    // # view 참조변수
    lateinit var binding:ActivityMainBinding

    // # model 참조변수
    lateinit var model:ItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // #model 객체 생성
        model= ItemModel(this)

        // #view 역할 -activity_main.xml 이 뷰의 역할을 하는 파이지만, MainActivity.kt 에서 설정하지않으면 보이지않으므로, 사실 액티비티는 뷰의 역할도 하고있음
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // #controller 역할 - 클릭이벤트를 처리(사용자 이벤트) view 와 model 을 연결하는 작업
        binding.btnSave.setOnClickListener {
            // 모델역할 객체에게 데이터 저장을 요청, 뷰로부터 사용자 데이터를 받아와서
            model.saveData(binding.etName.text.toString(), binding.etEmail.text.toString())
        }

        binding.btnLoad.setOnClickListener {
            // 모델로부터 데이터를 받아와서 뷰에게 보여주도록 요청
            val item:Item=model.loadData()
            binding.tv.text="${item.name}-${item.email}"
        }


    }
}

// MVC 장점
// 1. 데이터를 제어하는 코드가 Activity/Fragment 클래스안에 모두 있지않아서 간결해짐
// 2. 역할별로 코드가 분리되어있어서 가독성이 좋음
// 3. model 역할을 하는 클래스안에 어떤 view도 참조하고있지 않기에 view 변경해도 model은 변경될 필요가 없음

// MVC 단점
// 1. Android에서는 view 와 controller 의 완전부리가 어려움. Activity, Fragment 는 view 역할이면서 controller 역할을 하기도 함
// 2. view 에서 model 객체를 참조하고 있어서 model이 변경이 생기면 view 에도 영향을 받음.
// 3. 규모가 커지면 controller 역할을 하는 Activity 의 코드가 비대해짐