package com.zuoz.zkeep.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding



abstract class BaseVBAct<B : ViewBinding> : FragmentActivity() {
    protected lateinit var mViewBinding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = initViewBinding()
        setContentView(mViewBinding.root)

        initView()
        initListener()
        initData()
    }


    protected abstract fun initViewBinding(): B
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun initListener()
}