package br.com.drawing;

import br.com.drawing.shape.FabricaDeFormas;
import br.com.drawing.view.QuadroDeDesenho;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrawingDroid extends Activity {

	public static final int MAO_LIVRE = 0;
	public static final int RETA = 1;
	public static final int CIRCULO = 2;
	public static final int APAGAR = 9;

	private QuadroDeDesenho quadroDeDesenho;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawing_layout);
		
		this.quadroDeDesenho = (QuadroDeDesenho) findViewById(R.id.quadroDeDesenho);
		

		View btnMaoLivre = (Button) findViewById(R.id.mao_livre);
		btnMaoLivre.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				DrawingDroidView.modo = MAO_LIVRE;
			}
		});

		View btnReta = (Button) findViewById(R.id.reta);
		btnReta.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				quadroDeDesenho.setTipoDeForma(FabricaDeFormas.FORMA_TIPO_RETA);
			}
		});

		View btnCirculo = (Button) findViewById(R.id.circulo);
		btnCirculo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				quadroDeDesenho.setTipoDeForma(FabricaDeFormas.FORMA_TIPO_CIRCULO);
			}
		});

		View btnNovo = (Button) findViewById(R.id.novo);
		btnNovo.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				quadroDeDesenho.limparDesenho();
			}
		});

		View btnApagar = (Button) findViewById(R.id.apagar);
		btnApagar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				quadroDeDesenho.removerUltimoDesenho();
			}
		});

	}
}