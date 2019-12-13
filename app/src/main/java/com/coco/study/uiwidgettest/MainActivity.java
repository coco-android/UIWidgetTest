package com.coco.study.uiwidgettest;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.coco.study.uiwidgettest.LinearLayout.LinearLayoutActivity;
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
        // 加载样式组件
        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        final ProgressBar progressBar2 = findViewById(R.id.progress_bar_2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    imageView.setImageResource(R.drawable.img_2);
                } else {
                    imageView.setImageResource(R.drawable.img_1);
                }
                i++;
                // 样式加载
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                // 进度条样式
                int progress = progressBar2.getProgress();
                progress = progress + 10;
                progressBar2.setProgress(progress);
            }
        });

        // 3. AlertDialog 弹窗
        Button alertDialogBtn = findViewById(R.id.alert_dialog);
        alertDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("这里是Title");
                dialog.setMessage("这个事，真的很重要！");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确认了", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });

        // 4. ProgressDialog 弹窗
        final Button progressDialogBtn = findViewById(R.id.progress_dialog);
        progressDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("这里是Title");
                progressDialog.setMessage("注意：ProgressDialog已经废弃了！");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });

        // 5. LinearLayout 布局
        Button linearLayoutBtn = findViewById(R.id.linear_layout);
        linearLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
