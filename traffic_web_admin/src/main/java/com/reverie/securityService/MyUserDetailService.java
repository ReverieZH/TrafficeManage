package com.reverie.securityService;


import com.reverie.domain.Operator;
import com.reverie.mapper.OperatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public UserDetails loadUserByUsername(String jobNumber) throws UsernameNotFoundException {
        //调用usersMapper方法查询数据库
        Operator operator=operatorMapper.loginSelect(jobNumber);
        System.out.println("------------------jobNUmber---------------"+jobNumber);
        System.out.println(operator);
        if(operator==null){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_"+operator.getRole().getRoleName());
        //从查询数据库返回users对象，得到用户名和密码,返回
        return new User(operator.getJobnumber(),new BCryptPasswordEncoder().encode(operator.getPassword()),auths);
    }
}
