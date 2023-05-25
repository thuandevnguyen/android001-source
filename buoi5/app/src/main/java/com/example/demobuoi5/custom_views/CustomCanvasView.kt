package com.example.demobuoi5.custom_views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.example.demobuoi5.R

class CustomCanvasView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
  @ColorInt
  private var filledColor: Int = Color.BLACK
  private val paint: Paint

  init {
    context.obtainStyledAttributes(attrs, R.styleable.CustomCanvasView).use { typedArray ->
      filledColor = typedArray.getColor(R.styleable.CustomCanvasView_filledColor, Color.BLACK)
    }
    paint = Paint(Paint.ANTI_ALIAS_FLAG)
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)

    paint.color = filledColor

    canvas.drawCircle(
      /* cx = */ width.toFloat() / 2,
      /* cy = */ height.toFloat() / 2,
      /* radius = */ minOf(width, height).toFloat() / 2,
      /* paint = */ paint
    )
  }

  fun setFilledColor(@ColorInt newColor: Int) {
    this.filledColor = newColor
    invalidate() // can draw lai
  }
}