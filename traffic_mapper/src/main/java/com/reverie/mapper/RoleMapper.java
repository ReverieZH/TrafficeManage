package com.reverie.mapper;


import com.reverie.domain.Permission;
import com.reverie.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface RoleMapper extends Mapper<Role> {
    /**
     * 根据rid查询出所有对应的角色
     * @param rid
     * @return
     */
    @Select("select * from tb_role where rid = #{rid}")
    @Results({
            @Result(id = true,column = "rid",property = "rid"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_desc",property = "roleDesc"),
            @Result(column = "rid",property = "permissions",javaType = List.class,many = @Many(select = "com.ogs.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    public List<Role> findRoleByRid(String rid);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_role")
    public List<Role> findAll();

    /**
     * 添加角色信息
     * @param role
     */
    @Insert("insert into tb_role (role_name,role_desc) values (#{roleName},#{roleDesc})")
    public void save(Role role);

    /**
     * 根据rid查询角色信息
     * @param rid
     * @return
     */
    @Select("select * from tb_role where rid=#{rid}")
    @Results({
            @Result(id = true,column = "rid",property = "rid"),
            @Result(column = "role_name",property = "roleName"),
            @Result(column = "role_desc",property = "roleDesc"),
            @Result(column = "rid",property = "permissions",javaType = List.class,many = @Many(select = "com.ogs.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    public Role findByRid(String rid);

    /**
     * 根据rid查询可以添加的其它权限
     * @param rid
     * @return
     */
    @Select("select * from tb_permission where id not in (select permission_id from tb_role_permission where role_id=#{rid})")
    public List<Permission> findOtherPermissions(@Param("rid") String rid);

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     */
    @Insert("insert into tb_role_permission(role_id,permission_id) values(#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

    /**
     * 根据rid删除tb_role_permission中间表的数据
     * @param roleId
     */
    @Delete("delete from tb_role_permission where role_id=#{roleId}")
    public void deleteFromRole_PermissionByRoleId(String roleId);

    /**
     * 根据rid删除role表中的数据
     * @param roleId
     */
    @Delete("delete from tb_role where rid=#{roleId}")
    public void deleteRoleById(String roleId);

    /**
     * 根据rid修改角色信息
     * @param role
     */
    @Update("update tb_role set role_name=#{roleName},role_desc=#{roleDesc} where rid=#{rid}")
    public void update(Role role);

    /**
     * 根据rid和permissionId删除tb_role_permission中间表的数据
     * @param roleId
     * @param permissionId
     */
    @Delete("delete from tb_role_permission where role_id=#{roleId} and permission_id=#{permissionId}")
    public void deletePermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);

}
