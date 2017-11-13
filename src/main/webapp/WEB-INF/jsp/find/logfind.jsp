<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form "  style="height: 80px">
    <div class="hang-1" class="layui-input-block" >
        <p>用户ID：<input type="text" name="log.userUuid" style="height: 20px;"></p><br>
        <p>IP地址：<input type="text" name="log.logHistoryIp" style="height: 20px;"></p>
        <br>
    </div>
     <div class="hang-3" id="hang-3"  >
         <p>
        登录时间：<input type="text" readonly name="formerLogLandTime" id="time" style="width: 100px;
    height: 20px;" >至
        <input type="text" readonly name="latterLogLandTime" id="other" style="width: 100px;
               height: 20px;" >
         </p>
        <br>
        间隔时间：
        <input type="text"  name=formerSpaceTime"  id="formerTime" style="width: 100px;
               height: 20px;" readonly>至
        <input type="text"  name="latterSpaceTime" id="formerOther" style="width: 100px;
               height: 20px;" readonly >
        <br>
    </div>

    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton">
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
