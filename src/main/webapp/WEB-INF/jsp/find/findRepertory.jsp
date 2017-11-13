<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block">
        <p>库存编号：<input type="text" name="repertory.repertoryId"></p><br>
        <p>商品编号：<input type="text" name="repertory.itemId"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>市场价格：<input type="text" name="formerItemMarketPrice" placeholder="￥"/>&ensp;<em>&nbsp;~</em>&ensp;<input
                type="text" name="latterItemMarketPrice" placeholder="￥"/></p>
        <br>
        <p>原始价格：<input type="text" name="formerItemOriginalPrice" placeholder="￥"/>&ensp;<em>&nbsp;~</em>&ensp;<input
                type="text" name="latterItemOriginalPrice" placeholder="￥"/></p>
        <br>
    </div>
    <div class="hang-3" class="layui-input-block">
        <p></p>
        商品名字：<input type="text" name="repertory.itemName"></p>
        <br>
        <p>&nbsp;&nbsp;&nbsp;库存量：<input type="text" name="formerRepertoryNumber"><em>&nbsp;~</em>&ensp;<input
                type="text" name="latterRepertoryNumber"></p>
        <br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
