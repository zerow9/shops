<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block" >
        <p>名称：<input type="text" name="item.itemId" style="height: 20px;"></p><br>
        <p>地址：<input type="text" name="item.itemName" style="height: 20px;"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>经营范围：<input type="text" name="formerItemMarketPrice" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterItemMarketPrice" style="width:73px;height: 20px;"/></p>
        <br>
        <p>工商编号：<input type="text" name="formerRepertoryNumber" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterRepertoryNumber" style="width:73px;height: 20px;"/></p>
        <br>
    </div>
    <div class="hang-1" class="layui-input-block" style="height: 20px;width: 300px">
        <br>
        <br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton"
                style=" width:60px;height: 35px;border: none;background-color:#1ab394;">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
