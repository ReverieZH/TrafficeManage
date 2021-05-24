package com.reverie.service;


import com.reverie.domain.Permission;
import com.reverie.domain.Role;

import java.util.List;

public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll(int page, int size);

    /**
     * 新增角色
     * @param role
     */
    public void save(Role role);

    /**
     * 根据rid查询角色信息
     * @param rid
     * @return
     */
    public Role findByRid(String rid);

    /**
     * 根据rid查询可以添加的其它权限
     * @param rid
     * @return
     */
    public List<Permission> findOtherPermissions(String rid);

    /**
     * 添加权限给角色
     * @param roleId
     * @param permissionIds
     */
    public void addPermissionToRole(String roleId, String[] permissionIds);

    /**
     * 修改权限信息
     * @param role
     */
    public void update(Role role);

    /**
     * 取消权限
     * @param roleId
     * @param permissionIds
     */
    public void deletePermissionToRole(String roleId, String[] permissionIds);

    /**
     * 根据角色名称和权限路径确定唯一的权限资源
     * @param roleName
     * @param url
     */
    public Boolean findPermissionUrlAndRoleName(String roleName, String url);

}
