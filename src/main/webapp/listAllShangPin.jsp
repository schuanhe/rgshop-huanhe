<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.rgshop.model.ShangPin" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有商品</title>
    <link type="text/css" rel="styleSheet" href="css/table.css"/>
    <link type="text/css" rel="styleSheet" href="css/list.css"/>
    <link type="text/css" rel="styleSheet" href="css/2.css"/>
    <link type="text/css" rel="stylesheet" href="css/ul_li.css">

    <style>

    </style>

</head>

<body>


<ul class="nav_ul">
    <li>

    </li>
    <li>
        <div class="dropdown">
            <img class="dropbtn" id="imgPhoto" style="border-radius: 30px;" width="30px" height="30px"/>

            <div class="dropdown-content">
                <a onclick="LoginExit()">退出登录</a>
            </div>
        </div>
    </li>
    <li><h3 class="nav_h3">欢迎:</h3></li>
    <li><h3 id="user" class="nav_h3" style="color: #4CAF50"></h3></li>

    <div class="nav_div"><h2>幻鹤 的废品管理系统</h2></div>

</ul>





<%--添加弹窗--%>
<div id="cmdBox" class="cmdBox" hidden="hidden">
    <div class="cmd">
        <!-- 三个按钮 -->
        <div class="click">
            <div id="clos" class="red"></div>
            <div class="yellow"></div>
            <div class="green"></div>
        </div>
        <!-- 顶部标题 -->
        <div class="title">
            <span>添加新商品</span>
        </div>
        <!-- 终端内文字 -->
        <div class="cmdText">
            <form action="AddShangPinServlet" method="post">
                <div>
                    <label for="spdh">商品编号：</label>
                    <input class="text01" type="text" id="spdh" name="spbh" required="required">
                </div>
                <div>
                    <label for="spmc">商品名称：</label>
                    <input class="text01" type="text" id="spmc" name="spmc" required="required">
                </div>
                <div>
                    <label for="spdj">商品单价：</label>
                    <input class="text01" type="number" id="spdj" name="spdj" required="required">
                </div>
                <div>
                    <label for="spsl">商品数量：</label>
                    <input class="text01" type="number" id="spsl" name="spsl" required="required">
                </div>
                <div>
                    <label for="spbz">商品备注：</label>
                    <textarea class="text01" id="spbz" name="spbz" placeholder="此项可空." style="height:80px"></textarea>
                </div>
                <div align="center">
                    <input class="button01 button2" type="reset" value="重置">
                    <input class="button01 button2" type="submit" value="提交">
                </div>
            </form>

        </div>
    </div>
</div>
<%--修改弹窗--%>
<div id="cmdBox2" class="cmdBox" hidden="hidden">
    <div class="cmd">
        <!-- 三个按钮 -->
        <div class="click">
            <div id="clos2" class="red"></div>
            <div class="yellow"></div>
            <div class="green"></div>
        </div>
        <!-- 顶部标题 -->
        <div class="title">
            <span>修改商品</span>
        </div>
        <!-- 终端内文字 -->
        <div class="cmdText">
            <form action="UpdShangPinServlet" method="post">
                <div style="display: none">
                    <label for="spid2">商品id：</label>
                    <input class="text01" type="text" id="spid2" name="spid" required="required">
                </div>
                <div>
                    <label for="spbh2">商品编号：</label>
                    <input class="text01" type="text" id="spbh2" name="spbh" required="required" value="">
                </div>
                <div>
                    <label for="spmc2">商品名称：</label>
                    <input class="text01" type="text" id="spmc2" name="spmc" required="required">
                </div>
                <div>
                    <label for="spdj2">商品单价：</label>
                    <input class="text01" type="number" id="spdj2" name="spdj" required="required">
                </div>
                <div>
                    <label for="spsl2">商品数量：</label>
                    <input class="text01" type="number" id="spsl2" name="spsl" required="required">
                </div>
                <div>
                    <label for="spbz2">商品备注：</label>
                    <textarea class="text01" id="spbz2" name="spbz" placeholder="此项可空." style="height:80px"></textarea>
                </div>
                <div align="center">
                    <input class="button01 button2" type="reset" value="重置">
                    <input class="button01 button2" type="submit" value="提交">
                </div>
            </form>

        </div>
    </div>
</div>
<%--搜索弹窗--%>
<div id="cmdBox3" class="cmdBox" hidden="hidden">
    <div class="cmd">
        <!-- 三个按钮 -->
        <div class="click">
            <div id="clos3" class="red"></div>
            <div class="yellow"></div>
            <div class="green"></div>
        </div>
        <!-- 顶部标题 -->
        <div class="title">
            <span>搜索商品</span>
        </div>
        <!-- 终端内文字 -->
        <div class="cmdText">
            <form action="QueryShangPinServlet" method="post">
                <div style="display: none">
                    <label for="spid3">商品id：</label>
                    <input class="text01" type="text" id="spid3" name="spid">
                </div>
                <div>
                    <label for="spbh3">商品编号：</label>
                    <input class="text01" type="text" id="spbh3" name="spbh" value="">
                </div>
                <div>
                    <label for="spmc3">商品名称：</label>
                    <input class="text01" type="text" id="spmc3" name="spmc">
                </div>
                <div>
                    <label>商品单价：</label>
                    <input class="text02" type="number" id="spdj3_f" name="spdj_from" required="required" value="0"> 到
                    <input class="text02" type="number" id="spdj3_t" name="spdj_to" required="required" value="9999">
                </div>
                <div>
                    <label>商品数量：</label>
                    <input class="text02" type="number" id="spsl3_f" name="spsl_from" required="required" value="0">
                    到 <input class="text02" type="number" id="spsl3_t" name="spsl_to" required="required" value="99999">
                </div>

                <div>
                    <label for="spbz3">商品备注：</label>
                    <textarea class="text01" id="spbz3" name="spbz" placeholder="此项可空." style="height:80px"></textarea>
                </div>
                <div align="center">
                    <input class="button01 button2" type="reset" value="重置">
                    <input class="button01 button2" type="submit" value="提交">
                </div>
            </form>

        </div>
    </div>
</div>

<%--    表格组件--%>
<div class="div1">
    <table>
        <thead>
        <tr>
            <th>序号</th>
            <th style="display:none;">id</th>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品单价</th>
            <th>商品数量</th>
            <th>商品备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" value="0"></c:set>
        <jsp:useBean id="sp" class="com.rgshop.model.ShangPin"></jsp:useBean>
        <c:forEach var="sp" items="${requestScope.page.getRecordList()}">
            <c:set var="i" value="${i+1}"></c:set>
            <tr>
                <td>${i}</td>
                <td style="display:none;">${sp.spid}</td>
                <td>${sp.getSpbh()}</td>
                <td>${sp.getSpmc()}</td>
                <td>${sp.getSpdj()}</td>
                <td>${sp.getSpsl()}</td>
                <td>${sp.getSpbz()}</td>
                <td>
                    <a href="DelShangPinServlet?spid=${sp.getSpid()}" onclick="return confirm('确定删除嘛？')"
                       style="text-decoration:none;color: #ff1b22">删 除</a>
                    &nbsp;&nbsp;
                    <a href="#" style="text-decoration:none;" onclick="xg(this)">修 改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="div2">
    <%--分页组件--%>
    <div class="div3">
        <ul class="pagination">
            <%--第一页就不需要显示--%>

            <div class="fy_s" style="visibility:hidden" id="fy_s">
<%--                <c:if test="${requestScope.page.getCurrentPage()!=1&&requestScope.page.getCurrentPage()!=null}">--%>
                    <li><a href="?page=1"> 第一页 </a></li>
                    <li><a href="?page=${(requestScope.page.getCurrentPage())-1}"> 上一页 </a></li>
<%--                </c:if>--%>
            </div>

            <%--page里的，起始和末页--%>
            <div class="fy_z">
                <c:set var="i" value="${requestScope.page.getBeginPageIndex()}"></c:set>
                <c:forEach begin="${requestScope.page.getBeginPageIndex()}" end="${requestScope.page.getEndPageIndex()}"
                           var="i">
                    <li><a href="?page=${i}" class="${i==requestScope.page.getCurrentPage() ? "active":""}"> ${i} </a>
                    </li>
                    <c:set var="i" value="${i+1}"></c:set>
                </c:forEach>
            </div>
            <%--末页--%>
            <div class="fy_x" style="visibility:hidden" id="fy_x">
<%--                <c:if test="${requestScope.page.getPageCount()!=requestScope.page.getCurrentPage()}">--%>
                    <li><a href="?page=${(requestScope.page.getCurrentPage())+1}"> 下一页 </a></li>
                    <li><a href="?page=${requestScope.page.getPageCount()}"> 最后一页 </a></li>
<%--                </c:if>--%>
            </div>
        </ul>
    </div>
    <div class="div1" id="button_d">
        <input type="button" class="button button2" value="新增商品11" onclick="tj()">
    </div>
    <div class="div1" id="button_d2">
        <input type="button" class="button button2" value="查询商品" onclick="cx()">
    </div>
    <div class="div1" id="button_d3" hidden="hidden">
        <form action="AllShangPinServlet" method="get">
            <input class="button button2" type="submit" value="返 回 首 页"/>
        </form>
    </div>
</div>


<script>

    //添加时显示弹窗
    function tj() {
        document.getElementById("cmdBox").removeAttribute("hidden")
    }

    //弹出修改
    function xg(tag) {
        //执行删除行的操作
        var tdTag = tag.parentNode;// parentNode父节点，此处得到<td>节点
        var tr = tdTag.parentNode;//获取<tr>
        let idName = ["spid2", "spbh2", "spmc2", "spdj2", "spsl2", "spbz2"]; //
        let date = new Array();
        for (let i = 1; i < tr.children.length - 1; i++) {
            date[i] = tr.children[i].textContent;
        }
        document.getElementById("cmdBox2").removeAttribute("hidden");
        for (let i = 0; i < idName.length; i++) {
            document.getElementById(idName[i]).value = date[i + 1]
        }
    }

    //弹出搜索
    function cx() {
        document.getElementById("cmdBox3").removeAttribute("hidden")
    }


    //关闭弹窗1
    document.getElementById("clos").onclick = function () {
        document.getElementById("cmdBox").setAttribute("hidden", "hidden")//添加隐藏属性
    }
    //关闭弹窗2
    document.getElementById("clos2").onclick = function () {
        document.getElementById("cmdBox2").setAttribute("hidden", "hidden")//添加隐藏属性
    }
    //关闭弹窗3
    document.getElementById("clos3").onclick = function () {
        document.getElementById("cmdBox3").setAttribute("hidden", "hidden")//添加隐藏属性
    }


    //推出登录
    function LoginExit(){
        if(confirm('确定退出？')){
            document.cookie = "key=sb; expires=Sun, 13 Oct 2003 12:00:00 UTC;";
            window.location.replace("login.jsp");//滚回去重新登录
        }

    }



    //自动函数
    window.onload = function () {
        cxButt();
        sxFy();
        keyValid();
        loading();
    }


    //判断当前是查询还是全部，更改按钮显示
    function cxButt() {
        var pathName = window.location.pathname;
        var pathName_1 = pathName.split("/")[2];//直接搞到末尾文件，慷慨
        if (pathName_1 === "QueryShangPinServlet") {
            document.getElementById("button_d").setAttribute("hidden", "hidden")
            document.getElementById("button_d2").setAttribute("hidden", "hidden")
            document.getElementById("button_d3").removeAttribute("hidden")
        }
    }
    //判断上下分页显示页面
    function sxFy(){
        if(${requestScope.page.getCurrentPage()!=1&&requestScope.page.getCurrentPage()!=null}){
            document.getElementById("fy_s").style.visibility="";
        }
        if (${requestScope.page.getPageCount()!=requestScope.page.getCurrentPage()}){
            document.getElementById("fy_x").style.visibility="";
        }
    }


    //验证cookie存在
    function keyValid(){
        if (getCookie("key")==null){
            alert("登录过期！");
            window.location.replace("login.jsp");//滚回去重新登录
        }
    }
    //头像url和名字
    function loading(){
        document.getElementById("user").textContent=getCookie("user");
        document.getElementById("imgPhoto").src="http://q.qlogo.cn/g?b=qq&nk="+getCookie("qq")+"&s=100"
    }


    /**
     * js获取cook
     * @param cookie_name cookie的名字
     * @returns {string} //值
     */
   function getCookie(cookie_name) {
        var allcookies = document.cookie;
        //索引长度，开始索引的位置
        var cookie_pos = allcookies.indexOf(cookie_name);
        // 如果找到了索引，就代表cookie存在,否则不存在
        if (cookie_pos != -1) {
            // 把cookie_pos放在值的开始，只要给值加1即可
            //计算取cookie值得开始索引，加的1为“=”
            cookie_pos = cookie_pos + cookie_name.length + 1;
            //计算取cookie值得结束索引
            var cookie_end = allcookies.indexOf(";", cookie_pos);
            if (cookie_end == -1) {
                cookie_end = allcookies.length;
            }
            //得到想要的cookie的值
            var value = unescape(allcookies.substring(cookie_pos, cookie_end));
        }
        return value;
    }



</script>
</body>
</html>
