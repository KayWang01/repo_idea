package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    public List<Role> findAllRole(Role role);

    public List<String> findMenuByRoleId(Integer id);

    public void RoleContextMenu(Role_menu_relation role_menu_relation);

    public void deleteRoleContextMenu(Integer rId);

    public void deleteRole(Integer id);
}
