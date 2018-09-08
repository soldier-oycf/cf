package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date:2018/9/7
 */
@RequestMapping("/brand")
@RestController
public class BrandController {

    //引入接口
    @Reference//改接口来自阿里巴巴,比是其他的
    private BrandService brandService;

    /**
     * 测试通用mapper,进行分页查询
     * @return
     */
    @GetMapping("/findByPage")
    public List<TbBrand> findByPage(@RequestParam(name="page",defaultValue = "1") Integer page,@RequestParam(name = "rows",defaultValue ="10")Integer rows){

//       List<TbBrand> tbBrands = brandService.queryByPage(page,rows);
        PageResult byPage = brandService.findByPage(page, rows);

        return (List<TbBrand>) byPage.getRows();
    }


    @GetMapping("/findAll")
    public List<TbBrand> findAll(){
       // return  brandService.queryAll();
        return brandService.findAll();
    }

    /**
     * 前端品牌查询
     */
    @GetMapping("/findPage")
    public PageResult findPage(@RequestParam(name="page",defaultValue = "1") Integer page,@RequestParam(name = "rows",defaultValue ="10")Integer rows){
        PageResult byPage = brandService.findByPage(page,rows);

        return byPage;
    }

}
