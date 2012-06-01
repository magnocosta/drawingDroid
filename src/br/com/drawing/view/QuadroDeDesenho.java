package br.com.drawing.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
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

		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			createAlvo(x, y);
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {
			updateAlvo(x, y);
		}
		invalidate();
		return Boolean.TRUE;
	}

	private void updateAlvo(float x, float y) {
		alvo.setFinalPosition(x, y);
	}

	private void createAlvo(float x, float y) {
		alvo = FabricaDeFormas.getForma(tipoDeForma, x, y);
		formasDesenhadas.add(alvo);
	}

	public void removerUltimoDesenho() {
		if (!formasDesenhadas.isEmpty()) {
			formasDesenhadas.remove(formasDesenhadas.size() - 1);
			invalidate();
		}
	}

	public void limparDesenho() {
		formasDesenhadas.clear();
		invalidate();
	}

	public void setTipoDeForma(int tipoDeForma) {
		this.tipoDeForma = tipoDeForma;
	}

}
