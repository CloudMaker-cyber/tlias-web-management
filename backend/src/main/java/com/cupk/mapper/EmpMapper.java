package com.cupk.mapper;

import com.cupk.pojo.Emp;
import com.cupk.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    //--------------------原始方法--------------------//
//    /**
//     * 获取总记录数
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();
//
//    /**
//     * 分页查询
//     */
//    @Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    //--------------------PageHelper分页方法--------------------//
    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")

    /**
     * 根据查询条件分页查询员工列表
     * @param empQueryParam
     * @return
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 插入员工信息
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")//获取插入数据的自增主键---MyBatis主键返回。insert方法调用后，emp对象的id属性会自动赋值。
    @Insert("insert into emp (username, name, gender, phone,job,salary,image,entry_date,dept_id,create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 根据id 批量删除员工信息
     * 动态SQL，在EmpMapper.xml映射文件中实现
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工信息及工作经历信息
     */
    Emp getById(Integer id);

    /**
     * 根据id更新员工信息
     */
    void updateById(Emp emp);
}
