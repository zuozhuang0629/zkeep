package com.zuoz.zkeep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.adapters.FrameLayoutBindingAdapter
import androidx.fragment.app.Fragment
import com.zuoz.zkeep.base.BaseVBAct
import com.zuoz.zkeep.databinding.ActivityMainBinding
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zuoz.zkeep.fragments.CommunityFragment
import com.zuoz.zkeep.fragments.HomeFragment
import com.zuoz.zkeep.fragments.MeFragment
import com.zuoz.zkeep.fragments.PlanFragment


class MainActivity : BaseVBAct<ActivityMainBinding>() {

    private val fragments : List<Fragment> by lazy {
        arrayListOf<Fragment>( HomeFragment(), CommunityFragment(), PlanFragment(), MeFragment())
    }
    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        initBottomNav();
        initPage()
    }

    override fun initData() {
    }

    override fun initListener() {
    }

    private fun initPage() {
        mViewBinding.mianPage.apply {
            this.isUserInputEnabled = false
            this.offscreenPageLimit = fragments.size
        }
        mViewBinding.mianPage.adapter = object : FragmentStateAdapter(this@MainActivity) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {

                return when (position) {
                    0,1,2,3 -> {
                        fragments[position]
                    }

                    else->{
                        HomeFragment();
                    }
                }
            }

        }

    }

    private fun initBottomNav() {

        mViewBinding.mainBottom.menuItemSelectionListener = object :
            BottomNavigation.OnMenuItemSelectionListener {
            override fun onMenuItemReselect(itemId: Int, position: Int, fromUser: Boolean) {

            }

            override fun onMenuItemSelect(itemId: Int, position: Int, fromUser: Boolean) {
                mViewBinding.mianPage.setCurrentItem(position, false)
            }


        }
    }
}