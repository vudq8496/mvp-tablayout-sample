package sample.vudev.mvppatternsample1;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import sample.vudev.mvppatternsample1.fragments.OneFragment;
import sample.vudev.mvppatternsample1.fragments.TwoFragment;

/**
 * Created by Vu Dev on 6/20/2016.
 */
public class ViewPagerPresenterImpl extends FragmentPagerAdapter implements ViewPagerPresenter {

    private MainView mMainView;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerPresenterImpl(FragmentManager fm, MainView mainView, TabLayout tabLayout, ViewPager viewPager) {
        super(fm);
        mMainView = mainView;
        mTabLayout = tabLayout;
        mViewPager = viewPager;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public void setUpViewPager() {
        //TODO need addFragment
        addFragment(new OneFragment(), "One");
        addFragment(new TwoFragment(), "Two");
        mViewPager.setAdapter(this);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void showPageTitle(int position) {
        mMainView.showMessage(mFragmentTitleList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }



}
