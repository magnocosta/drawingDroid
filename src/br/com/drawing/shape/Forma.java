package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Forma {

	private final int BORDA_LARGURA = 4;
	protected Paint cor;
	protected float inicialX;
	protected float inicialY;

	public abstract void desenhar(Canvas canvas);
	public abstract void setPosicaoFinal(float x, float y);
	public abstract float getPosicaoDeSelecaoX();
	public abstract float getPosicaoDeSelecaoY();
	

	public void setPosicaoInicial(float x, float y) {
		this.inicialX = x;
		this.inicialY = y;
	}
	
	protected void init() {
		this.cor = new Paint();
		this.cor.setStrokeWidth(BORDA_LARGURA);
		this.cor.setStyle(Paint.Style.STROKE);
		this.cor.setStrokeJoin(Paint.Join.ROUND);
		this.cor.setStrokeCap(Paint.Cap.ROUND);
		this.cor.setAntiAlias(Boolean.TRUE);
		this.cor.setDither(Boolean.TRUE);
	}

	public Paint getCor() {
		return cor;
	}

}
