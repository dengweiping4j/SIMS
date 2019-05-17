<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生信息管理系统主页</title>
    <script type="text/javascript">
        checkCookie();

        $(function () {
            $("#userName").html(getCookie('userName'));
        });

        function addTab(url, text, iconCls) {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/views/"
                + url + "'></iframe>";
            $("#tabs").tabs("add", {
                title: text,
                iconCls: iconCls,
                closable: true,
                content: content
            });
        }

        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("close", text);
                addTab(url, text, iconCls);
                $("#tabs").tabs("select", text);
            } else {
                addTab(url, text, iconCls);
            }
        }

        function logout() {
            $.messager.confirm("系统提示", "您确定要退出系统吗", function (e) {
                if (e) {
                    clearCookie();
                }
            });
        }
    </script>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #53bdff" valign="middle">
    <table width="100%">
        <tr>
            <td style="font-size: 20px;color:#ffffff;font-family: '微软雅黑';"
                align="left" width="50%">
                <img src="images/hbmdlogo.jpg" width="60"><font size="5">&nbsp;&nbsp;<strong>学生信息管理系统</strong></font>
            </td>
            <td
                    style="font-size: 20px;color:#ffffff;font-family: '楷体';"
                    align="right" width="50%">
                <img src="images/title.png" width="60">
                <span id="userName"><font size="2">超级管理员</font><br><br></span>
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 50px">
                <font color="grey" size="10">学生信息管理系统</font>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;" title="导航菜单"
     split="true">
    <div class="easyui-accordion">
        <div title="学生管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 学生信息','studentMgr/studentManage.jsp','fa fa-address-book')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-address-book'" style="width: 150px;">
                学生信息</a>
            <a href="javascript:openTab(' 成绩管理','studentMgr/scoreManage.jsp','fa fa-bar-chart-o')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-bar-chart-o'" style="width: 150px;">
                成绩管理</a>
        </div>
        <div title="教师管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 教师信息','teacherMgr/teacherManage.jsp','fa fa-address-book')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-address-book'" style="width: 150px;">
                教师信息</a>
        </div>
        <div title="课程管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 课程信息','courseMgr/courseManage.jsp','fa fa-calendar-o')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-calendar-o'" style="width: 150px;">
                课程信息</a>
        </div>
        <div title="基础数据管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 学院信息','baseDataMgr/departmentMgr/departmentManage.jsp','fa fa-sitemap')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-sitemap'" style="width: 150px;">
                学院信息</a>
            <a href="javascript:openTab(' 专业信息','baseDataMgr/majorMgr/majorManage.jsp','fa fa-balance-scale')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-balance-scale'" style="width: 150px;">
                专业信息</a>
            <a href="javascript:openTab(' 班级信息','baseDataMgr/classMgr/classManage.jsp','fa fa-users')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-users'" style="width: 150px;">
                班级信息</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 用户管理','userMgr/userManage.jsp','fa fa-user-o')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-user-o'" style="width: 150px;">
                用户管理</a>
            <a href="javascript:logout()"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'fa fa-sign-out'"
               style="width: 150px;">
                安全退出</a>
        </div>
    </div>
</div>
</body>
</html>