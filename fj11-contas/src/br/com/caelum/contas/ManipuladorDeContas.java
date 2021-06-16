package br.com.caelum.contas;

import br.com.caelum.javafx.api.util.Evento;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

public class ManipuladorDeContas {
	Conta conta;
	
	public void criaConta(Evento evento){
		
		String	tipo = evento.getSelecionadoNoRadio("tipo");
		
		if	(tipo.equals("Conta Corrente"))	{
			this.conta = new	ContaCorrente();
		} else if (tipo.equals("Conta Poupan�a")) {
			this.conta = new	ContaPoupanca();
		}
		
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setTitular(evento.getString("titular"));
		
	}

	public void saca(Evento evento) {
		
		double	valor	=	evento.getDouble("valorOperacao");
		
		if	(this.conta.getTipo().equals("Conta	Corrente")){
			this.conta.saca(valor);
		} else if (this.conta.getTipo().equals("Conta Poupan�a")) {
			this.conta.saca(valor);
		}
	}

	public void deposita(Evento evento) {
		
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.deposita(valorDigitado);
		
	}

	public void transfere(Evento evento) {
		Conta destino = ((Conta) evento.getSelecionadoNoCombo("destino"));
		double valor = evento.getDouble("valorTransferencia");
		this.conta.transfere(valor, destino);
	}

}