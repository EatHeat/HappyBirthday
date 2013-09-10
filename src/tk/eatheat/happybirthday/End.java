package tk.eatheat.happybirthday;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

import tk.eatheat.happybirthday.DraggableGridView;
import tk.eatheat.happybirthday.OnRearrangeListener;

public class End extends Activity {
	static Random random = new Random();
	static String[] words = "returns the day! of Many happy".split(" ");
	DraggableGridView dgv;
	ImageButton bring, view;
	ArrayList<String> poem = new ArrayList<String>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        
        dgv = ((DraggableGridView)findViewById(R.id.vgv));
        bring = ((ImageButton)findViewById(R.id.bring));
        view = ((ImageButton)findViewById(R.id.view));
        
        setListeners();
    }
    private void setListeners()
    {
    	dgv.setOnRearrangeListener(new OnRearrangeListener() {
			public void onRearrange(int oldIndex, int newIndex) {
				String word = poem.remove(oldIndex);
				if (oldIndex < newIndex)
					poem.add(newIndex, word);
				else
					poem.add(newIndex, word);
			}
		});
    	dgv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				dgv.removeViewAt(arg2);
				poem.remove(arg2);
			}
		});
    	bring.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String word = words[random.nextInt(words.length)];
				ImageView view = new ImageView(End.this);
				view.setImageBitmap(getThumb(word));
				dgv.addView(view);
				poem.add(word);
			}
		});
    	view.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				String finishedPoem = "";
				for (String s : poem)
					finishedPoem += s + " ";
				new AlertDialog.Builder(End.this)
			    .setTitle("Happy Birthday!")
			    .setMessage(finishedPoem).show();
			}
		});
    }
    
    private Bitmap getThumb(String s)
	{
		Bitmap bmp = Bitmap.createBitmap(150, 150, Bitmap.Config.RGB_565);
		Canvas canvas = new Canvas(bmp);
	    Paint paint = new Paint();
	    
	    paint.setColor(Color.rgb(random.nextInt(128), random.nextInt(128), random.nextInt(128)));
	    paint.setTextSize(24);
	    paint.setFlags(Paint.ANTI_ALIAS_FLAG);
	    canvas.drawRect(new Rect(0, 0, 150, 150), paint);
	    paint.setColor(Color.WHITE);
	    paint.setTextAlign(Paint.Align.CENTER);
	    canvas.drawText(s, 75, 75, paint);
	    
		return bmp;
	}
}