package ua.study.awesome.androidlessons.testtask_skysoft.ui.spannable_string;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import butterknife.BindView;
import ua.study.awesome.androidlessons.testtask_skysoft.R;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.BaseFragment;
import ua.study.awesome.androidlessons.testtask_skysoft.ui.MainActivity;
import ua.study.awesome.androidlessons.testtask_skysoft.utils.AppConstans;

public class SpannableStringFragment extends BaseFragment {

    public static final String FRAGMENT_TAG = SpannableStringFragment.class.getSimpleName();

    @BindView(R.id.tv_spannable_string)
    TextView textView;

    private SpannableString s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;

    SpannableStringBuilder builder;

    private static final String ARG_TITLE = "TITLE";

    private String title;

    public static SpannableStringFragment getInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(ARG_TITLE, title);

        SpannableStringFragment spannableStringFragment = new SpannableStringFragment();
        spannableStringFragment.setArguments(bundle);

        return spannableStringFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();

        setSpannableText();
        setStyleSpannableText();
        buildSpanString();

        textView.setText(builder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_spannable_string;
    }

    public void init() {
        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_menu_white);

        Objects.requireNonNull(((MainActivity) Objects.requireNonNull(getActivity())).
                getSupportActionBar()).setTitle(String.format("%s", title));
    }

    public void setStyleSpannableText() {
        int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

        s1.setSpan(new StyleSpan(Typeface.BOLD), 0, s1.length(), flag);
        s2.setSpan(new StyleSpan(Typeface.ITALIC), 0, s2.length(), flag);
        s3.setSpan(new ForegroundColorSpan(Color.BLUE), 0, s3.length(), flag);
        s4.setSpan(new BackgroundColorSpan(Color.GRAY), 0, s4.length(), flag);
        s5.setSpan(new UnderlineSpan(), 0, s5.length(), flag);
        s6.setSpan(new StrikethroughSpan(), 0, s6.length(), flag);
        s7.setSpan(new RelativeSizeSpan(2), 0, s7.length(), flag);
        s8.setSpan(new RelativeSizeSpan(0.5f), 0, s8.length(), flag);
        s9.setSpan(new TypefaceSpan("monospace"), 0, s9.length(), flag);
        s10.setSpan(new URLSpan(AppConstans.SPANNABLE_URL), 0, s10.length(), flag);
        s11.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(getContext(), "Span clicked", Toast.LENGTH_LONG).show();
            }
        }, 0, s11.length(), flag);
        s12.setSpan(new ForegroundColorSpan(Color.RED), 0, 11, flag);
        s12.setSpan(new BackgroundColorSpan(Color.YELLOW), 4, s12.length(), flag);
        s12.setSpan(new UnderlineSpan(), 4, 11, flag);
    }

    public void setSpannableText() {
        s1 = new SpannableString("bold\n");
        s2 = new SpannableString("italic\n");
        s3 = new SpannableString("foreground color\n");
        s4 = new SpannableString("background color\n");
        s5 = new SpannableString("underline\n");
        s6 = new SpannableString("strikethrough\n");
        s7 = new SpannableString("bigger\n");
        s8 = new SpannableString("smaller\n");
        s9 = new SpannableString("font\n");
        s10 = new SpannableString("URL span\n");
        s11 = new SpannableString("clickable span\n");
        s12 = new SpannableString("overlapping spans\n");
    }

    public void buildSpanString() {
        builder = new SpannableStringBuilder();
        builder.append(s1);
        builder.append(s2);
        builder.append(s3);
        builder.append(s4);
        builder.append(s5);
        builder.append(s6);
        builder.append(s7);
        builder.append(s8);
        builder.append(s9);
        builder.append(s10);
        builder.append(s11);
        builder.append(s12);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((MainActivity) Objects.requireNonNull(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}