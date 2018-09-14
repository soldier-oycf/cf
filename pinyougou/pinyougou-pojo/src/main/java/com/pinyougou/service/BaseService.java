package com.pinyougou.service;

import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/9/7
 */
public interface BaseService<T> {

    //根据主键查询: 可以接受各种参数类型的主键,等效于Object
       T findOne(Serializable id);
    //查询所有
        List<T> findAll();
    //根据条件查询:属性值不为null则为查询条件
        List<T> findByWhere(T t);
    //根据分页查询
        PageResult findByPage(Integer page,Integer rows);
    //查询分页条件查询
        PageResult findByPage(Integer page, Integer rows, T t);
     //新增
        void save(T t);
    //修改
        void update(T t);

    //批量删除
        void  deletes(Long[] ids);


}
