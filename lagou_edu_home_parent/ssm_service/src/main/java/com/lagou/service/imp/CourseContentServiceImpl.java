package com.lagou.service.imp;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;


    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(int courseId) {

        List<CourseSection> sectionList = courseContentMapper.findSectionAndLessonByCourseId(courseId);

        return sectionList;
    }

    @Override
    public Course findCourseByCourseId(int courseId) {

        Course course = courseContentMapper.findCourseByCourseId(courseId);

        return course;
    }

    @Override
    public void saveSection(CourseSection section) {

        Date date = new Date();
        section.setCreateTime(date);
        section.setUpdateTime(date);

        courseContentMapper.saveSection(section);

    }

    @Override
    public void updateSection(CourseSection section) {

        section.setUpdateTime(new Date());
        courseContentMapper.updateSection(section);
    }

    @Override
    public void updateSectionStatus(int id, int status) {

        CourseSection section = new CourseSection();
        section.setId(id);
        section.setStatus(status);
        section.setUpdateTime(new Date());

        courseContentMapper.updateSectionStatus(section);
    }

    @Override
    public void saveLesson(CourseLesson lesson) {
        Date date = new Date();
        lesson.setCreateTime(date);
        lesson.setUpdateTime(date);
        courseContentMapper.saveLesson(lesson);
    }
}
