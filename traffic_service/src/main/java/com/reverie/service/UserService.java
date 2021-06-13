package com.reverie.service;

import com.reverie.domain.Platenumber;
import com.reverie.domain.User;

import java.util.List;

public interface UserService {
    public User selectByUserName(String username);

    public List<User> selectAll();

    public List<User> findUsernameLike(String usernameStr);

    public int delete(String username);

    public int deleteList(List<String> usernames);

    public int save(User user);

    public int update(User user);

    public int changeStatus(String username,String status);

    public boolean login(String username,String password);

    public boolean register(String username,String password,String phoneNumber);
}
