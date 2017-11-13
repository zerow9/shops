<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block" >
        <p>库存编号：<input type="text" name="repertory.repertoryId" style="height: 20px;"></p><br>
        <p>商品编号：<input type="text" name="repertory.itemId" style="height: 20px;"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>市场价格：<input type="text" name="formerItemMarketPrice" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterItemMarketPrice" style="width:73px;height: 20px;"/></p>
        <br>
        <p>原始价格：<input type="text" name="formerItemOriginalPrice" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterItemOriginalPrice" style="width:73px;height: 20px;"/></p>
        <br>
    </div>
    <div class="hang-3" class="layui-input-block" style="height: 20px;width: 300px">
        <br>
        商品名字：
        <input type="text"  name="repertory.itemName" style="width:100px;height: 20px;">
        <br>
        库存量：
        <input type="text"  name="formerRepertoryNumber" style="width:100px;height: 20px;">至
        <input type="text"  name="latterRepertoryNumber" style="width:100px;height: 20px;" >
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
