package sample.vudev.mvppatternsample1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainView, TabLayout.OnTabSelectedListener{

    ViewPagerPresenter mViewPagerPresenter;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPagerPresenter = new ViewPagerPresenterImpl(getSupportFragmentManager(), this ,tabLayout, viewPager);
        mViewPagerPresenter.setUpViewPager();

        tabLayout.setOnTabSelectedListener(this);

    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, "MainActivity : " + msg, Toast.LENGTH_SHORT).show();
    }

    // Listen when Page Tab change

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPagerPresenter.showPageTitle(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}
