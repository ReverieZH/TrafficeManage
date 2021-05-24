package com.reverie.service.impl;

import com.github.pagehelper.PageHelper;
import com.reverie.domain.Permission;
import com.reverie.domain.Role;
import com.reverie.mapper.RoleMapper;
import com.reverie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll(int page, int size) {
        //参数pageNum是页码值，参数pageSize代表的是每页显示条数
        PageHelper.startPage(page,size);
        return roleMapper.selectAll();
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public Role findByRid(String rid) {
        return roleMapper.findByRid(rid);
    }

    @Override
    public List<Permission> findOtherPermissions(String rid) {
        return roleMapper.findOtherPermissions(rid);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleMapper.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Override
    public void deletePermissionToRole(String roleId, String[] permissionIds) {
        for(String permissionId:permissionIds){
            roleMapper.deletePermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public Boolean findPermissionUrlAndRoleName(String roleName, String url) {
        //根据roleName获取rid
        Role record = new Role();
        record.setRoleName(roleName);
        Integer rid = roleMapper.select(record).get(0).getRid();
        //根据rid获取role
        Role role = roleMapper.findByRid(rid.toString());
        //在role中的permissions中查询是否包含roleName
        List<Permission> permissions = role.getPermissions();
        List<String> urls = new ArrayList<>();
        for (Permission permission : permissions) {
            urls.add(permission.getUrl());
        }
        return urls.contains(url);
    }
}
