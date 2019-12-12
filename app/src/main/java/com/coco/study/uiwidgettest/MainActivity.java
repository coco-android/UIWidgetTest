package com.coco.study.uiwidgettest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.coco.study.uiwidgettest.common.BaseActivity;

public class MainActivity extends BaseActivity {

    private EditText editText;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);

        // 1. 点击获取输入框的内容
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                editText.setText(inputText);
            }
        });
        // 2. 点击切换图片
        final ImageView imageView = findViewById(R.id.image_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    imageView.setImageResource(R.drawable.img_2);
                } else {
                    imageView.setImageResource(R.drawable.img_1);
                }
                i++;
            }
        });

    }
}
