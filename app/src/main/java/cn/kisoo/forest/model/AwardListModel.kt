package cn.kisoo.forest.model

import cn.kisoo.forest.bean.UserAchiVO
import cn.kisoo.forest.bean.UserAchievement
import io.realm.Realm

object AwardListModel {
    private val list = ArrayList<UserAchievement>()

    fun hasLoadAwardList(): Boolean {
        return getAwardListFromLocal().isNotEmpty()
    }

    fun getAwardListFromLocal(): ArrayList<UserAchievement> {
        if (list.isNotEmpty()) {
            return list
        }
        val results =  Realm.getDefaultInstance().where(UserAchievement::class.java).findAll()
        results.forEach {
            list.add(it)
        }
        return list
    }

    fun updateAwardList(listener: AwardObtainListener) {

    }

    interface AwardObtainListener {
        fun onAwardObtain(userAchiVO: UserAchiVO)
        fun onFail(info: String)
    }
}