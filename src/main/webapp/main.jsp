<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生管理系统主页</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.5.1/themes/ui-cupertino/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.5.1/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
    <script src="/js/common.js"></script>
    <script type="text/javascript">
        checkCookie();
        var url;

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
                <img src="images/hbmdlogo.jpg" width="60"><font size="5">&nbsp;&nbsp;<strong>学生管理系统</strong></font>
            </td>
            <td
                style="font-size: 20px;color:#ffffff;font-family: '楷体';"
                align="right" width="50%"><font size="3">&nbsp;&nbsp;<strong>当前用户：</strong>
                admin</font>【管理员】
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 50px">
                <font color="grey" size="10">学生管理系统</font>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;" title="导航菜单"
     split="true">
    <div class="easyui-accordion">
        <div title="学生管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 学生信息管理','studentManage.jsp','icon-man')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-man'" style="width: 150px;">
                学生信息管理</a>
            <a href="javascript:openTab(' 学生成绩管理','studentManage.jsp','icon-man')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-man'" style="width: 150px;">
                学生成绩管理</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 用户管理','userManage.jsp','icon-lxr')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;">
                用户管理</a>
            <a href="javascript:logout()"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-exit'"
               style="width: 150px;">
                安全退出</a>
        </div>
    </div>
</div>
</body>
</html>