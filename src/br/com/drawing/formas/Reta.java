package br.com.drawing.formas;

public class Reta implements Forma {
	float xi;
	float yi;
	float xf;
	float yf;
	TipoDeForma tipo = TipoDeForma.RETA;
	int cor;
	
	public Reta(float xi, float yi, float xf, float yf) {
		this.xi = xi;
		this.xf = xf;
		this.yi = yi;
		this.yf = yf;
		this.cor = 0xFFFF0000;

	}

	public float getXi() {
		return xi;
	}

	public void setXi(float xi) {
		this.xi = xi;
	}

	public float getYi() {
		return yi;
	}

	public void setYi(float yi) {
		this.yi = yi;
	}

	public float getXf() {
		return xf;
	}

	public void setXf(float xf) {
		this.xf = xf;
	}

	public float getYf() {
		return yf;
	}

	public void setYf(float yf) {
		this.yf = yf;
	}

	public TipoDeForma getTipo() {
		return tipo;
	}
	
	public int getCor(){
		return this.cor;
	}
	
	public float getRaio() {
		return 0;
	}

	public float getPontos() {
		return 0;
	}

}
