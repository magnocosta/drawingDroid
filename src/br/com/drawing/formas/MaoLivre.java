package br.com.drawing.formas;

import java.util.ArrayList;

public class MaoLivre implements Forma {
	float xi;
	float yi;
	ArrayList<Ponto> pontos = new ArrayList<Ponto>();
	TipoDeForma tipo = TipoDeForma.MAOLIVRE;
	int cor = 0xFF00FF00;
	
	public MaoLivre(float xi, float yi) {
		this.xi = xi;
		this.yi = yi;
		Ponto p = new Ponto(xi, yi);
		pontos.add(p);
	}

	public void adicionarPonto(float x, float y) {
		Ponto p = new Ponto(x, y);
		pontos.add(p);
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
	
	public TipoDeForma getTipo() {
		return tipo;
	}
	
	public int getCor(){
		return this.cor;
	}

	public float getXf() {
		return 0;
	}

	public float getYf() {
		return 0;
	}

	public float getRaio() {
		return 0;
	}

	public float getPontos() {
		return 0;
	}

}
