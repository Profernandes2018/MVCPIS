package br.com.fiap.imposto.model;

import java.util.Observable;

// O Model � um Observable
// A Classe Pis da camada Model n�o possui refer�ncia a View ou ao // Controller
// Ao implementar Imposto, teremos maior flexibilidade no Controller
public class Pis extends Observable implements Imposto{
	
	final float ALIQUOTA = 0.65f;
	float valorDoPis = 0;
		
	public Pis() {
		System.out.println("Construtor do Model chamado");
	}

	public float getALIQUOTA() {
		return ALIQUOTA;
	}
	
	public float getValorDoPis() {
		return valorDoPis;
	}
	
	public void calcularImposto(float valor) {
		valorDoPis = valor * ALIQUOTA;
		// setChanged Altera o estado interno do objeto 
           // para true, pois houve altera��o no estado valorDoPis 
		setChanged();
		// Os observadores devem ser notificados
		// Envia o valor do PIS como parte da mensagem de 
           // notifica��o para a View que � um Observer
		notifyObservers(valorDoPis);
	}

	@Override
	public String toString() {
		return "Pis [ALIQUOTA=" + ALIQUOTA 
                                    + ", valorDoPis=" + valorDoPis + "]";
      }
}