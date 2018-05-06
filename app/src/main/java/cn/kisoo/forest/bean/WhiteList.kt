package cn.kisoo.forest.bean

import io.realm.RealmModel
import io.realm.annotations.RealmClass


//白名单类
@RealmClass
open class Whitelist : RealmModel{

    private var uId: Int? = null   //用户id

    var wlistName: String? = null   //内容

}
