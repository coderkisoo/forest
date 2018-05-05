package cn.kisoo.forest.bean

import java.util.*


class User {

    var uId: Int? = null  //id

    var uUsername: String? = null  //用户名

    var uPassword: String? = null  //密码密文


    var uPwdsalt: String? = null  //随机盐


    var uPicture: String? = null  //图片


    var uName: String? = null  //昵称


    var uSchoolnumber: String? = null  //学号


    var uAlltime: Int? = null  //总时间

    var uSuccesstime: Int? = null  //成功时间


    var gmtCreate: Date? = null  //数据创建时间


    var gmtModified: Date? = null //数据修改时间
}