package com.reverie.service.impl;

import com.reverie.domain.User;
import com.reverie.mapper.UserMapper;
import com.reverie.service.UserService;
import com.reverie.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.ejb.DuplicateKeyException;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
   @Autowired
    private UserMapper userMapper;
    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> findUsernameLike(String usernameStr) {
        String username="%"+usernameStr+"%";
        return userMapper.findUsernameLike(username);
    }

    @Override
    public int delete(String username) {
        return userMapper.deleteByPrimaryKey(username);
    }

    @Override
    public int deleteList(List<String> usernames) {
        return 0;
    }

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int changeStatus(String username, String status) {
        User user=new User();
        user.setUsername(username);
        user.setValid(status);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user=new User();
        user.setUsername(username);
        String pass_md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(pass_md5);
        User selectOne = userMapper.selectOne(user);
        if(selectOne!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean register(String username, String password, String phoneNumber) {
        User user=new User();
        user.setUsername(username);
        String pass_md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(pass_md5);
        user.setPhonenumber(phoneNumber);
        user.setValid("1");
        user.setType("0");
        try{
            int insert = userMapper.insert(user);
            if(insert>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                return false;
            }else{
                throw e;
            }
        }
    }


}
