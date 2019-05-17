<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/views/courseMgr/courseManager.js"></script>
</head>
<body style="margin:1px;">
<table id="dg" title="课程信息管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       data-options="
           fitColumns:true,
           scrollbarSize:1,
           striped:true"
       url="${pageContext.request.contextPath}/common/dataGrid?table=v_course" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="courseName" width="50" align="center">课程名称</th>
        <th field="departmentName" width="60" align="center">所属学院</th>
        <th field="majorName" width="50" align="center">所属专业</th>
        <th field="className" width="50" align="center">所属班级</th>
        <th field="teacherName" width="50" align="center">任课教师</th>
        <th field="pkid" hidden="true"/>
        <th field="departmentKey" hidden="true"/>
        <th field="majorKey" hidden="true"/>
        <th field="classKey" hidden="true"/>
        <th field="teacherKey" hidden="true"/>
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
        &nbsp;课程名称：&nbsp;
        <input type="text" id="s_xm" size="20" class="easyui-textbox"
               onkeydown="if(event.keyCode==13) search()"/> <a
            href="javascript:search()" class="easyui-linkbutton"
            iconCls="fa fa-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" data-options="modal:true"
     style="width: 420px;height:350px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="pkid" name="pkid">
        <table cellspacing="8px">
            <tr>
                <td>课程名称：</td>
                <td><input type="text" id="courseName" name="courseName"
                           class="easyui-textbox" style="width: 200px" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>所属学院：</td>
                <td><input type="text" id="departmentKey" name="departmentKey"
                           class="easyui-combobox" style="width: 200px" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>所属专业：</td>
                <td><input type="text" id="majorKey" name="majorKey"
                           class="easyui-combobox" style="width: 200px" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>所属班级：</td>
                <td><input type="text" id="classKey" name="classKey"
                           class="easyui-combobox" style="width: 200px" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>任课教师：</td>
                <td><input type="text" id="teacherKey" name="teacherKey"
                           class="easyui-combobox" style="width: 200px" required="true"/>&nbsp;
                    <font color="red">*</font>
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