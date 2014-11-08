package cn.why.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.widget.Toast;
import cn.why.layoutinflaterutils.R;

public class OptionMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);
	}
	/**
	 * 初始化Menu对象有两种方式：
|-  使用MenuInflater类，将一个xml文件转换成Menu 。
|-  使用Menu类内置的方法，手工的初始化。
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = this.getMenuInflater();
		menuInflater.inflate(R.menu.activity_menu, menu);
		for(int i=0;i<10;i++){
			MenuItem menuItem = menu.add("菜单 - " +i); 
			menuItem.setOnMenuItemClickListener(new OnMenuItemClickListener() {
				public boolean onMenuItemClick(MenuItem menuItem) {
					System.out.println(menuItem.getTitle());
					Toast.makeText(OptionMenuActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
					return false;
				}
			});
		}
		
		MenuItem item = menu.add("打开");
		SubMenu sub = menu.addSubMenu("编辑");
		sub.add("复制");
		sub.add("剪切");
		sub.setHeaderTitle("选择您要进行的操作");
		sub.setHeaderIcon(R.drawable.ic_launcher);
		sub.setIcon(R.drawable.ic_launcher);
		item.setIcon(R.drawable.ic_launcher);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String msg = "";
		switch(item.getItemId()){
			case R.id.edit:
				msg = "您点击了编辑Item";
			break;
			case R.id.close:
				msg = "您点击了关闭Item";
			break;
		}
		Toast.makeText(this, msg, 0).show();
		return true;
	}
}
