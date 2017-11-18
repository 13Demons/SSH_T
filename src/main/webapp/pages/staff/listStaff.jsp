<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

    <script>
        function changePost(value) {

            var data = new FormData();
            data.append("post.department.depId", value)


            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    //得到的值
                    console.log(this.responseText);
                    //对请求回来的数据进行解析
                    json = eval('(' + this.responseText + ')');
                    //获取服务器标签
                    serverSelect = document.getElementById("post.postId");
                    //获取option标签
                    optionEle = serverSelect.getElementsByTagName("option");
                    //获取option数量
                    length = optionEle.length;
                    //使用循环清空所有option标签
                    for (var i = 0; i < length; i++) {
                        serverSelect.removeChild(optionEle[0]);
                    }
                    serverSelect.innerHTML = "<option value='-1'>--请选择职务--</option>";
                    // 将json数据插入到option中
                    for (var j = 0; j < json.length; j++) {
                        // 创建一个option标签
                        option = document.createElement("option");
                        // 设置value属性
                        option.setAttribute("value", json[j].postId);
                        // 设置文本信息
                        text = document.createTextNode(json[j].postName);
                        //  把文本信息添加到option中
                        option.appendChild(text);
                        // 把option标签添加到servers的select中
                        serverSelect.appendChild(option);
                    }
                }
            });


            xhr.open("POST", "http://localhost:8080/getStaff.action");

            xhr.send(data);

        }


        function qwer() {
            //当点击查询按钮的时候会执行
            //获取两个select选中对应的value
            console.log("CLICK");
            var depId = document.getElementById("post.department.deptId").value;
            var postId = document.getElementById("post.postId").value;
            var staffName = document.getElementById("staffName").value;

            var data = new FormData();
            data.append("post.department.depId", depId);
            data.append("post.postId", postId);
            data.append("staffName", staffName);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    //对请求回来的数据进行解析
                    var json = eval('(' + this.responseText + ')');

                    var tableEle = document.getElementById("tb");
                    var length = tableEle.rows.length;
                    for (var i = 0; i < length - 1; i++) {
                        tableEle.deleteRow(1);
                    }

                    for (var i = 0; i < json.length; i++) {
                        var tr = document.createElement("tr");

                        tr.appendChild(createTD(json[i].staffName));
                        tr.appendChild(createTD(json[i].gender));
                        tr.appendChild(createTD(json[i].onDutyDate));
                        tr.appendChild(createTD(json[i].post.department.depName));
                        tr.appendChild(createTD(json[i].post.postName));

                        function createA() {
                            var td = document.createElement("td");
                            td.setAttribute("align", "center")
                            var a = document.createElement("a");
                            a.setAttribute("href", "${pageContext.request.contextPath}update_findDepartment.action?staffId=${json[i].staffId}")
                            var textNode = document.createElement("img");
                            textNode.setAttribute("src", "${pageContext.request.contextPath}/images/button/modify.gif")
                            textNode.setAttribute("class", "img")
                            a.appendChild(textNode);
                            td.appendChild(a);
                            return td;
                        }
                        tr.appendChild(createA());
                        tableEle.appendChild(tr);
                    }
                }
            });

            xhr.open("POST", "${pageContext.request.contextPath}/queryAll.action");

            xhr.send(data);
        }
        function createTD(text) {
            var td = document.createElement("td");
            td.setAttribute("align","center")
            var textNode = document.createTextNode(text);
            td.appendChild(textNode);
            return td;
        }


    </script>

</head>


<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">

            <%--高级查询--%>
            <a href="javascript:void(0)" onclick="qwer()">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/>
            </a>

            <%--员工添加--%>
            <a href="add_findDepartment.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>


        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>


<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <%--<td width="80px">部门：</td>--%>
            <%--<td width="200px">--%>

                <%--<select name="post.department.depId" onchange="changePost(this.value)" id="post.department.deptId">--%>
                    <%--<option value="-1">--请选择部门--</option>--%>

                    <%--<s:iterator value="department" var="dept">--%>
                        <%--<option value="${dept.depId}">${dept.depName}</option>--%>
                    <%--</s:iterator>--%>

                <%--</select>--%>
            <%--</td>--%>


            <%--<td width="80px">职务：</td>--%>
            <%--<td width="200px">--%>
                <%--<select name="post.postId" id="post.postId">--%>
                    <%--<option value="-1">--请选择职务--</option>--%>
                <%--</select>--%>
            <%--</td>--%>

                <td width="80px">部门：</td>
                <td width="200px">

                    <select name="post.department.depId" onchange="changePost(this.value)" id="post.department.deptId">
                        <option value="">--请选择部门--</option>

                        <s:iterator value="department" var="dept">
                            <option value="${dept.depId}">${dept.depName}</option>
                        </s:iterator>

                    </select>
                </td>

                <td width="80px">职务：</td>
                <td width="200px">
                    <select name="post.postId" id="post.postId">
                        <option value="${postId}">--请选择职务--</option>
                    </select>
                </td>


                <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staff.staffName" size="12" id="staffName" value=""/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="tb">
    <thead>
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>
    </thead>


<tbody>
    <s:iterator var="s" value="staffs">
    <tr class="tabtd2">
        <td align="center">${s.staffName}</td>
        <td align="center">${s.gender}</td>
        <td align="center">${s.onDutyDate}</td>
        <td align="center">${s.post.department.depName}</td>
        <td align="center">${s.post.postName}</td>
        <td width="7%" align="center">
            <a href="update_findDepartment.action?staffId=${s.staffId}">
                <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/>
            </a>
        </td>
        </s:iterator>
    </tr>
</tbody>
</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">
            <span>第1/3页</span>
            <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
        </td>
    </tr>
</table>


</body>
</html>

