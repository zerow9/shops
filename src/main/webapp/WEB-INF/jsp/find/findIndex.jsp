<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 30px">
    <div class="hang-1">
        <input type="text" name="searchKey" placeholder="输入索引..."/>
    </div>

   <%-- 索引重构，索引删除，查询--%>
    <div class="hang-butt">
        <a href="#"><button lay-submit lay-filter="find" class="myButton"><i class="fa fa-search"></i>查询</button></a>
        <a href="#"><button lay-submit lay-filter="find1" class="indexRest"><i class="fa fa-cog fa-spin"></i>&nbsp;索引重构</button></a>
        <a href="#"><button lay-submit lay-filter="find2" class="indexDelete" ><i class="fa fa-trash-o fa-fw"></i>&nbsp;索引删除</button></a>
    </div>

</form>

