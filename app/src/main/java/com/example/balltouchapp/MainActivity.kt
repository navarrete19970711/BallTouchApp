package com.example.balltouchapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_main)
        // 2)　新しいクラスを表示する
        val ballView = BallView(this)
        setContentView(ballView)
    }

    // 1) viewを継承したクラス
    class BallView(context: Context?) : View(context) {
        private var paint:Paint = Paint()
        private var circleX:Float = 550F
        private var circleY:Float = 550F

        // 3) onDrawで描画の準備
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            canvas.drawColor(Color.RED)

            // 4) ペイントする色の指定と、丸い図形
            paint.color = Color.YELLOW
            canvas.drawCircle(circleX,circleY,50F,paint)

        }

        // 5) 画面タッチ
        override fun onTouchEvent(event: MotionEvent?): Boolean {
            //タッチポジション
            circleX = event!!.x
            circleY = event.y
            invalidate()

            //return super.onTouchEvent(event)
            return true

        }

    }

}

