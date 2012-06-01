package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circulo extends Forma {

	private float raio = 10;

	Circulo(float x, float y) {
		this.inicialX = x;
		this.inicialY = y;
		this.cor = new Paint();
		this.cor.setColor(Color.BLUE);
	}

	@Override
	public void desenhar(Canvas canvas) {
		canvas.save();
		canvas.drawCircle(inicialX, inicialY, raio, cor);
		canvas.restore();
	}

	@Override
	public void setFinalPosition(float x, float y) {
		this.raio = (float) Math.sqrt(Math.pow((x - inicialX), 2)
				+ Math.pow((y - inicialY), 2));
	}

}