package cn.kisoo.forest.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

class ImageViewWithCorner(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : ImageView(context, attrs, defStyleAttr, defStyleRes) {

    constructor(context: Context) : this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    init {
        initPaints()
    }

    val mPaint = Paint()

    private fun initPaints() {
        mPaint.isAntiAlias = true
        mPaint.flags = Paint.ANTI_ALIAS_FLAG
        mPaint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }
}