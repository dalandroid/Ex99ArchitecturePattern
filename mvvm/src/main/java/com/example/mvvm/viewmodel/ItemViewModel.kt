package com.example.mvvm.viewmodel

import android.content.Context
import androidx.databinding.ObservableField
import com.example.mvvm.model.Item
import com.example.mvvm.model.ItemModel

class ItemViewModel constructor(context:Context){
    // View 와 연결할 Model 역할 클래스 참조변수
    var itemModel:ItemModel=ItemModel(context)

    // 값변경이 관찰되는 멤버변수
    var model:ObservableField<Item> = ObservableField()

    // 초기화 블럭
    init {
        model.set(Item("aa","111"))
    }

    // EditText 에 글씨가 변경될때마다 그 글씨를 저장하는 변수와 기능을 만들기
    var name:String=""
    var email:String=""

    fun changeName(name:String){
        this.name=name
    }

    fun changeEmail(email:String){
        this.email=email
    }

    // view 의 클릭이벤트 처리 2개
    fun clickedSave(){
        itemModel.saveData(name,email)
    }

    fun clickedLoad(){
        var item:Item= itemModel.loadData()
        model.set(item)
    }
}