package cn.kisoo.forest.bean

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

//白名单类
@RealmClass
open class Whitelist : RealmModel {

    @PrimaryKey
    var uId: String? = null   //用户id

    var wlistName: String? = null   //内容

}
