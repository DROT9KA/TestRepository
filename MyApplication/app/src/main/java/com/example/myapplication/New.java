package com.example.myapplication;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.qweqweqwe.AppBarStateChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class New extends AppCompatActivity {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.7f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.8f;
    private static final int ALPHA_ANIMATIONS_DURATION = 100;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.container)
    ConstraintLayout constraintLayout;

//    @BindView(R.id.toolbar_globus)
//    FrameLayout toolbarGlobus;

    @BindView(R.id.globus)
    ImageView globus;

    @BindView(R.id.shape)
    ImageView shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Collapsed);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.TextAppearance_MyApp_Title_Expanded);

        //This is the most important when you are putting custom textview in CollapsingToolbar
        collapsingToolbar.setTitle(" ");

        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {

                switch (state) {
                    case IDLE:
                        toolbar.setVisibility(View.INVISIBLE);
                        tvTitle.setVisibility(View.VISIBLE);
                        tvDescription.setVisibility(View.VISIBLE);
                        break;
                    case EXPANDED:
                        globus.setImageResource(R.drawable.vector);
                        shape.setImageResource(R.drawable.shape);
                        collapsingToolbar.setTitle(" ");
                        toolbar.setVisibility(View.INVISIBLE);
                        break;
                    case COLLAPSED:
                        tvTitle.setVisibility(View.INVISIBLE);
                        tvDescription.setVisibility(View.INVISIBLE);
                        collapsingToolbar.setTitle(tvTitle.getText() + " " + tvDescription.getText());
                        toolbar.setVisibility(View.VISIBLE);

                        break;
                }
                Log.d("STATE", state.name());
            }
        });

    }
}