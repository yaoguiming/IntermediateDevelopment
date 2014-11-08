package cn.why.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.why.layoutinflaterutils.R;

public class ContextMenuActivity extends Activity {

	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_context_menu);
		
		button = (Button) this.findViewById(R.id.button);
		this.registerForContextMenu(this.button);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.activity_menu, menu);
		Toast.makeText(this, "View =" + v, 0).show();
		// 设置菜单的Icon和Title
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("ABC");
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
			switch(item.getItemId()){
			case R.id.edit:
			case R.id.close:
				if(item.isChecked()){
					item.setChecked(false);
				}else{
					item.setChecked(true);
				}
			break;
		}
		Toast.makeText(this,item.getTitle(),0).show();
		return true;
	}
	
}
