package cn.kisoo.forest.bean

import java.util.*

class TaskVO {

    private var uId: Int? = null  //用户id

    private var tLength: Int? = null  //时长

    private var tStarttime: Date? = null  //开始时间

    private var tSuccessLength :Int? = null //成功时长

    private var isSuccess: Byte? = null  //是否成功 0失败 1成功

}
