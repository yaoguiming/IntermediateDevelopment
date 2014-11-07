package cn.why.layoutinflater;

import cn.why.layoutinflaterutils.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewParentActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_parent);
		
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rootLayout);
		TextView textView = (TextView) linearLayout.getChildAt(0);
		System.out.println(textView.getParent() == linearLayout);
	}

}
