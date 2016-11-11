package com.wisnu_krn.mencicipianimasi;

import android.animation.LayoutTransition;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wisnu_krn.mencicipianimasi.ui.ExpandedView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutTransitionActivity extends AppCompatActivity {
    @BindView(R.id.wrapTransition) LinearLayout wrapLayout;
    @BindView(R.id.add) ImageView add;
    @BindView(R.id.input) EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_transition);
        ButterKnife.bind(this);
        ToolbarHelper.getInstance().set(this).setTitle("Layout Transition");

        for (int i = 0; i < 3; i++) {
            wrapLayout.addView(new ExpandedView(this, "Lorem ipsum dolor amet " + i + "..."));
        }

        LayoutTransition transition = wrapLayout.getLayoutTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            transition.enableTransitionType(LayoutTransition.CHANGING);
        }
    }
    @OnClick(R.id.add) void setAdd() {
        wrapLayout.addView(new ExpandedView(this, input.getText().toString()));
    }
}
