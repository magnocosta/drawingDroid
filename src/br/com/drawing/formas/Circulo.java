package br.com.drawing.formas;

public class Circulo implements Forma {
	float xi;
	float yi;
	float raio;
	TipoDeForma tipo = TipoDeForma.CIRCULO;
	int cor;
	
	public Circulo(float xi, float yi, float raio) {
		this.xi = xi;
		this.yi = yi;
		this.raio = raio;
		this.cor = 0xFFFFFF00;
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

	public float getRaio() {
		return raio;
	}

	public void setRaio(float raio) {
		this.raio = raio;
	}

	public TipoDeForma getTipo() {
		return tipo;
	}

	public int getCor(){
		return this.cor;
	}
	
	public float getPontos() {
		return 0;
	}

	@Override
	public float getXf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getYf() {
		// TODO Auto-generated method stub
		return 0;
	}

}
