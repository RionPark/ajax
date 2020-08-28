package com.ui.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnection;
import org.apache.tomcat.dbcp.dbcp2.PoolableConnectionFactory;
import org.apache.tomcat.dbcp.dbcp2.PoolingDriver;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPool;
import org.apache.tomcat.dbcp.pool2.impl.GenericObjectPoolConfig;

@WebServlet(loadOnStartup = 1,urlPatterns = "/dbcp2")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = -2273647679784828245L;
	private static final String URL;
	private static final String ID;
	private static final String PWD;
	private static final String DRIVER_NAME;
	static {
		InputStream is = InitServlet.class.getClassLoader().getResourceAsStream("resources/db.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		URL = prop.getProperty("URL");
		ID = prop.getProperty("ID");
		PWD = prop.getProperty("PWD");
		DRIVER_NAME = prop.getProperty("DRIVER_NAME");
	}
	public void init() {
		initDBCP2();
	}

	private void initDBCP2() {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		ConnectionFactory cf = new DriverManagerConnectionFactory(URL, ID, PWD);
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, null);
		GenericObjectPoolConfig<PoolableConnection> gopc = new GenericObjectPoolConfig<>();
		gopc.setTimeBetweenEvictionRunsMillis(1000 * 60 * 10);
		gopc.setTestWhileIdle(true);
		gopc.setMinIdle(4);
		gopc.setMaxTotal(20);

		GenericObjectPool<PoolableConnection> gop = new GenericObjectPool<>(pcf, gopc);
		pcf.setPool(gop);
		try {
			Class.forName("org.apache.tomcat.dbcp.dbcp2.PoolingDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("jwc", gop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static final Connection getConnection() {
		String jdbcDriver = "jdbc:apache:commons:dbcp:jwc";
		try {
			Connection con = DriverManager.getConnection(jdbcDriver);
			con.setAutoCommit(false);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(PreparedStatement ps, Connection conn) {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(InitServlet.class.getClassLoader().getResourceAsStream("resources/mybatis-config.xml"));
		try(SqlSession ss = ssf.openSession()){
			List<Map<String,Object>> memberList = ss.selectList("Member.selectMember");
		}
	}
}





