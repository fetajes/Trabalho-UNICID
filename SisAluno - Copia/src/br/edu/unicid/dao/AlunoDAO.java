package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
						+ "dataNascimento, endereco) values (?,?,?,?,?,?)";
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

}
