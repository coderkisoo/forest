package cn.kisoo.forest.ui.iview.fragment

interface ISettingFragmentView :IBaseFragmentView{
    fun finish()
    fun notifyMe(open: Boolean)
    fun keepLight(open: Boolean)
    fun openWhiteList(open: Boolean)
    fun senseMore(open: Boolean)
    fun destroyTask(open: Boolean)
}