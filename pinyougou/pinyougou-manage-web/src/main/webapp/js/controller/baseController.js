pinyougou.controller("baseController",function ($scope) {
    $scope.paginationConf={
        currentPage:1,//当前页号
        totalItems:10,//总记录数
        itemsPerPage:10,//页大小
        perPageOptions:[1,10,20,30,40],//可选择的每页大小
        onChange:function(){//当上述的参数发生了变化后出发
            $scope.reloadList();

        }
    };

//加载分页数据
    $scope.reloadList=function(){
//调用分页方法查询分页数据
//$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
    }

    $scope.ids=[];

    $scope.updaeSelections=function($event,id){

        if($event.target.checked){
            $scope.ids.push(id);

        }else{
            var index=$scope.ids.indexOf(id);
            $scope.ids.splice(index,1);
        }

    }

    //将一个json数组格式字符串的某个key对应的值串起来显示,使用,分割
    $scope.jsonToString = function (jsonStr,key){


        var str = "";
        var jsonArray = JSON.parse(jsonStr);

        for (var i = 0; i < jsonArray.length;i++){

            var  obj = jsonArray[i];
            if (i > 0){
                str+=",";
            }
            str+=obj[key];
        }
        return str;
    }



});