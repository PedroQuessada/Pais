package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Pais;

public class PaisDAO {

	public int criar(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sql = "INSERT INTO Pais(nome, populacao, area) VALUES (?, ?, ?)";
		
		try (PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.executeUpdate();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pais.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.print("Erro ao criar o pais: "+ e);
		}
		return pais.getId();
	}
	
	public void atualizar(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sql = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		
		try (PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, pais.getNome());
			stm.setLong(2, pais.getPopulacao());
			stm.setDouble(3, pais.getArea());
			stm.setInt(4, pais.getId());
			stm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print("Erro ao atualizar o pais: "+e);
		}
	}
	
	public void deletar(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sql = "DELETE FROM pais WHERE id=?";
		
		try (PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, pais.getId());
			stm.executeUpdate();
		} catch (SQLException e) {
			System.out.print("Erro ao deletar o pais: "+e);
		}
	}
	
	public Pais carregar(int id) {
		Pais pais = new Pais();
		Connection conn = new ConnectionFactory().getConnection();
		String sql = "SELECT nome, populacao, area FROM pais WHERE id=?";
		
		try(PreparedStatement stm = conn.prepareStatement(sql)){ 
			stm.setInt(1, id);
			try(ResultSet rs = stm.executeQuery()){
				if(rs.next()) {
					pais.setId(id);
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				}
				
			}catch (SQLException e) {
				System.out.print("Erro ao carregar o pais: "+e);
			}
		} catch (SQLException e) {
			System.out.print("Erro ao carregar o pais: "+e);
		}
		
		return pais;
	}
	
	
	
	
	
	
	/*
	 ------------------------METODO JAMAL----------------------------------------------
	 
	 public Pais carregar(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sql = "SELECT nome, populacao, area FROM pais WHERE pais.id=?";
		
		try(PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, pais.getId());
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pais;
	}
	 
	 
	 */
	
	
	
	
	//selecionar maior populacao -----------------------------------------------------------------------------------
	public Pais maiorPopulacao(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sqlSelect = "SELECT nome, populacao, area, max(populacao) FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			ResultSet rs = stm.executeQuery();
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} 
		} 
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}
	
	//Menor Area------------------------------------------------------------------------
	public Pais menorArea(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		String sqlSelect = "SELECT nome, populacao, area, min(area) FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			ResultSet rs = stm.executeQuery();
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				} 
		} 
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pais;
	}
	
	//Retorna 3------------------------------------------------------------------------
	
	
	public Pais [] vetorTresPaises(Pais pais) {
		Connection conn = new ConnectionFactory().getConnection();
		Pais [] listaPais = new Pais[3];
		String sqlSelect = "SELECT nome, populacao, area FROM pais";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (PreparedStatement stm = conn.prepareStatement(sqlSelect)){
			ResultSet rs = stm.executeQuery();
			for(int i = 0; i < listaPais.length; i++) {
				if (rs.next()) {
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					listaPais[i] = pais;
				} 
			}
		} 
		catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return listaPais;
	}
}
