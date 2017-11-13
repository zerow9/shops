<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block">
        <p>投诉人：<input type="text" name="complaint.accuserId" style="height: 20px;"></p><br>
        <p>被投诉人：<input type="text" name="complaint.accusedId" style="height: 20px;"></p>
        <br>
    </div>
    <div class="hang-1" class="layui-input-block">
        <p>投诉标题：<input type="text" name="complaint.complaintTittle" style="height: 20px;"></p>
        <br>
        <p>投诉时间：<input type="text" name="formerComplaintDate" id="time" style="width:73px;height: 20px;" readonly/>&ensp;<em>—</em>&ensp;<input
                type="text" name="latterComplaintDate" id="other" style="width:73px;height: 20px;" readonly/></p>
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
