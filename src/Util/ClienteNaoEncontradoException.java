package Util;

public class ClienteNaoEncontradoException extends Exception{
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(Integer codigo) {
		super(codigo.toString());
	}

}
