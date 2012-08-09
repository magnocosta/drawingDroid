package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Color;

public class Reta extends Forma {

	private float finalX;
	private float finalY;

	Reta() {
		init();
	}

	@Override
	protected void init() {
		super.init();
		this.cor.setColor(Color.RED);
	}

	@Override
	public void setPosicaoInicial(float x, float y) {
		super.setPosicaoInicial(x, y);
		this.finalX = inicialX;
		this.finalY = inicialY;
	}

	@Override
	public void desenhar(Canvas canvas) {
		canvas.save();
		canvas.drawLine(inicialX, inicialY, finalX, finalY, cor);
		canvas.restore();
	}

	@Override
	public void setPosicaoFinal(float x, float y) {
		finalX = x;
		finalY = y;
	}

	@Override
	public float getPosicaoDeSelecaoX() {
		return (inicialX + finalX) / 2;
	}

	@Override
	public float getPosicaoDeSelecaoY() {
		return (inicialY + finalY) / 2;
	}

}
