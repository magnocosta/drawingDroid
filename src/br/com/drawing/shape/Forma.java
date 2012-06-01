package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Forma {

	protected Paint cor;
	protected float inicialX;
	protected float inicialY;

	public abstract void desenhar(Canvas canvas);
	public abstract void setFinalPosition(float x, float y);

	public Paint getCor() {
		return cor;
	}

}
