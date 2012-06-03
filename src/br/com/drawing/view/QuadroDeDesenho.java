package br.com.drawing.view;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import br.com.drawing.shape.FabricaDeFormas;
import br.com.drawing.shape.Forma;

public class QuadroDeDesenho extends View {

	private int tipoDeForma;
	private Forma alvo;
	private List<Forma> formasDesenhadas;

	public QuadroDeDesenho(Context context) {
		super(context);
		init();
	}

	public QuadroDeDesenho(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public QuadroDeDesenho(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		formasDesenhadas = new ArrayList<Forma>();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		for (Forma forma : formasDesenhadas) {
			forma.desenhar(canvas);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		float x = event.getX();
		float y = event.getY();

		if (tipoDeForma == TipoDeAcao.ACAO_SELECIONAR_FORMA) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				selecionarForma(x, y);
			}
		} else {
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				createAlvo(x, y);
				invalidate();
			} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
				updateAlvo(x, y);
				invalidate();
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				alvo = null;
			}
		}

		return Boolean.TRUE;
	}

	private void updateAlvo(float x, float y) {
		alvo.setPosicaoFinal(x, y);
	}

	private void createAlvo(float x, float y) {
		alvo = FabricaDeFormas.getForma(tipoDeForma, x, y);
		formasDesenhadas.add(alvo);
	}

	public void removerDesenho() {
		if (alvo != null) {
			Log.w("TESTE", MessageFormat.format("objeto : {0} selecionado", formasDesenhadas.indexOf(alvo)));
			formasDesenhadas.remove(formasDesenhadas.indexOf(alvo));
			alvo = null;
			invalidate();
		} else {
			if (!formasDesenhadas.isEmpty()) {
				formasDesenhadas.remove(formasDesenhadas.size() - 1);
				invalidate();
			}
		}
	}

	public void limparDesenho() {
		formasDesenhadas.clear();
		invalidate();
	}

	public void setTipoDeForma(int tipoDeForma) {
		this.tipoDeForma = tipoDeForma;
	}

	private void selecionarForma(float x, float y) {
		float raioDoObjetoSelecionado = 999f;
		for (Forma forma : formasDesenhadas) {
			float posicaoDeSelecaoX = forma.getPosicaoDeSelecaoX();	
			float posicaoDeSelecaoY = forma.getPosicaoDeSelecaoY();
			float raioDeDistancia = (float) Math.sqrt(Math.pow(
					(posicaoDeSelecaoX - x), 2)
					+ Math.pow((posicaoDeSelecaoY - y), 2));
			Log.w("TESTE", MessageFormat.format("raio de distancia: {0}", raioDeDistancia));
			Log.w("TESTE", MessageFormat.format("raio selecionado: {0}", raioDoObjetoSelecionado));
			if (raioDeDistancia < raioDoObjetoSelecionado) {
				alvo = forma;
				raioDoObjetoSelecionado = raioDeDistancia;
			}
		}
	}

}
