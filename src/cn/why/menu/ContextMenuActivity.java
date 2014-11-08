package cn.why.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
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
		super.onCreateContextMenu(menu, v, menuInfo);
	}
}
