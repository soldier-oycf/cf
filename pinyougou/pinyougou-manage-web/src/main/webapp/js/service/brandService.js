pinyougou.service("brandService",function($http){
//查询所有数据列表
    this.findByBrands=function(){
        return $http.get("../brand/findAll.do");
    };




    this.search=function(page,rows,searchentity){//?page="+page+"&rows="+rows,$scope.searchentity
        return $http.post("../brand/search.do?page="+page+"&rows="+rows,searchentity);

    };
//分页查询
    this.findPage=function(page,rows){
       return $http.get("../brand/findPage.do?page="+page+"&rows="+rows);
    };

    /**
     *
     *品牌新增数据
     */
    this.save=function(entity){
        var model="save";
        if(entity.id!=null){
            model="update";
        }
        return $http.post("../brand/"+model+".do",entity);
    };

    /**
     *修改品牌数据对数据进行回显
     */
    this.findOne=function(id){
        return $http.get("../brand/findOne.do?id="+id);

    };

    /**
     *点击删除发送选中的id
     */
    this.delete=function(ids){
        return $http.get("../brand/delete.do?ids="+ids);
    };

    //查询品牌下拉列表
    this.findBrandLists = function () {
        return $http.get("../brand/findBrandList.do");
    }

});
