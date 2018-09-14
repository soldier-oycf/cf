package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Date:2018/9/7
 * 展示接口
 */
public interface BrandService extends BaseService<TbBrand>{
    /**
     * 查询品牌所有数据
     * 返回 数据列表
     * @return
     */
    List<TbBrand> queryAll();

    /**
     * 测试通用mapper,进行整合
     * @param page
     * @param rows
     * @return
     */
    List<?> queryByPage(Integer page, Integer rows);

    PageResult search(Integer page, Integer rows, TbBrand tbBrand);

    List<Map<String,Object>> selectOptionList();
}
