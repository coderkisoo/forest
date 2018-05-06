package cn.kisoo.forest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.fragment.SettingFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.iview.fragment.ISettingFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(SettingFragmentPresenter::class)
class SettingFragment : BaseFragment<SettingFragmentPresenter>(), ISettingFragmentView {

    var mRootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_setting, null)
        return mRootView
    }
}