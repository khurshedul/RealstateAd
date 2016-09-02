package adapters;

import java.sql.DriverManager;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
@MultipartConfig(maxFileSize = 16177215)

public class DataAccess{
	private String host = "localhost";
	private int port = 3306;
	private String database = "realestate";
	private String username = "root";
	private String password = "";
	private String connectionString;
	
	private Connection connection;
	private Statement statement;
	
	
	
	public DataAccess() {
		this.connectionString = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.connectionString, this.username, this.password);
			this.statement = this.connection.createStatement();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public DataAccess(String host, int port, String database, String username, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;
		
		this.connectionString = "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.connectionString, this.username, this.password);
			this.statement = this.connection.createStatement();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ResultSet getResultSet(String sql) {
		try {
			return this.statement.executeQuery(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public int executeQuery(String sql) {
		try {
			return this.statement.executeUpdate(sql);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return 0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}
//file upload
	public int executeQueryFile(HttpServletRequest request, String username) {
		
		InputStream inputStream = null;
		try{
			Part filePart = request.getPart("file");
			String title=(request.getParameter("title"));
			if (filePart != null) 
	        {
	            System.out.println(filePart.getSubmittedFileName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());

	            inputStream = filePart.getInputStream();
	        }
            String sql = "INSERT INTO property (title, username, pic1) values (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, username);
     
            if (inputStream != null) 
            {
                statement.setBinaryStream(3, inputStream, (int) filePart.getSize());
            }
            
            int row = statement.executeUpdate();
            if (row > 0) 
            {
            	connection.close();
                return 1;
                
            }
            else
            {
                //out.println("Couldn't upload your file!!!");
                
                connection.close();
                return 0;
            } 
			
		}catch(Exception e){
			return 0;
		}
	}
	
//file upload
	protected void finalize() {
		try {
			this.statement.close();
			this.connection.close();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setHost(String host) {this.host = host;}
	public void setPort(int port) {this.port = port;}
	public void setDatabase(String database) {this.database = database;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	
	public String getHost() {return this.host;}
	public int getPort() {return this.port;}
	public String getDatabase() {return this.database;}
	public String getUsername() {return this.username;}
	public String getPassword() {return this.password;}
	public String getConnectionString() {return this.connectionString;}
}