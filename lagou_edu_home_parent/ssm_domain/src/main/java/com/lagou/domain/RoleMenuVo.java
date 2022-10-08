package com.lagou.domain;

import java.util.List;

public class RoleMenuVo {

    private Integer roleId;

    private List<Integer> menuIdLIst;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getMenuIdLIst() {
        return menuIdLIst;
    }

    public void setMenuIdLIst(List<Integer> menuIdLIst) {
        this.menuIdLIst = menuIdLIst;
    }

    @Override
    public String toString() {
        return "RoleMenuVo{" +
                "roleId=" + roleId +
                ", menuIdLIst=" + menuIdLIst +
                '}';
    }
}
