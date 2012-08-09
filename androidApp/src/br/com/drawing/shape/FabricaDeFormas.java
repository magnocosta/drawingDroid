package br.com.drawing.shape;

import br.com.drawing.view.TipoDeAcao;


public class FabricaDeFormas {

	public static Forma getForma(int type, float x, float y) {
		Forma forma = null;
		if (type == TipoDeAcao.ACAO_DESENHAR_CIRCULO) {
			forma = new Circulo();
		} else if (type == TipoDeAcao.ACAO_DESENHAR_RETA) {
			forma = new Reta();
		} else if (type == TipoDeAcao.ACAO_DESENHAR_MAO_LIVRE) {
			forma = new MaoLivre();
		}

		forma.setPosicaoInicial(x, y);
		return forma;
	}

}