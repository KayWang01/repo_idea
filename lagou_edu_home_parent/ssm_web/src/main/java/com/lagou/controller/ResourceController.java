package com.lagou.controller;


import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    public ResponseResult  findAllResource(@RequestParam ResourceVo resourceVo){

        PageInfo<Resource> allResource = resourceService.findAllResource(resourceVo);

        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",allResource);

        return responseResult;

    }

}
