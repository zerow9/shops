<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block" >
        <p>名称：<input type="text" name="venderName" style="height: 20px;"></p><br>
    </div>
    <div class="hang-2">
        <p>地址：<input type="text" name="venderAddress" style="height: 20px;"></p>
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
