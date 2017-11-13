<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="width:100%;">
<form action="" class="layui-elem-quote layui-form" style="height: 75px">
    <div class="hang-1" class="layui-input-block">
        <p>用户编号：<input type="text" name="user.userUuid" ></p><br>
        <p>用户姓名：<input type="text" name="user.userName" ></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>积分范围：<input type="text" name="formerScore" />&ensp;<em>—</em>&ensp;<input
                type="text" name="latterScore" /></p>
        <br>
        <p>年龄范围：<input type="text" name="formerAge" />&ensp;<em>—</em>&ensp;<input
                type="text" name="latterAge" /></p>
        <br>
    </div>
    <div class="hang-3" id="hang-3"  >
        用户性别：<select name="user.userSex" lay-ignore >
                <option value="男" selected="">男</option>
                <option value="女">女</option>
                <option value="">保密</option>
            </select>
        <br>
        注册时间：
            <input type="text" readonly name="formerUserCreateTime" id="time">至
            <input type="text" readonly id="other" name="latterUserCreateTime"  >

        <br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>

</form>
</div>

