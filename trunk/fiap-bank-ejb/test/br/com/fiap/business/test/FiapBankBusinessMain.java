/**
 * 
 */
package br.com.fiap.business.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.jboss.security.auth.callback.AppCallbackHandler;

import br.com.fiap.business.interfaces.remote.AbrirContaRemote;
import br.com.fiap.business.interfaces.remote.AbrirPedidoCreditoRemote;
import br.com.fiap.business.interfaces.remote.AvaliarPedidosCreditoRemote;
import br.com.fiap.business.interfaces.remote.ConsultarPedidoCreditoRemote;
import br.com.fiap.business.interfaces.remote.LoginRemote;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Banco;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.entity.Endereco;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.domain.entity.TipoConta;
import br.com.fiap.domain.entity.Usuario;

/**
 * @author leandro.goncalves
 *
 */
public class FiapBankBusinessMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context;
		
		try {
			
			Credito credito = new Credito();
			credito.setId(1L);
			Long a = new Long(1);
			Long b = new Long(1);
			
			System.out.println(credito.getId().equals(b));
			
			//context = new InitialContext();
			//Seguranca seguranca = logar(context);
			//abrirConta(context);
			//abrirCredito(context, conta);
			//Conta conta = new Conta();
			//conta.setId(10L);
			//consultarCredito(context, conta);
			//avaliarCredito(context);
			
		} catch (Throwable e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static Seguranca logar (Context context) throws NamingException, LoginException{
		
		LoginContext loginContext = new LoginContext("fiap-bank-policy", new AppCallbackHandler("000010", "cliente".toCharArray()));
		loginContext.login();
		LoginRemote login = (LoginRemote)context.lookup("fiap-bank-ear/login/remote");

		return login.logar("000010", "cliente");
	}
	
	public static void abrirCredito(Context context, Conta conta) throws NamingException{

		AbrirPedidoCreditoRemote abrirPedidoCredito = (AbrirPedidoCreditoRemote)
							context.lookup("fiap-bank-ear/abrirPedidoCredito/remote");

		Credito credito = new Credito();
		credito.setNumeroMesesPagamento(6);
		credito.setValorCredito(300.00);

		abrirPedidoCredito.abrirPedidoCredito(credito, conta);

	}

	public static void consultarCredito(Context context, Conta conta) throws NamingException{
		
		ConsultarPedidoCreditoRemote consultarPedidoCredito = (ConsultarPedidoCreditoRemote)
									context.lookup("fiap-bank-ear/consultaPedidoCredito/remote");


		for(Credito credito : consultarPedidoCredito.consultarPedidosCredito(conta)){

			System.out.println(credito.getStatusCredito());

		}
	}
	
	
	public static void avaliarCredito(Context context) throws NamingException{
		
		AvaliarPedidosCreditoRemote avaliarPedidosCredito = (AvaliarPedidosCreditoRemote)
								context.lookup("fiap-bank-ear/avaliarPedidosCredito/remote");

		boolean stop = false;

		for(Credito credito :avaliarPedidosCredito.recuperarListaCreditos()){

			if((credito.getId() % 2) != 0){

				if(!stop){
					avaliarPedidosCredito.reprovarCredito(credito);
					stop = true;
				}
				else{
					avaliarPedidosCredito.aprovarCredito(credito);
					stop = false;
				}
			}
		}
	}
	
	public static void abrirConta(Context context) throws NamingException{
		
		AbrirContaRemote abrirConta = (AbrirContaRemote) context
		.lookup("fiap-bank-ear/abrirConta/remote");

		Correntista correntista = new Correntista();

		correntista.setGastoMensalAproximado(2.000);
		correntista.setRendaMensal(15.000);
		correntista.setValorTotalPatrimonio(1000.000);

		Banco banco = new Banco();
		banco.setId(1L);

		Agencia agencia = new Agencia();
		agencia.setBanco(banco);
		agencia.setId(1L);

		TipoConta tipoConta = new TipoConta();
		tipoConta.setId(1L);

		Conta conta = new Conta();
		conta.setAgencia(agencia);
		conta.setTipoConta(tipoConta);
		
		correntista.setConta(conta);

		Usuario usuario = new Usuario();

		usuario.setCpf("32167872810");
		usuario.setNome("Leandro Roberto Gonçalves");
		usuario.setRg("321507113");
		usuario.setTelefone("11 22169411");

		Endereco endereco = new Endereco();
		endereco.setBairro("Parque São Lucas");
		endereco.setCep("03262-030");
		endereco.setLogradouro("Rua Domingos Pires Brito");
		endereco.setMunicipio("São Paulo");
		endereco.setNumero("45");
		endereco.setUf("SP");

		usuario.setEndereco(endereco);
		correntista.setUsuario(usuario);

		conta = abrirConta.abrirConta(correntista,agencia);

		Seguranca seguranca = new Seguranca();

		seguranca.setFraseSecreta("teste");
		seguranca.setSenha("cliente");
		seguranca.setLogin("cliente");

		conta.setSeguranca(seguranca);

		abrirConta.adicionarSenha(conta,seguranca);
	}
}
