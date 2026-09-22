package es.cursospring.springboot_web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoH2 implements ClienteDao {

	private final DataSource ds;
	private final ClienteProperties cliProp;
	
	@Autowired
	public ClienteDaoH2(DataSource ds, ClienteProperties cliProp) {
		this.ds = ds;
		this.cliProp = cliProp;
	}

	@Override
	public List<String> findAll() {
		List<String> resu = new LinkedList<>();
		try(Connection con = ds.getConnection()) {
			PreparedStatement ps = con.prepareStatement("select * from personas limit ?");
			ps.setInt(1, cliProp.getCantidadMaxima());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resu.add(rs.getString("nombre"));
			}
			
		} catch (SQLException e) {
			System.out.println("Fallo al crear la conexion");
			e.printStackTrace();
		}
		return resu;
	}

}
