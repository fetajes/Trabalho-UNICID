package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Aluno aluno;
	
	public AlunoDAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			  throw new Exception("erro: \n" + e.getMessage());
		  }
		}
		
		//Salva aluno
		public void salvar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO tb_aluno (rgm, nome, email, "
						+ "dataNascimento, endereco) values (?,?,?,?,?)";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, aluno.getRgm());
				ps.setString(2,  aluno.getNome());
				ps.setString(3, aluno.getEmail());
				ps.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
				ps.setString(5, aluno.getEndereco());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao iserir dados "+ sqle);
		 } finally {
			ConnectionFactory.closeConnection(conn, ps);
	     }
     }
		
	 // Atualiza aluno
		public void atualizar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE INTO tb_aluno set nome=?, email=?, dataNascimento=?,"
						+"endereco=? WHERE rgm=?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getNome());
				ps.setString(2,  aluno.getEmail());
				ps.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
				ps.setString(4, aluno.getEndereco());
				ps.setInt(5, aluno.getRgm());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados "+ sqle);
		 } finally {
			ConnectionFactory.closeConnection(conn, ps);
	     }
     }
		
	//Excluir Aluno
		public void excluir(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "DELETE FROM tbm_aluno WHERE rgm = ?";
				conn = this.conn;
				ps.setInt(1, aluno.getRgm());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados "+ sqle);
		 } finally {
			ConnectionFactory.closeConnection(conn, ps);
	     }
     }
		
	//Procurar Aluno
		public Aluno procurarAluno(int rgm) throws Exception {
			
			try {
				String SQL = "SELECT * FROM tb_aluno WHERE rgm = ?";
				conn = this.conn;
				ps = conn.prepareStatement(SQL);
				ps.setInt(1, rgm);
				rs = ps.executeQuery();
				if (rs.next()) {
					int ca = rs.getInt(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					Date nascimento = rs.getDate(4);
					String endereco = rs.getString(5);
					aluno = new Aluno (ca, nome, email, nascimento, endereco);
				}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
		 } finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
	     
		 }
     }
		
	 // Listar todos os alunos
public List todosAlunos() throws Exception {
			
			try {
				conn = this.conn;
				ps = conn.prepareStatement("SELECT * FROM tb_aluno");
				rs = ps.executeQuery();
				List<Aluno> list = new ArrayList<Aluno>();
				while (rs.next()) {
					int ca = rs.getInt(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					Date nascimento = rs.getDate(4);
					String endereco = rs.getString(5);
					list.add(new Aluno (ca, nome, email, nascimento, endereco));
				}
				return list;
			} catch (SQLException sqle) {
				throw new Exception(sqle);
		 } finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
	     }
     }
}
