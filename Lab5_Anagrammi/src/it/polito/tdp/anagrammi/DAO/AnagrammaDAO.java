package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import in.polito.tdp.anagrammi.model.Model;

public class AnagrammaDAO {

	private List<String> dizionario=new LinkedList<String>();
	
	
	public List<String> getDizionario() {
		return dizionario;
	}

	public void setDizionario(List<String> dizionario) {
		this.dizionario = dizionario;
	}
	
		
	public boolean  isCorrect(String parola){
		
		final String sql= "SELECT * FROM parola "
				+ "WHERE nome=?";

		boolean result;
		
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				result=true;
			}else {
				result=false;
			}
			
			conn.close();
			
			return result;
			
		}catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
			
			
	}
			
		
	}
	
