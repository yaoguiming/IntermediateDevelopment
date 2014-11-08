package cn.why.layoutinflater;

import cn.why.layoutinflaterutils.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;


public class LayoutInflateActivity extends ActionBarActivity {

	private TextView textView;
	private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linearLayout = (LinearLayout) this.findViewById(R.id.rootLayout);
        textView = new TextView(getApplicationContext());
        textView.setText("www.why.com");
        textView.setTag("Tag");
        
        linearLayout.addView(textView);
        /**
         * Activity类的findViewById方法只能获取当前Activity的xml布局文件中的控件。
         * 若想将其他xml文件中的控件添加到当前Activity中就需要使用LayoutInflater类了
         */
        //获取LayoutInflater对象，从系统服务中
        LayoutInflater layoutInflater =  (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        LinearLayout linearLayout1 = (LinearLayout) layoutInflater.inflate(R.layout.other, linearLayout);
//        LinearLayout linearLayout2 = (LinearLayout) layoutInflater.inflate(R.layout.other, linearLayout);
////        虽然通过inflate方法向layout中添加了两遍，但是在当前Activity中只会显示添加一个
//        System.out.println(linearLayout1==linearLayout2);//true
        
      //从other.xml文件中获取其根节点，并将其放入layout中。
        LinearLayout linearLayout3 = (LinearLayout) layoutInflater.inflate(R.layout.other, null);
        LinearLayout linearLayout4 = (LinearLayout) layoutInflater.inflate(R.layout.other, null);
        //注意： 此处会输出false。
        System.out.println(linearLayout3 ==  linearLayout4); 
        //由于调用inflate方法时并没有将布局文件放入到任何控件中，因此每次inflate时都会返回一个新对象。
        //linearLayout3!=linearLayout4， 所以调用ViewGroup的addView方法可以重复添加元素。
        linearLayout.addView(linearLayout3);
        linearLayout.addView(linearLayout4);
        
        Intent intent = new Intent();
        intent.setClass(LayoutInflateActivity.this, cn.why.menu.ContextMenuActivity.class);
        startActivity(intent);
        
    }
}
