/**
-----------------------------------------------------------------------------
query-runner is available for use under the following license, commonly known
as the 3-clause (or "modified") BSD license:
-----------------------------------------------------------------------------
Copyright (c) 2013, Priyanka Sharma (sharmapriyanka334@gmail.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR 'AS IS' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
-----------------------------------------------------------------------------
 **/
package psharma.qr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import psharma.qr.bean.ConnectionInfo;

public class DatabaseConnectionManager {
	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static Connection getConnection() { Connection con = null; try {
	 * con = DriverManager
	 * .getConnection("jdbc:oracle:thin:@192.168.1.60:1521:XE", "pinki",
	 * "pri123"); } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return con; }
	 */
	public static Connection getConnection() {
		Connection con = null;
		String password = PropertyReader.getPassword();
		String url = PropertyReader.getUrl();
		String username = PropertyReader.getUsername();
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection(ConnectionInfo ci) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(ci.getUrl(), ci.getUsername(),
					ci.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public static void closeConnection(Connection con) {
		try {
			if ((con != null) && (!con.isClosed())) {
				con.close();
			}

		} catch (SQLException e) {
			// Do nothing
		}
	}
}
