package es.cursospring.springcore.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ClienteDaoH2 implements ClienteDao {

	private final DataSource ds;
	
	public ClienteDaoH2(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void findAll() {
		try(Connection con = ds.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from personas");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al crear la conexion");
			e.printStackTrace();
		}
	}

}
