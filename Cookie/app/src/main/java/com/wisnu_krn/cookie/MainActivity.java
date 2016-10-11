package com.wisnu_krn.cookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    ImageView mImageView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        mTextView = (TextView) findViewById(R.id.status_text_view);
        mButton = (Button) findViewById(R.id.eat_button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eat_button :
                //metode
                change();
                break;
        }
    }

    private void change(){
        mImageView.setImageResource(R.drawable.after_cookie);
        mTextView.setText("I'm so Full");
    }
}
