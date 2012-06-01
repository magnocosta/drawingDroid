package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Reta extends Forma {

	private float finalX;
	private float finalY;

	Reta(float x, float y) {
		this.inicialX = x;
		this.inicialY = y;
		this.finalX = x;
		this.finalY = y;
		this.cor = new Paint();
		this.cor.setColor(Color.RED);
	}
	
	@Override
	public void desenhar(Canvas canvas) {
		canvas.save();
		canvas.drawLine(inicialX, inicialY, finalX, finalY, cor);
		canvas.restore();
	}

	@Override
	public void setFinalPosition(float x, float y) {
		finalX = x;
		finalY = y;
	}

}
