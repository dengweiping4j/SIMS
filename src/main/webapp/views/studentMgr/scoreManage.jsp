<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/views/studentMgr/scoreManager.js"></script>
</head>
<body style="margin:1px;">
<table id="dg" title="学生成绩管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       data-options="
           fitColumns:true,
           scrollbarSize:1,
           striped:true"
       url="${pageContext.request.contextPath}/common/dataGrid?table=v_score" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="studentName" width="50" align="center">学生姓名</th>
        <th field="departmentName" width="60" align="center">所在学院</th>
        <th field="majorName" width="50" align="center">所在专业</th>
        <th field="className" width="50" align="center">所在班级</th>
        <th field="courseName" width="50" align="center">课程名称</th>
        <th field="examScore" width="50" align="center">课程成绩</th>
        <th field="pkid" hidden="true"/>
        <th field="departmentKey" hidden="true"/>
        <th field="majorKey" hidden="true"/>
        <th field="classKey" hidden="true"/>
        <th field="courseKey" hidden="true"/>
        <th field="studentKey" hidden="true"/>
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
            iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog" data-options="modal:true"
     style="width: 420px;height:350px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="pkid" name="pkid">
        <table cellspacing="8px">
            <tr>
                <td>学院：</td>
                <td><input type="text" id="departmentKey" name="departmentKey"
                           class="easyui-combobox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>专业：</td>
                <td><input type="text" id="majorKey" name="majorKey"
                           class="easyui-combobox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>班级：</td>
                <td><input type="text" id="classKey" name="classKey"
                           class="easyui-combobox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>课程名称：</td>
                <td><input type="text" id="courseKey" name="courseKey"
                           class="easyui-combobox" required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>学生姓名：</td>
                <td><input type="text" id="studentKey" name="studentKey"
                           class="easyui-combobox" required="true"/>
                </td>
            </tr>
            <tr>
                <td>课程成绩：</td>
                <td><input type="text" id="examScore" name="examScore"
                           class="easyui-textbox" required="true"/>
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