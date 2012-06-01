package br.com.drawing.shape;


public class FabricaDeFormas {

	public static final int FORMA_TIPO_CIRCULO = 0;
	public static final int FORMA_TIPO_RETA = 1;

	public static Forma getForma(int type, float x, float y) {
		Forma forma = null;
		if (type == FORMA_TIPO_CIRCULO) {
			forma = new Circulo(x, y);
		} else if (type == FORMA_TIPO_RETA) {
			forma = new Reta(x, y);
		}
		return forma;
	}

}