package cn.kisoo.forest.bean

import java.util.*


open class Task {

    private val tId: Int? = null    //任务id


    private val uId: Int? = null  //用户id


    private val tLength: Int? = null  //时长


    private val tStarttime: Date? = null  //开始时间

    private var tSuccessLength :Int? = null //成功时长

    private val isSuccess: Byte? = null  //是否成功 0失败 1成功


    private val gmtCreate: String? = null //记录创建时间


}