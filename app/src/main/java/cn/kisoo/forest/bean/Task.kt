package cn.kisoo.forest.bean

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Task :RealmModel{

    @PrimaryKey
    var tId: Int? = null    //任务id

    var uId: String? = null  //用户id

    var tLength: Int? = null  //时长

    var tStarttime: Date? = null  //开始时间

    var tSuccessLength :Int? = null //成功时长

    var isSuccess: Byte? = null  //是否成功 0失败 1成功 -1还未出结果

    var hasUpload = false // 是否已经上传成功

}