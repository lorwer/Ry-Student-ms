package com.ruoyi.system.mapper;

import com.ruoyi.common.core.domain.entity.SysCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 课程管理 数据层
 * 
 * @author lorwer
 */
public interface SysCourseMapper
{
    /**
     * 查询课程数据
     * 
     * @param course 课程信息
     * @return 课程信息集合
     */
    public List<SysCourse> selectCourseList(SysCourse course);

    /**
     * 根据用户ID查询课程信息
     * 
     * @param userId 用户ID
     * @return 课程列表
     */
    public List<SysCourse> selectCourseListByUserId(@Param("userId") Long userId);

    /**
     * 根据课程ID查询信息
     * 
     * @param courseId 课程ID
     * @return 课程信息
     */
    public SysCourse selectCourseById(Long courseId);

    /**
     * 查询课程是否存在选课学生
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    public int checkCourseExistStu(Long courseId);

    /**
     * 查询课程是否存在任课教师
     *
     * @param courseId 课程ID
     * @return 结果
     */
    public int checkCourseExistTea(Long courseId);

    /**
     * 校验课程名称是否唯一
     * 
     * @param courseName 课程名称
     * @return 结果
     */
    public SysCourse checkCourseNameUnique(@Param("courseName") String courseName);

    /**
     * 新增课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    public int insertCourse(SysCourse course);

    /**
     * 修改课程信息
     * 
     * @param course 课程信息
     * @return 结果
     */
    public int updateCourse(SysCourse course);

    /**
     * 修改所在课程正常状态
     * 
     * @param courseIds 课程ID组
     */
    public void updateCourseStatusNormal(Long[] courseIds);


    /**
     * 删除课程信息
     * 
     * @param courseId 课程ID
     * @return 结果
     */
    public int deleteCourseById(Long courseId);
}
