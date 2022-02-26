 package com.ex_commerce

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ex_commerce.databinding.CourseItemBinding
import com.ex_commerce.model.Courses
import android.app.Activity as Activity

class CourseAdapter(courseList:ArrayList<Courses>,context:Context) : RecyclerView.Adapter<CourseAdapter.CoursesViewHolder>() {
     var coursesListR=courseList
    var contextR=context




    class CoursesViewHolder(view: View):RecyclerView.ViewHolder(view){
        val binding= CourseItemBinding.bind(view)
        fun bind(course: Courses,context: Context)= with(binding){

                 courseCouteiner.setBackgroundColor(Color.parseColor(course.color))
                 courseImage.setImageResource(course.img)
                  courseTitle.text=course.title
                  courseData.text=course.date
                   courseLevel.text=course.level
                   val courseText=course.text
                   val courseCategory=course.category
                     val courseId=course.id

                 itemView.setOnClickListener {
                   /*  Toast.makeText(context, "presssed ${courseTitle.text}", Toast.LENGTH_SHORT)
                         .show()*/



                     val i = Intent(context, CoursePage::class.java).apply {
                         putExtra("backGraund", course.color)
                         putExtra("image", course.img)
                         putExtra("title", course.title)
                         putExtra("date", course.date)
                         putExtra("level", course.level)
                         putExtra("text",course.text)
                         putExtra("category",courseCategory)
                         putExtra("id",course.id)


                     }

                     val options=ActivityOptions.makeSceneTransitionAnimation(context as Activity?,
                         binding.courseImage , "course_image")

                     context.startActivity(i, options.toBundle())

                 }



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item,parent,false)
        return CourseAdapter.CoursesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        holder.bind(coursesListR[position],contextR )
    }

    override fun getItemCount(): Int {
        return coursesListR.size
    }
   /* public fun addCourse(course: Courses){
        coursesListR.add(course)
        notifyDataSetChanged()
    }
*/

}