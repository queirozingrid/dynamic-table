package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import domain.Usuario;
import util.JPAUtil;

public class UsuarioDAO {
private static EntityManager gerenciador;
	
	public static void cadastrar(Usuario usuario) {
		try {
			gerenciador = JPAUtil.getEntityManager();
			gerenciador.getTransaction().begin();
			gerenciador.persist(usuario);
			gerenciador.getTransaction().commit();
			System.out.println("Cadastrado com sucesso!");
			//JsfUtil.mensagemSucesso("Cliente cadastrado com sucesso!");
			visualizar();
			
		} catch(Exception e) {
			gerenciador.getTransaction().rollback();
			//JsfUtil.mensagemError(e.getMessage());

		} finally { 
			gerenciador.close();
			
		}
		
	}
	public static ArrayList<Usuario> visualizar() {
		String jpql = "select u from Usuario u";
		ArrayList<Usuario> consulta;
		
		try {
			gerenciador = JPAUtil.getEntityManager();
			gerenciador.getTransaction().begin();
			consulta = (ArrayList<Usuario>) gerenciador.createQuery(jpql, Usuario.class).getResultList();
			
			for (Usuario usuario : consulta) {
				System.out.println(usuario.getNome());
			}
			return consulta;
			
		} catch(Exception e) {
			gerenciador.getTransaction().rollback();
			System.out.println("entrei no exception");
			e.printStackTrace();
			return null;
		} finally {
			gerenciador.close();
		}
	}

}
