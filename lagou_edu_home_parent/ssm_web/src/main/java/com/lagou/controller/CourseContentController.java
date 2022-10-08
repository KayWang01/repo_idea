package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam int courseId){

        List<CourseSection> sectionList = courseContentService.findSectionAndLessonByCourseId(courseId);

        ResponseResult result = new ResponseResult(true,200,"响应成功",sectionList);

        return result;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(@RequestParam int courseId){

        Course course = courseContentService.findCourseByCourseId(courseId);
        ResponseResult result = new ResponseResult(true,200,"响应成 功",course);

        return result;
    }

    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestParam CourseSection section){

        if(section.getId() == null){
            courseContentService.saveSection(section);
            return new ResponseResult(true,200,"响应成功",null);

        }else {
            courseContentService.updateSection(section);
            return new ResponseResult(true,200,"响应成功",null);
        }

    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(@RequestParam int id,@RequestParam int status){

        courseContentService.updateSectionStatus(id,status);

        Map<String,Integer> map = new HashMap<>();
        map.put("status",status);

        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
        return result;
    }

    @RequestMapping("/saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson lesson){
        courseContentService.saveLesson(lesson);
        return new ResponseResult(true,200,"响应成功",null);
    }


}