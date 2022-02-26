package com.ex_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.ex_commerce.databinding.ActivityOrderPageBinding
import com.ex_commerce.model.Courses
import com.ex_commerce.model.Order

class OrderPage : AppCompatActivity() {
    lateinit private var binding:ActivityOrderPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOrderPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val titleList = intent.getStringArrayListExtra("title")
        Log.d("myLog", "${Order.items_id}")
        var index=0
        var titleListFinal=ArrayList<String>()
            titleListFinal.clear()
     for(index in titleList?.indices!!){
            if(Order.items_id.contains(index+1)) titleListFinal.add(titleList[index])

     }
        Log.d("myLog", "${Order.items_id}")
        Log.d("myLog", "${titleList}")

        binding.orderListPage.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,titleListFinal)
    }

    override fun onDestroy() {
        super.onDestroy()
        Order.items_id.clear()
    }
}