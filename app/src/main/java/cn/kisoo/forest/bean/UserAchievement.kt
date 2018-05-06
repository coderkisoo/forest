package cn.kisoo.forest.bean

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class UserAchievement : RealmModel {

    var achiPicture: String? = null  //成就图片

    var achiName: String? = null  //成就名称

    @PrimaryKey
    var achiId: Int? = null   //id

    var achiDescribe: String? = null  //成就描述

    var gmtModified: String? = null //成就获得时间戳

}