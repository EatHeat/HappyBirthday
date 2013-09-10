package tk.eatheat.happybirthday;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class Main extends Activity {
 
	ImageButton giftmain;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 
		addListenerOnButton();
 
	}
 
	public void addListenerOnButton() {
 
		giftmain = (ImageButton) findViewById(R.id.giftmain);
 
		giftmain.setOnClickListener(new OnClickListener() {
 
			@Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(), Bday.class);
            startActivity(intent);
 
			}
 
		});
 
	}
 
}