<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block">
        <p>用户编号：<input type="text" name="userUuid" style="height: 20px;"></p><br>
        <p>用户姓名：<input type="text" name="userName" style="height: 20px;"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>积分范围：<input type="text" name="formerScore" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterScore" style="width:73px;height: 20px;"/></p>
        <br>
        <p>年龄范围：<input type="text" name="formerAge" style="width:73px;height: 20px;"/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterAge" style="width:73px;height: 20px;"/></p>
        <br>
    </div>
    <div class="hang-3" id="hang-3" class="layui-input-block" style="height: 20px;width: 300px">
        用户性别：<select name="userSex" lay-ignore style="width:73px;height: 20px;margin-left: 4px;
    margin-bottom: 15px;">
                <option value="男" selected="">男</option>
                <option value="女">女</option>
                <option value="">保密</option>
            </select>
        <br>
        注册时间：
            <input type="text" readonly name="formerUserCreateTime" id="time" style="width:100px;height: 20px;">至
            <input type="text" id="other" name="latterUserCreateTime" style="width:100px;height: 20px;" readonly>

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
<script>
//    $(function (){
//        $("#hang-3 .layui-form-select").addClass("float-input");
//    })
</script>
