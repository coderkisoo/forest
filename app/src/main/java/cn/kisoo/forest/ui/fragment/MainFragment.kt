package cn.kisoo.forest.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.kisoo.forest.R
import cn.kisoo.forest.presenter.MainFragmentPresenter
import com.jude.beam.bijection.BeamFragment

class MainFragment : BeamFragment<MainFragmentPresenter>() {

    var mRootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater?.inflate(R.layout.fragment_main,container,false)
        return mRootView
    }
}