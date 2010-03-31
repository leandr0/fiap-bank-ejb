/**
 * 
 */
package br.com.fiap.web.form;

/**
 * @author leandro.goncalves
 *
 */
public class AbrirPedidoCreditoForm {

	private boolean confirmarPedido = false;
	
	private boolean valid;
	
	private String mensagem;

	public boolean isConfirmarPedido() {
		return confirmarPedido;
	}

	public void setConfirmarPedido(boolean confirmarPedido) {
		this.confirmarPedido = confirmarPedido;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
