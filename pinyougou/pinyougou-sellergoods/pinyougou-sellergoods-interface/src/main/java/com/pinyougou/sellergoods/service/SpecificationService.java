package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Specification;

import java.util.List;
import java.util.Map;

public interface SpecificationService extends BaseService<TbSpecification> {

    PageResult search(Integer page, Integer rows, TbSpecification specification);

    /**
     * 保存规格和规格选项
     * @param specification
     */
    void add(Specification specification);

    /**
     * 查询数据进行回线数据
     */
    Specification findOne(Long id);


    void update(Specification tbSpecification);

    List<Map<String,Object>> findSpecification();
}