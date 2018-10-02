/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
/**
 *
 * @author 759388
 */
public class UserService 
{
    public User login(String username, String password)
    {
        User adam = new User("adam","password");
        User betty = new User("betty", "password");
        
        if(username.equals(adam.getUsername()) && password.equals(adam.getPassword()))
        {
            adam.setPassword(null);
            return adam;
        }
        else if(username.equals(betty.getUsername()) && password.equals(betty.getPassword()))
        {
            betty.setPassword(null);
            return betty;
        }
        return null;
    }
}
