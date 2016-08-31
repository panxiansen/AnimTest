package com.imooc.tomsom.animtest;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener{

    private int[] res = {R.id.button_a,R.id.button_b,R.id.button_c,R.id.button_d,R.id.button_e,R.id.button_f,R.id.button_g,R.id.button_h};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag = true;//判断按钮是否被展开

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0;i<res.length;i++){
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button_a:
                if (flag){
                    startAnim();
                }else{
                    closeAnim();
                }
                break;
            
            default:
                break;
        }
    }

    private void closeAnim() {
        for (int i = 1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY",i*150F,0F);
            animator.setDuration(800);//出现时间
            animator.setStartDelay(i*80);//设置以此出现的顺序和时间间隔
            animator.start();

        }
        flag = true;
    }

    private void startAnim() {
        for (int i = 1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY",0F,i*150F);
            animator.setDuration(800);//出现时间
            animator.setStartDelay(i * 80);//设置以此出现的顺序和时间间隔
            animator.start();

        }
        flag = false;
    }
}
