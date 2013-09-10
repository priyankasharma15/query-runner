package psharma.qr.dao;

import psharma.qr.bean.UserInfo;

public interface UserLogInDao {

	UserInfo getLogIn(String username);

}
