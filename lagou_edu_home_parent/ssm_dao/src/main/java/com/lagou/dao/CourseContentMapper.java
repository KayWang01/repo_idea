package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseByCourseId(int courseId);

    public  void saveSection(CourseSection courseSection);

    public void updateSection(CourseSection section);

    public void updateSectionStatus(CourseSection section);

    public void saveLesson(CourseLesson lesson);

}
