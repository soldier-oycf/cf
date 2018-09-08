package com.pinyougou.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/9/7
 */
public abstract class BaseServiceImpl<T>  implements BaseService<T>{

    //注入Mapper
    @Autowired
    private Mapper<T> mapper;


    @Override
    public T findOne(Serializable id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> findByWhere(T t) {
        return mapper.select(t);
    }

    @Override
    public PageResult findByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<T> list = mapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        PageResult result = new PageResult(pageInfo.getList(),pageInfo.getTotal());
        return result;
    }


    @Override
    public PageResult findByPage(Integer page, Integer rows, T t) {
        //设置分页
        PageHelper.startPage(page,rows);
        //进行条件查询
        List<T> list = mapper.select(t);
        //使用pageinfo进行参数封装
        PageInfo<T> info = new PageInfo<T>(list);
        //再次封装到自定义的对象中参数,是当前页数据和总记录数
        PageResult result = new PageResult(info.getList(),info.getTotal());
        return result;
    }

    @Override
    public void save(T t) {
        //保存信息数据
        mapper.insertSelective(t);
    }

    @Override
    public void update(T t) {
        //更新数据信息
        mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public void deletes(Serializable[] ids) {
        //批量进行删除数据使用循环方式
        if(ids != null && ids.length > 0){
            for (Serializable id : ids){
                mapper.deleteByPrimaryKey(id);
            }
        }
    }
}
