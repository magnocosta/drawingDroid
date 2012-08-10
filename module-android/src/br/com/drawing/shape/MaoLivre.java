package br.com.drawing.shape;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;

public class MaoLivre extends Forma {

	private float finalX;
	private float finalY;
	private Path path;

	MaoLivre() {
		init();
	}

	@Override
	protected void init() {
		super.init();
		this.path = new Path();
		this.cor.setColor(Color.WHITE);
	}

	@Override
	public void setPosicaoInicial(float x, float y) {
		super.setPosicaoInicial(x, y);
		path.moveTo(inicialX, inicialY);
		finalX = inicialX;
		finalY = inicialY;
	}

	@Override
	public void desenhar(Canvas canvas) {
		path.moveTo(inicialX, inicialY);
		path.quadTo(inicialX, inicialY, finalX, finalY);
		canvas.save();
		canvas.drawPath(path, cor);
		canvas.restore();
		inicialX = finalX;
		inicialY = finalY;
	}

	@Override
	public void setPosicaoFinal(float x, float y) {
		this.finalX = x;
		this.finalY = y;
	}

	@Override
	public float getPosicaoDeSelecaoX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPosicaoDeSelecaoY() {
		// TODO Auto-generated method stub
		return 0;
	}

}
