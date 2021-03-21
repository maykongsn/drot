package br.com.pi.drot.dto;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.pi.drot.connection.Connection;
import br.com.pi.drot.dao.UsuarioDAO;
import br.com.pi.drot.entity.Usuario;
import br.com.pi.drot.utils.NameDataBaseConnection;

public class UsuarioDTO implements UsuarioDAO {

	private Connection connection;

	public UsuarioDTO(NameDataBaseConnection nameDataBaseConnection) {
		this.connection = new Connection(nameDataBaseConnection.getNameDataBase());
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean cadastrarUsuario(Usuario usuario) {
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().persist(usuario);
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		return true;
	}

	@Override
	public Usuario buscarUsuarioPorID(int id) {
		Usuario usuario = this.getConnection().getEntityManager().find(Usuario.class, id);

		if(usuario == null){
			System.out.println("Usuário não encontrado");
		}

		this.getConnection().getEntityManager().close();
		return usuario;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		this.getConnection().getEntityManager();
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) this.getConnection().getEntityManager().createQuery("from Usuario", Usuario.class).getResultList();
		this.getConnection().getEntityManager().close();

		return usuarios;
	}

	@Override
	public boolean editar(Usuario usuario) {
		return false;
	}

	@Override
	public boolean removerPorId(int id) {
		Usuario usuario = this.getConnection().getEntityManager().find(Usuario.class, id);

		if(usuario == null){
			System.out.println("Usuário não encontrado");
			return false;
		}

		this.getConnection().getEntityManager().remove(id);
		this.getConnection().getEntityManager().getTransaction().begin();
		this.getConnection().getEntityManager().getTransaction().commit();
		this.getConnection().getEntityManager().close();

		System.out.println("Usuário removido do banco com sucesso");

		return true;
	}

	@Override
	public boolean removerPorUsuario(Usuario usuario) {
		return false;
	}

}
