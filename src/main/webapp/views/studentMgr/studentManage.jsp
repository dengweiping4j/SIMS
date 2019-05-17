<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/views/studentMgr/studentManager.js"></script>
</head>
<body style="margin:1px;">
<table id="dg" title="学生信息管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       data-options="
           fitColumns:true,
           scrollbarSize:1,
           striped:true"
       url="${pageContext.request.contextPath}/common/dataGrid?table=v_student" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="xm" width="50" align="center">学生姓名</th>
        <th field="xh" width="50" align="center">学号</th>
        <th field="year" width="50" align="center">年级</th>
        <th field="departmentName" width="80" align="center">学院</th>
        <th field="majorName" width="80" align="center">专业</th>
        <th field="className" width="80" align="center">班级</th>
        <th field="phone" width="60" align="center">联系电话</th>
        <th field="pkid" hidden="true"/>
        <th field="departmentKey" hidden="true"/>
        <th field="majorKey" hidden="true"/>
        <th field="classKey" hidden="true"/>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openAddDialog()" class="easyui-linkbutton"
           iconCls="fa fa-plus-square" plain="true">添加</a>
        <a href="javascript:openModifyDialog()" class="easyui-linkbutton"
           iconCls="fa fa-edit" plain="true">修改</a>
        <a href="javascript:del()" class="easyui-linkbutton"
           iconCls="fa fa-trash" plain="true">删除</a>
    </div>
    <div>
        &nbsp;学生姓名：&nbsp;
        <input type="text" id="s_xm" size="20" class="easyui-textbox"
               onkeydown="if(event.keyCode==13) search()"/> <a
            href="javascript:search()" class="easyui-linkbutton"
            iconCls="fa fa-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" data-options="modal:true"
     style="width: 520px;height:450px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="pkid" name="pkid">
        <table cellspacing="8px">
            <tr>
                <td>学生姓名：</td>
                <td><input type="text" id="xm" name="xm"
                           class="easyui-textbox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>学号：</td>
                <td><input type="text" id="xh" name="xh"
                           class="easyui-textbox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>入学年份：</td>
                <td><input type="text" id="year" name="year"
                           class="easyui-combobox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>学院：</td>
                <td><input type="text" id="departmentKey" name="departmentKey"
                           class="easyui-combobox" required="true" style="width: 200px"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>专业：</td>
                <td><input type="text" id="majorKey" name="majorKey"
                           class="easyui-combobox" required="true" style="width: 200px"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>班级：</td>
                <td><input type="text" id="classKey" name="classKey"
                           class="easyui-combobox" required="true" style="width: 200px"/>&nbsp;
                    <font color="red">*</font>
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
       iconCls="fa fa-save">保存</a>
    <a href="javascript:closeDialog()"
       class="easyui-linkbutton" iconCls="fa fa-close">关闭</a>
</div>
</body>
</html>