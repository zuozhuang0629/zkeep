package com.zuoz.zkeep.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**

 * @Description:
 * @Author:         zuoz
 * @CreateDate:     2021/11/28 13:17
 */
abstract class BaseVBFragment<VB : ViewBinding> : Fragment() {

    protected lateinit var mViewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewBinding = initViewBinding()
        return mViewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun initViewBinding():VB

    abstract fun initView();

    abstract fun initData();

    abstract fun initListener();

}