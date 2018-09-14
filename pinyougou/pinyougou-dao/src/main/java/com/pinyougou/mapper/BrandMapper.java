package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Date:2018/9/7
 * 商品实体类
 */
public interface BrandMapper extends Mapper<TbBrand>{
    /*
    查询所有数据
     */
    public List<TbBrand> queryAll();

    List<Map<String,Object>> selectOptionList();
}
