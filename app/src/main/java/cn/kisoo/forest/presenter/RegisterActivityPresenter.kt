package cn.kisoo.forest.presenter

import android.content.Intent
import cn.kisoo.forest.R
import cn.kisoo.forest.ui.activity.LoginActivity
import cn.kisoo.forest.ui.iview.IRegisterActivityView
import cn.kisoo.forest.util.ToastUtils
import com.jude.beam.bijection.Presenter

class RegisterActivityPresenter : Presenter<IRegisterActivityView>() {

    val mHeadList = arrayOf(R.mipmap.head_1, R.mipmap.head_2, R.mipmap.head_3, R.mipmap.head_4,
            R.mipmap.head_5, R.mipmap.head_6, R.mipmap.head_7, R.mipmap.head_8)

    var mCurrentHead = 0

    fun goLogin() {
        val intent = Intent()
        intent.setClass(view.getContext(), LoginActivity::class.java)
        view.getContext().startActivity(intent)
    }

    fun register(headType: Int, name: String, schoolNum: String, account: String, password: String, password2: String) {

        if (password != password2) {
            ToastUtils.shortToast(R.string.pwd_not_same)
        }

    }

    /***
     * 展示头像选择
     */
    fun showHeadSelector() {

    }

    fun selectHead(position: Int) {
        mCurrentHead = position
        view.setHead(mHeadList[position])
    }


}