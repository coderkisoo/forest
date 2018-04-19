package cn.kisoo.forest.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import cn.kisoo.forest.R
import com.orhanobut.logger.Logger


/**
 * Created by kangqizhou on 2018/4/6.
 */
public class CircleWidget(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : View(context, attrs, defStyleAttr, defStyleRes) {

    val mBottomPaint = Paint()//画底部的圆环
    val mTopPaint = Paint()//画顶部圆环
    val mTopPointPaint = Paint()//顶部圆点
    val mTopMinPaint = Paint()//画顶部圆环
    val mTopMinPointPaint = Paint()//顶部圆点
    var mBottomColor = Color.GREEN//底部颜色
    var mTopColor = Color.BLUE//顶部颜色
    var mMin_top_color = Color.YELLOW//顶部颜色
    var mMinProgress = 13//顶部颜色
    var mProgress = 50//进度
    var mRingRadii = 100//圆环半径 -> 暂时未使用
    var mPointRadii = 40f//圆点半径
    var mRingWidth = 10//圆环粗细程度

    var mOriginXY: Pair<Int, Int>? = null
    var mHeight = 0

    var mProgressListener: ProgressListener? = null

    var mCurrentXY = Pair(0.0, 0.0)

    constructor(context: Context) : this(context, null, 0, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs, defStyleAttr, 0)

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.CircleWidget)
        try {
            mRingRadii = ta.getDimensionPixelOffset(R.styleable.CircleWidget_ring_radii, 80)
            mRingWidth = ta.getDimensionPixelOffset(R.styleable.CircleWidget_ring_width, 10)
            mTopColor = ta.getColor(R.styleable.CircleWidget_top_color, mTopColor)
            mBottomColor = ta.getColor(R.styleable.CircleWidget_bottom_color, mBottomColor)
            mMin_top_color = ta.getColor(R.styleable.CircleWidget_min_top_color, mMin_top_color)
            mMinProgress = ta.getInteger(R.styleable.CircleWidget_min_progress, mMinProgress)
        } finally {
            ta.recycle()
        }
        initPaints()
    }

    private fun initPaints() {
        mBottomPaint.color = mBottomColor
        mBottomPaint.isAntiAlias = true
        mBottomPaint.flags = Paint.ANTI_ALIAS_FLAG
        mBottomPaint.style = Paint.Style.STROKE
        mBottomPaint.strokeWidth = mRingWidth.toFloat()

        mTopPaint.color = mTopColor
        mTopPaint.isAntiAlias = true
        mTopPaint.flags = Paint.ANTI_ALIAS_FLAG
        mTopPaint.style = Paint.Style.STROKE
        mTopPaint.strokeWidth = mRingWidth.toFloat()

        mTopPointPaint.color = mTopColor
        mTopPointPaint.isAntiAlias = true
        mTopPointPaint.flags = Paint.ANTI_ALIAS_FLAG
        mTopPointPaint.style = Paint.Style.FILL

        mTopMinPaint.color = mMin_top_color
        mTopMinPaint.isAntiAlias = true
        mTopMinPaint.flags = Paint.ANTI_ALIAS_FLAG
        mTopMinPaint.style = Paint.Style.STROKE
        mTopMinPaint.strokeWidth = mRingWidth.toFloat()

        mTopMinPointPaint.color = mMin_top_color
        mTopMinPointPaint.isAntiAlias = true
        mTopMinPointPaint.flags = Paint.ANTI_ALIAS_FLAG
        mTopMinPointPaint.style = Paint.Style.FILL

        Logger.d(("${CircleWidget::class.java.name} ::paint init success "))
    }

    fun drawCircleRing(canvas: Canvas) {
        canvas.drawArc(RectF(mRingWidth.toFloat(), mRingWidth.toFloat(), (canvas.width - mRingWidth).toFloat(), (canvas.height - mRingWidth).toFloat()), 0f, 360f, false, mBottomPaint)
    }

    fun drawTopCircle(canvas: Canvas) {
        if (mProgress < mMinProgress) {
            canvas.drawArc(RectF(mRingWidth.toFloat(), mRingWidth.toFloat(), (canvas.width - mRingWidth).toFloat(), (canvas.height - mRingWidth).toFloat()), -90f, currentAngle(mProgress), false, mTopMinPaint)

        } else {
            canvas.drawArc(RectF(mRingWidth.toFloat(), mRingWidth.toFloat(), (canvas.width - mRingWidth).toFloat(), (canvas.height - mRingWidth).toFloat()), -90f, currentAngle(mProgress), false, mTopPaint)
        }
    }

    private fun drawTopPoint(canvas: Canvas) {
        val currentXY = currentXY(Pair(canvas.width / 2, canvas.height / 2), canvas.width / 2 - mRingWidth, mProgress)
        mCurrentXY = currentXY
        if (mProgress < mMinProgress) {
            canvas.drawCircle(currentXY.first.toFloat(), currentXY.second.toFloat(), mPointRadii, mTopMinPointPaint)
        } else {
            canvas.drawCircle(currentXY.first.toFloat(), currentXY.second.toFloat(), mPointRadii, mTopPointPaint)
        }
    }

    /***
     * 当前角度
     */
    fun currentAngle(process: Int): Float {
        return process * 3.6f
    }

    fun currentRadian(process: Int): Double {
        return process * Math.PI * 2 / 100
    }

    /***
     * 当前坐标
     */
    fun currentXY(centerXY: Pair<Int, Int>, radii: Int, progress: Int): Pair<Double, Double> {
        val currentAngle = currentRadian(progress)
        val x = Math.sin(currentAngle) * radii + centerXY.first
        val y = -Math.cos(currentAngle) * radii + centerXY.second
        Logger.d("currentAngle -> $currentAngle currentXY ->  （$x ， $y）,angle -> (${Math.sin(currentAngle.toDouble())},${Math.cos(currentAngle.toDouble())})")
        return Pair(x, y)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mOriginXY == null) {
            mOriginXY = Pair(canvas.width / 2, canvas.height / 2)
            mHeight = canvas.height
        }
        drawCircleRing(canvas)
        drawTopCircle(canvas)
        drawTopPoint(canvas)
    }


    var mHandleTouchEvent = false

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                //先判断点击区域处于圆点范围
                mHandleTouchEvent = ensureTouchOnPoint(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                //然后移动时候，根据当前触摸点和原点算出process
                if (mHandleTouchEvent) {
                    var currentAngle = Math.toDegrees(Math.atan2((event.x - mOriginXY!!.first).toDouble(), (mHeight - event.y - mOriginXY!!.second).toDouble()))
                    if (currentAngle < 0) {
                        currentAngle += 360
                    }
                    var progress = (currentAngle / 360 * 100).toInt()
                    if (mProgress > 75 && progress <= 10) {
                        progress = 100
                    }
                    if (mProgress < 25 && progress >= 90) {
                        progress = 0
                    }
                    Log.d("progress", "progress " + progress)

                    if ((mProgress >= 90 && progress < 50).not() && (mProgress <= 10 && progress > 50).not()) {
                        mProgress = progress
                        mProgressListener?.onProgress(mProgress)
                        invalidate()
                    }
                }
            }
            MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                mHandleTouchEvent = false
            }
        }
        // 刷新当前的圆点坐标，移动时候有分寸，每10度移动一小格。
        return mHandleTouchEvent
    }

    //确认起始点位于point中
    private fun ensureTouchOnPoint(x: Float, y: Float): Boolean {
        val xDistance = mCurrentXY.first - x
        val yDistance = mCurrentXY.second - y
        val rDistance = Math.sqrt(Math.pow(xDistance, 2.0) + Math.pow(yDistance, 2.0))
        return rDistance <= mPointRadii
    }

    public interface ProgressListener {
        fun onProgress(progress: Int)
    }

    public fun setProgressListener(listener: ProgressListener) {
        this.mProgressListener = listener
    }

}