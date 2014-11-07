package cn.why.layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutParamsActivity extends Activity {

	private LinearLayout linear;
	private Button validate;
	private TextView username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 初始化控件。
        this.linear = new LinearLayout(this);
        this.username = new TextView(this);
        this.validate = new Button(this);
        this.username.setText("用户名：");
        this.validate.setText("验证");
        // 将Button和TextView添加到LinearLayout中。
//        this.linear.addView(this.username);
//        this.linear.addView(this.validate);
        
        this.linear.setOrientation(LinearLayout.VERTICAL);
        this.linear.addView(this.username,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        this.linear.addView(this.validate,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        
        
        TextView textView = new TextView(this);
        textView.setText("Hi Android");
        // 为TextView设置布局参数。
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 50);
        params.topMargin = 100;//使用布局参数的topMargin等属性可以设置当前View与其相邻控件或父控件间的间距
        params.leftMargin = 100;
        // 将TextView添加到布局中。
        this.linear.addView(textView,params);
        
        this.setContentView(this.linear);
	}
}
