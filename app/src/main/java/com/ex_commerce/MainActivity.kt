package com.ex_commerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout.HORIZONTAL
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ex_commerce.databinding.ActivityMainBinding
import com.ex_commerce.model.Category
import com.ex_commerce.model.Courses
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter
import kotlin.arrayOfNulls as kotlinArrayOfNulls

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding

        var coursesList = ArrayList<Courses>()
    var fullCoursesList=ArrayList<Courses>()

    override fun onCreate(savedInstanceState: Bundle?) {
        var index=0

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


       unit()



        val imageIdList = listOf<Int>(R.drawable.ic_java,R.drawable.ic_python,R.drawable.ic_back_end,R.drawable.ic_front_end,R.drawable.ic_unity,R.drawable.ic_full_stack)
        val titleList = resources.getStringArray(R.array.titleList)
        val dateList = resources.getStringArray(R.array.dateList)
        val levelList = resources.getStringArray(R.array.levelList)
        val colorList = resources.getStringArray(R.array.colorlList)
        val textList =resources.getStringArray(R.array.textlList)
        val categoryIdList=resources.getIntArray(R.array.categoryIdList)

        while (index < titleList.size) {
            coursesList.add(
                Courses(
                    index+1,
                    imageIdList[index],
                    titleList[index],
                    dateList[index],
                    levelList[index],
                    colorList[index],
                    textList[index],
                    categoryIdList[index]
                )
            )

            index++
            fullCoursesList.clear()
            fullCoursesList.addAll(coursesList)

            binding.apply {
                //val animationItemRecyclerView: Animation = AnimationUtils.loadAnimation(this@MainActivity ,R.anim.recycler_anim)

                rcCourses.layoutManager =
                    LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
                rcCourses.adapter = CourseAdapter(coursesList, this@MainActivity)
              //  rcCourses.adapter= ScaleInAnimationAdapter

            }

            }


        }


   public fun showCoursesByCategory(id:Int){
       coursesList.clear()
       coursesList.addAll(fullCoursesList)



       Toast.makeText(this,"${id}", Toast.LENGTH_SHORT).show()
       var filterCourses=ArrayList<Courses>()
       for(c in coursesList){
           if(c.category==id) filterCourses.add(c)

       }
          coursesList.clear()
       coursesList.addAll(filterCourses)
       binding.rcCourses.adapter?.notifyDataSetChanged()

    }
    fun unit() {
       var index=0
        val categoryTitle = arrayOf(
            getString(R.string.game),
            getString(R.string.sites),
            getString(R.string.language),
            getString(R.string.app),
            getString(R.string.other),
        )
        var categoryList = ArrayList<Category>()
        while (index < categoryTitle.size) {
            categoryList.add(Category(index + 1, categoryTitle[index]))
            index++
        }
        binding.apply {
            rcCategory.layoutManager =
                LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
            rcCategory.adapter = CategoryAdapter(categoryList, this@MainActivity)

        }
    }
    fun onClickFilter(view: View){
        coursesList.clear()
        coursesList.addAll(fullCoursesList)
        binding.rcCourses.adapter?.notifyDataSetChanged()


    }
    fun openShoppingCart(view: View){

        val titleList = resources.getStringArray(R.array.titleList)
     var   courseCart=ArrayList<String>()
        var index=0
          while (index < titleList.size){
            courseCart.add(titleList[index])
        index++}

         val intent= Intent(this@MainActivity,OrderPage::class.java).apply{
          putExtra("title",courseCart)
           //  Log.d("myLog", "${corseCart}")
         }



        startActivity(intent)
    }
    }