package br.com.drawing.shape;

import android.graphics.Canvas;

public class MaoLivre extends Forma {
	
	private float finalX;
	private float finalY;

	@Override
	public void desenhar(Canvas canvas) {
		
	}

	@Override
	public void setFinalPosition(float x, float y) {
		this.finalX = x;
		this.finalY = y;
	}

}
