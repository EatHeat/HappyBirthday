package tk.eatheat.happybirthday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Bday extends Activity {
 
	ImageButton arrow;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bday);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
 
		arrow = (ImageButton) findViewById(R.id.arrow);
 
		arrow.setOnClickListener(new OnClickListener() {
 
			@Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), Rules.class);
            startActivity(intent);
 
			}
 
		});
 
	}
 
}