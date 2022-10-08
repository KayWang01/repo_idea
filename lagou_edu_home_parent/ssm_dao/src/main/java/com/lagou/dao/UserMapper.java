package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface UserMapper {

    public List<User> findAllUserByPage(UserVo userVo);

    public User login(User user);

    public List<Role> findUserRelationRoleById(int id);

    /*
根据用户ID清空中间表
*/
    public void deleteUserContextRole(Integer userId);
    /*
    分配角色
    */
    public void userContextRole(User_Role_relation user_role_relation);


    /**
     * 根据角色id,查询角色拥有的顶级菜单信息
     * */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);
    /**
     * 根据PID 查询子菜单信息
     * */
    public List<Menu> findSubMenuByPid(int pid);
    /**
     * 获取用户拥有的资源权限信息
     * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);
    
    public List<Resource> findResourceByUser(List<Integer> ids);

    public void add2();
    public void add3();
    public void add3();
    public void add5();
    public void add1();
    public void add2();
    public void add3();
    public void add4();
}
