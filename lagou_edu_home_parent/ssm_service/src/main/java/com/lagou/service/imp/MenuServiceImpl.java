package com.lagou.service.imp;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findSubMenuListByPid(int pid) {
        List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);
        return menuList;
    }

    @Override
    public List<Menu> findAllMenu() {

        List<Menu> menu = menuMapper.findAllMenu();
        return menu ;
    }

    @Override
    public Menu findMenuById(Integer id) {

        Menu menuById = menuMapper.findMenuById(id);
        return menuById;
    }
}
