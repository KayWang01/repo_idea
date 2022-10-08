package com.lagou.controller;


import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAd")
    public ResponseResult findAllByPage(@RequestBody PromotionAdVo promotionAdVo){
        PageInfo<PromotionAd> allPromotionAdService = promotionAdService.findAllPromotionAdService(promotionAdVo);

        return new ResponseResult(true, 200, "响应成功", allPromotionAdService);
    }
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {


        //1.判断接收到的上传文件是否为空
        if(file.isEmpty()){
            throw  new RuntimeException();
        }

        //2.获取项目部署路径

        // D:\apache-tomcat-8.5.56\webapps\ssm-web\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\apache-tomcat-8.5.56\webapps
        String substring = realPath.substring(0, realPath.indexOf("ssm-web"));



        //3.获取原文件名
        //lagou.jpg
        String originalFilename = file.getOriginalFilename();

        //4.生成新文件名
        //12421321.jpg
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.文件上传

        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        // 如果目录不存在就创建目录
        if(!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录：" + filePath);
        }

        // 图片就进行了真正的上传
        file.transferTo(filePath);

        // 6. 将文件名和文件路径返回，进行响应
        Map<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);

        map.put("filePath","http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", map);

        return responseResult;
    }

    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){

        if(promotionAd.getId() == null){
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult(true,200,"响应成功","");
        }else {
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult(true,200,"响应成功","");
        }
    }

    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam int id){
        PromotionAd promotionAdById = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(true,200,"响应成功",promotionAdById);
    }

    public  ResponseResult updatePromotionAdStatus(@RequestParam int id ,@RequestParam int status){

        if(status == 1){
            promotionAdService.updatePromotionAdStatus(id,status);
        }else {
            promotionAdService.updatePromotionAdStatus(id,0);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);
        return new ResponseResult(true, 200, "响应成功", map);
    }
}