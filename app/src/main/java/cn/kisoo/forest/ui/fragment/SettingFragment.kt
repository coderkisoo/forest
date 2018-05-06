package cn.kisoo.forest.ui.fragment

import cn.kisoo.forest.presenter.fragment.SettingFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.iview.fragment.ISettingFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(SettingFragmentPresenter::class)
class SettingFragment : BaseFragment<SettingFragmentPresenter>(), ISettingFragmentView {

}