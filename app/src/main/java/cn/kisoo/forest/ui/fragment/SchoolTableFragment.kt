package cn.kisoo.forest.ui.fragment

import cn.kisoo.forest.presenter.fragment.SchoolFragmentPresenter
import cn.kisoo.forest.ui.BaseFragment
import cn.kisoo.forest.ui.iview.fragment.ISchoolFragmentView
import com.jude.beam.bijection.RequiresPresenter

@RequiresPresenter(SchoolFragmentPresenter::class)
class SchoolTableFragment : BaseFragment<SchoolFragmentPresenter>(), ISchoolFragmentView {

}