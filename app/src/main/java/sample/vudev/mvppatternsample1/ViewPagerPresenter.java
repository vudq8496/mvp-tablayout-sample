package sample.vudev.mvppatternsample1;

import android.support.v4.app.Fragment;

/**
 * Created by Vu Dev on 6/20/2016.
 */
public interface ViewPagerPresenter {

    void addFragment(Fragment fragment, String title);

    void setUpViewPager();

    void showPageTitle(int position);

}
