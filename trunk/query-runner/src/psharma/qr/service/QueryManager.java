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

import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.bean.QueryInfo;
import psharma.qr.bean.QueryResult;
import psharma.qr.dao.QueryResultDao;

public class QueryManager {

	public static void main(String[] args) {
		QueryManager qm = new QueryManager();
		QueryResult qr;
		QueryInfoManager qim = new QueryInfoManager();
		QueryInfo qi;
		qi = qim.getQueryInfo(2);
		String query = qi.getSqlQuery();
		ConInfoManager cim = new ConInfoManager();
		ConnectionInfo ci = new ConnectionInfo();
		ci = cim.getConnectionInfo(1);
		String param = "2";
		qr = qm.getQuery(qi, ci, param);
		// System.out.println(qr);

		for (String str : qr.getColumnName()) {

			System.out.println(str);
		}
		for (List<String> valueList : qr.getRows()) {
			for (String str : valueList) {
				System.out.println(str);

			}

		}

	}

	public QueryResult getQuery(QueryInfo qi, ConnectionInfo ci, String params) {
		QueryResultDao qrd = new QueryResultDao();
		QueryResult qr;
		qr = qrd.getQuery(qi, ci, params);
		return qr;

	}

}
