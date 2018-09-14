package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public PageResult findPage(@RequestParam(name="page",defaultValue = "1") Integer page,@RequestParam(name = "rows",defaultValue ="10")Integer rows
                                ){

        PageResult byPage = brandService.findByPage(page,rows);

        return byPage;
    }

    //带查询参数的前端品牌查询
    @PostMapping("/search")
    public PageResult search(@RequestParam(name="page",defaultValue = "1") Integer page,@RequestParam(name = "rows",defaultValue ="10")Integer rows,
                             @RequestBody TbBrand tbBrand){

        PageResult byPage = brandService.search(page,rows,tbBrand);

        return byPage;
    }


    /**
     * 商品新增方法
     */
    @PostMapping("/save")
    public Result save(@RequestBody TbBrand tbBrand){

        try {
            brandService.save(tbBrand);
            return new Result(true,"保存成功");

        } catch (Exception e) {
            e.printStackTrace();
        return new Result(false,"保存失败!!!");
        }

    }

    /**
     * 修改品牌进行数据回显查询单个对象
     */
    @GetMapping("/findOne")
    public TbBrand findOne(Long id){

        TbBrand tbBrand = brandService.findOne(id);

        return  tbBrand;
    }

    /**
     * 修改成功济宁数据保存
     */
    @PostMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){

        try {
            brandService.update(tbBrand);
            return new Result(true,"修改成功");

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败!!!");
        }

    }

    /**
     * 批量删除品牌
     */
    @GetMapping("/delete")
    public Result delete(Long[] ids){

        System.out.println(Arrays.toString(ids));
        try {
            brandService.deletes(ids);
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("删除失败");
        }

    }

    //查询品牌返回id和name即可
    @GetMapping("/findBrandList")
    public List<Map<String,Object>> findBrandList(){

        List<Map<String, Object>> list = brandService.selectOptionList();
        return list;
    }

}
