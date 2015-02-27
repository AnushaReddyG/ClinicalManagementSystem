package com.dop.cms.utilities;

import java.sql.*;

//database connection information
public class DatabaseConnection {

	
	
	
    /**
	 * @return the con
	 */
	//get DB connection
	public Connection getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	//set DB connection
	public void setCon(Connection con) {
		this.con = con;
	}

	/**
	 * @return the st
	 */
	public Statement getSt() {
		return st;
	}

	/**
	 * @param st the st to set
	 */
	public void setSt(Statement st) {
		this.st = st;
	}

	private Connection con;
    private Statement st;
    
    /** Creates a new instance of MYSQL */
    public void getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection(DBDetails.URL,DBDetails.USERNAME,DBDetails.PASSWORD );

    }
    //get SQL statement
    public Statement getStatement() throws SQLException{
        this.st = this.con.createStatement();
        return this.st;
    }
    //close SQL statement
    public void closeStatement() throws SQLException{
        this.st.close();
    }
    
    //close DB connection
    public void closeConnection() throws SQLException{
        this.con.close();
    }

    PreparedStatement PreparedStatement(String query) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
