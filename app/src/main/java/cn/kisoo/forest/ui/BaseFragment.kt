package cn.kisoo.forest.ui

import com.jude.beam.bijection.BeamFragment
import com.jude.beam.bijection.Presenter

abstract class BaseFragment<T : Presenter<*>> : BeamFragment<T>() {
}