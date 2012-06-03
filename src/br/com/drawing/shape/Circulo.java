package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Color;

public class Circulo extends Forma {

	private float raio = 10;

	Circulo() {
		init();
	}

	@Override
	protected void init() {
		super.init();
		this.cor.setColor(Color.BLUE);
	}

	@Override
	public void desenhar(Canvas canvas) {
		canvas.save();
		canvas.drawCircle(inicialX, inicialY, raio, cor);
		canvas.restore();
	}

	@Override
	public void setPosicaoFinal(float x, float y) {
		this.raio = (float) Math.sqrt(Math.pow((x - inicialX), 2)
				+ Math.pow((y - inicialY), 2));
	}

	@Override
	public float getPosicaoDeSelecaoX() {
		return inicialX;
	}

	@Override
	public float getPosicaoDeSelecaoY() {
		return inicialY;
	}

}