<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form" style="height: 80px">
    <div class="hang-1" class="layui-input-block">
        <p>&nbsp;&nbsp;&nbsp;投诉人：<input type="text" name="complaint.accuserId"></p><br>
        <p>被投诉人：<input type="text" name="complaint.accusedId"></p>
        <br>
    </div>
    <div class="hang-2" class="layui-input-block">
        <p>投诉标题：<input type="text" name="complaint.complaintTittle"></p>
        <br>
        <p>投诉时间：<input type="text" name="formerComplaintDate" id="time" readonly/><em>~</em>&ensp;<input
                type="text" name="latterComplaintDate" id="other" readonly/></p>
        <br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
