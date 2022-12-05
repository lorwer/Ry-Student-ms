package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysCourse;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysCourseMapper;
import com.ruoyi.system.service.ISysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程管理 服务实现
 * 
 * @author lorwer
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService
{
    @Autowired
    private SysCourseMapper courseMapper;

    /**
     * 查询课程数据
     * 
     * @param course 封装的查询条件
     * @return 课程信息集合
     */
    @Override
    public List<SysCourse> selectCourseList(SysCourse course)
    {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 根据用户ID查询课程信息
     * 
     * @param userId 用户ID
     * @return 课程列表
     */
    @Override
    public List<SysCourse> selectCourseListByUserId(Long userId)
    {
        return courseMapper.selectCourseListByUserId(userId);
    }

    /**
     * 根据课程ID查询课程信息
     * 
     * @param courseId 课程ID
     * @return 课程信息
     */
    @Override
    public SysCourse selectCourseById(Long courseId)
    {
        return courseMapper.selectCourseById(courseId);
    }

    /**
     * 查询课程是否存在选课学生
     * 
     * @param courseId 课程ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkCourseExistStu(Long courseId)
    {
        int result = courseMapper.checkCourseExistStu(courseId);
        return result > 0;
    }

    /**
     * 查询课程是否存在任课教师
     *
     * @param courseId 课程ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkCourseExistTea(Long courseId)
    {
        int result = courseMapper.checkCourseExistTea(courseId);
        return result > 0;
    }

    /**
     * 校验课程名称是否唯一
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public String checkCourseNameUnique(SysCourse course)
    {
        Long courseId = StringUtils.isNull(course.getCourseId()) ? -1L : course.getCourseId();
        SysCourse info = courseMapper.checkCourseNameUnique(course.getCourseName());
        if (StringUtils.isNotNull(info) && info.getCourseId().longValue() != courseId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int insertCourse(SysCourse course)
    {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改保存课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int updateCourse(SysCourse course)
    {
        return courseMapper.updateCourse(course);
    }

    /**
     * 删除课程管理信息
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    @Override
    public int deleteCourseById(Long courseId)
    {
        return courseMapper.deleteCourseById(courseId);
    }

    /**
     * 修改所在课程正常状态
     *
     * @param courseIds 课程ID组
     */
    public void updateCourseStatusNormal(Long[] courseIds) {
        courseMapper.updateCourseStatusNormal(courseIds);
    }

}
