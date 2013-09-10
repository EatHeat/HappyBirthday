package tk.eatheat.happybirthday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Rules extends Activity {
 
	ImageButton arrow2;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rules);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
 
		arrow2 = (ImageButton) findViewById(R.id.arrow2);
 
		arrow2.setOnClickListener(new OnClickListener() {
 
			@Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), End.class);
            startActivity(intent);
 
			}
 
		});
 
	}
 
}