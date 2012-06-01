package br.com.drawing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class BemVindoActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		View playButton = findViewById(R.id.play_button);
		playButton.setOnClickListener(this);
		View sobreButton = findViewById(R.id.sobre_button);
		sobreButton.setOnClickListener(this);
		View sairButton = findViewById(R.id.sair_button);
		sairButton.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		Intent i = null;
		Log.i("TESTE", "Evento disparado");
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.play_button:
			i = new Intent(this, DrawingDroid.class);
			startActivity(i);
			break;
		case R.id.sobre_button:
			i = new Intent(this, Sobre.class);
			startActivity(i);
			break;
		case R.id.sair_button:
			finish();
			break;
		}
	}
}