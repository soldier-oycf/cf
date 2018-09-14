pinyougou.controller("brandController",function($scope,$controller,brandService){

    //继承baseController
    $controller("baseController",{$scope:$scope});


    $scope.findByBrands=function(){
        brandService.findByBrands()
            .success(function(brand){
                $scope.list=brand;
            })
            .error(function(data){alert(data)});
    }



    $scope.searchentity={};
//条件查询
    $scope.search=function(page,rows){//?page="+page+"&rows="+rows,$scope.searchentity
        brandService.search(page,rows,$scope.searchentity).success(function(data){
//更新记录数据

            $scope.list=data.rows;
//更新总记录数
            $scope.paginationConf.totalItems=data.total;
        })
    }
//分页查询
    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows)
            .success(function(data){
//更新记录数据
                $scope.list=data.rows;
//更新总记录数
                $scope.paginationConf.totalItems=data.total;
            });
    }

    /**
     *
     *品牌新增数据
     */
    $scope.save=function(){

        brandService.save($scope.entity)
            .success(function(data){
                if(data.success){
                    alert(data.msg);
                    $scope.reloadList();
                }else{
                    alert(data.msg);
                }
            });


    }

    /**
     *修改品牌数据对数据进行回显
     */
    $scope.findOne=function(id){
        brandService.findOne(id)
            .success(function(data){
                $scope.entity=data;
            });
    }

    /**
     *发送删除请求根据id进行
     */
//注意这个数组需要放在全局中不可以放在函数里面


    /**
     *点击删除发送选中的id
     */
    $scope.delete=function(){
        if($scope.ids.length<=0){
            alert("未选择删除品牌");
            return;
        }

        if(!confirm("亲确定删除吗?")){
            return;
        }
        brandService.delete($scope.ids)
            .success(function(data){
                if(data.success){

                    alert(data.msg);
                    $scope.ids=[];
                    $scope.reloadList();
                }else{
                    alert(data.msg);
                }
            });

    }
});
