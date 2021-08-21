package mau2.dao;

import mau2.entity.User;

public class UserDao {
    public boolean checkUser(User user){
        if(user !=null){
            if("admin".equals(user.getUsername())&&"admin".equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
