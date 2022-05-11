package com.example.mobilecomputing

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mobilecomputing.databinding.ActivityMainAlterBinding
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSub.setOnClickListener {
            val intent: Intent = Intent(this, SubActivity::class.java).apply{
                putExtra("next", "level")
            }
            intent.putExtra("num",30)
            intent.putExtra("edit",binding.editText.text.toString())
            startActivity(intent)
        }
    }
}

//
//class MyCustomView(context: Context): View(context){
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.isAntiAlias = true
//        paint.color = Color.GRAY
//        canvas.drawLine(20f, 20f, 600f, 20f, paint)
//
//        paint.strokeWidth = 5f
//        paint.style = Paint.Style.FILL
//        val rect1 = Rect(30,130,30+100, 130+100)
//        canvas.drawRect(rect1, paint)
//
//        paint.style = Paint.Style.STROKE
//        val rect2 = Rect(140,130,140+100, 130+100)
//        canvas.drawRect(rect2, paint)
//
//        paint.style = Paint.Style.FILL_AND_STROKE
//        val rect3 = Rect(300,130,300+100, 130+100)
//        canvas.drawRect(rect3, paint)
//
//        paint.style = Paint.Style.STROKE
//        val rect4 = RectF(420f,130f,420f+100f, 130f+100f)
//        canvas.drawRoundRect(rect4, 10f, 10f, paint)
//
//        val rect5 = RectF(550f,130f,550f+100f, 130f+100f)
//        canvas.drawRoundRect(rect5, 50f, 50f, paint)
//        canvas.drawCircle(680f, 130f, 50f, paint)
//        canvas.drawPoint(680f, 130f, paint)
//
//        path1.moveTo(20f,300f)
//        path1.lineTo(20f+100f, 300f+100f)
//        path1.lineTo(20f+200f, 300f)
//        path1.lineTo(20f+300f, 300f+100f)
//        path1.lineTo(20f+400f, 300f)
//        canvas.drawPath(path1, paint)
//
//        var len = 100f
//        var tx = 20f
//        var ty = 600f
//        path2.moveTo(tx,ty)
//        while(len>10f){
//            for(i in (1..4)){
//                tx+=dx[i]*len
//                ty+=dy[i]*len
//                path2.lineTo(tx,ty)
//                if(i%2==0) len*=0.9f
//            }
//        }
//        canvas.drawPath(path2, paint)
//    }
//    private val path1: Path = Path()
//    private val path2: Path = Path()
//    private val dx = arrayOf(0,1,0,-1,0)
//    private val dy = arrayOf(0,0,1,0,-1)
//}