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
package psharma.qr.service;

import java.util.ArrayList;
import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.dao.ConInfoDao;
import psharma.qr.dao.ConInfoDaoImp;

public class ConInfoManager {

	public static void main(String[] args) {
		ConInfoManager ob = new ConInfoManager();
		List<ConnectionInfo> list = new ArrayList<ConnectionInfo>();
		list = ob.getConInfo();
		System.out.println(list);
		ConnectionInfo ci = new ConnectionInfo();
		ci = ob.getConnectionInfo(1);
		System.out.println(ci);
		ConnectionInfo c = new ConnectionInfo();
		c.setId(2);
		c.setGroupName("QAC");
		c.setConnectionName("Test");
		c.setConnectionDescription("new");
		c.setUrl("ab");
		c.setUsername("pinki");
		c.setPassword("pri123");
		c.setStatus("Y");
		ob.saveConnectionInfo(c);
		System.out.println(c);
	}

	public List<ConnectionInfo> getConInfo() {

		List<ConnectionInfo> list = new ArrayList<ConnectionInfo>();
		ConInfoDao ob = new ConInfoDaoImp();
		list = ob.getConInfo();

		return list;
	}

	public ConnectionInfo getConnectionInfo(int idm) {
		ConnectionInfo ci = new ConnectionInfo();
		ConInfoDao ob = new ConInfoDaoImp();
		ci = ob.getConInfo(idm);
		return ci;
	}

	public void addConnectionInfo(ConnectionInfo ci) {
		ConInfoDao ob = new ConInfoDaoImp();
		ob.addConnectionInfo(ci);
	}

	public void saveConnectionInfo(ConnectionInfo ci) {
		ConInfoDao ob = new ConInfoDaoImp();
		ob.saveConnectionInfo(ci);
	}
}
