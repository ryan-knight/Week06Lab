/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author 763198
 */
public class UserService
{
    private ArrayList<User> userList;
    
    public UserService()
    {
        userList = new ArrayList<>();
        userList.add(new User("betty", "password"));
        userList.add(new User("adam", "password"));
    }
    
    public User login(String username, String password)
    {
        User user = new User(username, password);
        
        for(User u:userList)
        {
            if(user.equals(u))
                return user;
        }
        return null;
    }
}
