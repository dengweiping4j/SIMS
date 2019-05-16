<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/views/teacherMgr/teacherManager.js"></script>
</head>
<body style="margin:1px;">
<table id="dg" title="教师信息管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/common/dataGrid?table=v_teacher" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="teacherName" width="50" align="center">教师姓名</th>
        <th field="teacherKey" width="50" align="center">教工号</th>
        <th field="sexmc" width="50" align="center">性别</th>
        <th field="birthday" width="50" align="center">出生日期</th>
        <th field="personId" width="80" align="center">身份证号</th>
        <th field="phone" width="80" align="center">联系电话</th>
        <th field="pkid" hidden="true"/>
        <th field="sex" hidden="true"/>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openAddDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openModifyDialog()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:del()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;教师姓名：&nbsp;
        <input type="text" id="s_xm" size="20" class="easyui-textbox"
               onkeydown="if(event.keyCode==13) search()"/> <a
            href="javascript:search()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" data-options="modal:true"
     style="width: 500px;height:420px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="pkid" name="pkid">
        <table cellspacing="8px">
            <tr>
                <td>教师姓名：</td>
                <td><input type="text" id="teacherName" name="teacherName"
                           class="easyui-textbox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>教工号：</td>
                <td><input type="text" id="teacherKey" name="teacherKey"
                           class="easyui-textbox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><input type="radio" id="sex" name="sex"
                           value="1"/>男
                    <input type="radio" id="sex" name="sex"
                           value="2"/>女
                </td>
            </tr>
            <tr>
                <td>出生日期：</td>
                <td><input type="text" id="birthday" name="birthday"
                           class="easyui-datebox"/>
                </td>
            </tr>
            <tr>
                <td>身份证号：</td>
                <td><input type="text" id="personId" name="personId"
                           class="easyui-textbox" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td><input type="text" id="phone" name="phone" class="easyui-textbox" style="width: 200px"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:save()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:closeDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>