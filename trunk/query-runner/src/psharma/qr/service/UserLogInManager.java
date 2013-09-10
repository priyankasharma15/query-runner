package psharma.qr.service;


import psharma.qr.bean.UserInfo;
import psharma.qr.dao.UserLogInDao;
import psharma.qr.dao.UserLogInDaoImp;


public class UserLogInManager {

	/*
	 * public static void main(String[] args) { UserLogInManager obj = new
	 * UserLogInManager(); UserInfo ussend = new UserInfo();
	 * ussend.setUsername(""); ussend.setPassword("");
	 * 
	 * System.out.println(obj.validatePassword(ussend)); }
	 */

	public boolean validatePassword(UserInfo us1) {
		System.out.println(us1);
		boolean result;
		UserLogInDao ob = new UserLogInDaoImp();
		UserInfo us;
		us = ob.getLogIn(us1.getUsername());
		System.out.println(us);
		if (us1.getUsername() == null) {
			result = false;
		} else if (us1.getPassword() == null) {
			result = false;
		} else if (us == null) {
			result = false;
		} else if ((us.getPassword().equals(us1.getPassword()))
				&& (us.getStatus().equals("Active"))) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
