package com.lagou.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> userList = userMapper.findAllUserByPage(userVo);

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());

        return pageInfo;
    }

    @Override
    public User login(User user) throws Exception {

        User user2 = userMapper.login(user);
        if(user2 != null && Md5.verify(user.getPassword(),"lagou",user.getPassword())){
            return user2;
        }else {
            return null;
        }

    }

    @Override
    public List<Role> findUserRelationRoleById(int id) {

        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        return roleList;

    }

    @Override
    public void userContextRole(UserVo userVo) {
        userMapper.deleteUserContextRole(userVo.getUserId());
        for (Integer roleid : userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation);
        }

    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        List<Integer> list = new ArrayList<>();
        for (Role role : roleList) {
            list.add(role.getId());
        }
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(list);
        for (Menu menu : parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenu);
        }
        List<Resource> resourcesList = userMapper.findResourceByRoleId(list);

        Map<String,Object> map = new HashMap<>();
        map.put("menuList",parentMenu); //menuList: 菜单权限数据
        map.put("resourceList",resourcesList);//resourceList: 资源权限数据
        ResponseResult result = new ResponseResult(true,200,"响应成功",map);
        return result;

    }
}
