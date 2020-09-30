package cl.springboot.errores.app.errors;

public class UsuarioNoEncontradoException extends RuntimeException {

	public UsuarioNoEncontradoException(String id) {
		super("Usuario con el Id:".concat(id).concat(", no existe en la base de datos"));
	}

}
