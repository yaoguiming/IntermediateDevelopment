package cn.why.layoutinflater;

import cn.why.layoutinflaterutils.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DialogActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
		// 初始化对话框
//		Dialog dialog = new Dialog(getApplicationContext());
		Dialog dialog = new Dialog(this);
//		dialog.setTitle("hi android");
		dialog.setTitle(R.string.hello);
		dialog.setCancelable(false);
		// 获取布局文件的根节点
		LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
		LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.activity_dialog, null);
		// 获取布局文件的根节点
		EditText editText = (EditText) linearLayout.findViewById(R.id.text);
		Button button = (Button) linearLayout.findViewById(R.id.btn);
		// 在下面可以为按钮添加OnClickListener 、为TextView设置文本信息。
		// ......
		// 将布局的根节点添加到View中。
		dialog.addContentView(linearLayout, new LinearLayout.LayoutParams(300,200));
		dialog.show();
	}
}
