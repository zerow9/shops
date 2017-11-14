<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" class="layui-elem-quote layui-form "  style="height: 75px">
    <div class="hang-1" class="layui-input-block" >
        <p>用户ID：<input type="text" name="log.userUuid"></p><br>
        <p>IP地址：<input type="text" name="log.logHistoryIp"></p>
        <br>
    </div>
     <div class="hang-3" id="hang-3"  >
         <p>
        登录时间：<input type="text" name="formerLogLandTime" id="time" readonly><em>&nbsp;~&nbsp;</em><input
                 type="text" name="latterLogLandTime" id="other" readonly></p><br>
        间隔时间：<input type="text"  name="formerSpaceTime"  id="formerTime" readonly><em>&nbsp;~&nbsp;</em><input
             type="text" name="latterSpaceTime" id="formerOther"readonly ><br>
    </div>
    <div class="hang-butt">
        <button lay-submit lay-filter="find" class="myButton" lay-ignore>
            <i class="fa fa-search"></i>
            查询
        </button>
    </div>
</form>
