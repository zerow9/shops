<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 75px">
    <div class="hang-1" class="layui-input-block" >
        <p>商品编号：<input type="text" name="item.itemTypeId"></p><br>
        <p>商品名称：<input type="text" name="item.itemName"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>市场价格：<input type="text" name="formerItemMarketPrice" placeholder="￥"/><em>&nbsp;~&nbsp;</em><input
                type="text" name="latterItemMarketPrice" placeholder="￥"/></p>
        <br>
        <p>库存范围：<input type="text" name="formerRepertoryNumber"/><em>&nbsp;~&nbsp;</em><input
                type="text" name="latterRepertoryNumber"/></p>
        <br>
    </div>
    <div class="hang-3" class="layui-input-block">
        <p>关键字：<input type="text"  id="item.keyWord" ></p><br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>

</form>
