 package com.ex_commerce

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ex_commerce.databinding.ActivityCoursePageBinding
import com.ex_commerce.model.Order

 class CoursePage : AppCompatActivity() {
    lateinit var binding:ActivityCoursePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCoursePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
              coursePageBackground.setBackgroundColor(Color.parseColor(intent.getStringExtra("backGraund")))
             courseCouteiner.setBackgroundColor(Color.parseColor(intent.getStringExtra("backGraund")))
             coursePageImage.setImageResource(intent.getIntExtra("image",0))
             courseName.text=intent.getStringExtra("title")
             coursePageData.text=intent.getStringExtra("date")
             coursePageLevel.text=intent.getStringExtra("level")
              coursePageDescription.text=intent.getStringExtra("text")


        }





    }
     fun addTocart(view: View){
         var item_Id=intent?.getIntExtra("id",1)
         Order.items_id.add(item_Id!!)
         Toast.makeText(this,"Добавлено",Toast.LENGTH_LONG).show()
     }
}