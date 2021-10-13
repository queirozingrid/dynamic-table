package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.UsuarioDAO;
import domain.Usuario;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class MBUsuario {
	private Usuario usuario;
	private List<Usuario> itens;
	
	
	@PostConstruct
    public void visualizar() {
        itens = new ArrayList<Usuario>(UsuarioDAO.visualizar());
    }
	
	public void cadastrar() {
		UsuarioDAO.cadastrar(usuario);
	}
	public List<Usuario> getItens() {
		return itens;
	}
	public void setItens(List<Usuario> itens) {
		this.itens = itens;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
