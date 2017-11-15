<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 60px">
    <div class="hang-1" class="layui-input-block" style="margin-left: 120px;">
        <br><p>名称：<input type="text" name="venderName"></p><br>
    </div>
    <div class="hang-2" style="margin-left: 120px;">
        <br><p>地址：<input type="text" name="venderAddress"></p><br>
    </div>

    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
