package com.lagou.controller;


import com.lagou.domain.PromotionSpace;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){
        List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();

        ResponseResult result = new ResponseResult(true, 200, "响应成功", allPromotionSpace);
        return result;
    }

    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace) {

        if (promotionSpace.getId() == null) {
            promotionSpaceService.savePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"响应cg",null);
        }else {
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            return  new ResponseResult(true,200,"响应成功",null);
        }
    }
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(@RequestParam Integer id){

        PromotionSpace promotionSpaceById = promotionSpaceService.findPromotionSpaceById(id);

        return  new ResponseResult(true,200,"响应成功",promotionSpaceById);
    }

}
