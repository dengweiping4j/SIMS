<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
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
    <script type="text/javascript">
        var url = "${pageContext.request.contextPath}/student";
        var method;

        function searchXS() {
            $("#dg").datagrid('load', {
                "xm": $("#s_xm").val()
            });
        }

        function deleteStudnet() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length == 0) {
                $.messager.alert("系统提示", "请选择要删除的数据！");
                return;
            }
            var strIds = [];
            for (var i = 0; i < selectedRows.length; i++) {
                strIds.push(selectedRows[i].id);
            }
            var ids = strIds.join(",");
            $.messager.confirm("系统提示", "您确认要删除这<font color=red>"
                + selectedRows.length + "</font>条数据吗？", function (r) {
                if (r) {
                    $.ajax({
                        type: "DELETE",//方法类型
                        dataType: "json",//预期服务器返回的数据类型
                        url: "/users/" + ids,//url
                        data: {},
                        success: function (result) {
                            console.log(result);//打印服务端返回的数据
                            if (result.resultCode == 200) {
                                $.messager.alert(
                                    "系统提示",
                                    "数据已成功删除！");
                                $("#dg").datagrid(
                                    "reload");
                            }
                            else {
                                $.messager.alert(
                                    "系统提示",
                                    "数据删除失败！");
                            }

                            ;
                        },
                        error: function () {
                            $.messager.alert("ERROR！");
                        }
                    });
                }
            });

        }

        function openStudentAddDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "添加学生信息");
            method = "POST";
            var year = new Date().getFullYear();
            //入学年份下拉框
            var yearData = [
                {'text': year + '年', 'value': year, 'selected': 'year'},
                {'text': year - 1 + '年', 'value': year - 1},
                {'text': year - 2 + '年', 'value': year - 2},
                {'text': year - 3 + '年', 'value': year - 3},
                {'text': year - 4 + '年', 'value': year - 4}
            ];
            $('#year').combobox({
                textField: 'text',
                valueField: 'value',
                panelHeight: 'auto',
                data: yearData
            })
            //级联下拉框
            findcombobox();
        }

        // 学院-专业-班级 级联下拉框
        function findcombobox() {
            //学院下拉框
            $.ajax({
                async: false,
                type: "post",
                url: url + "/getDepartmentList",//请求后台数据
                dataType: "json",
                success: function (departmentList) {
                    $("#departmentKey").combobox({//往下拉框赋值
                        data: departmentList,
                        valueField: "value",//value值
                        textField: "text",//文本值
                        panelHeight: "auto"
                    })
                }
            });
            //触发学院选项  
            $("#departmentKey").combobox({
                onHidePanel: function () {
                    $("#majorKey").combobox('setValue', ''); //清空专业 
                    $("#classKey").combobox('setValue', ''); //清空班级
                    var departmentKey = $('#departmentKey').combobox('getValue');
                    $.ajax({
                        async: false,
                        url: url + "/getMajorList",
                        data: {departmentKey: departmentKey},
                        type: "POST",
                        dataType: "json",
                        success: function (majorList) {
                            $("#majorKey").combobox("loadData", majorList);
                        }

                    });
                }

            });
            $('#majorKey').combobox({
                editable: false, //不可编辑状态    
                cache: false,
                panelHeight: 'auto',//自动高度适合    
                valueField: 'value',
                textField: 'text'
            });
            //触发专业选项时  
            $("#majorKey").combobox({
                onHidePanel: function () {
                    $("#classKey").combobox('setValue', ''); //清空班级
                    var majorKey = $('#majorKey').combobox('getValue');
                    $.ajax({
                        async: false,
                        url: url + "/getClassList",
                        cache: false,
                        data: {majorKey: majorKey},
                        type: "POST",
                        dataType: "json",
                        success: function (classList) {
                            $("#classKey").combobox("loadData", classList);
                        }
                    });
                }
            });
            $('#classKey').combobox({
                editable: false, //不可编辑状态    
                cache: false,
                panelHeight: 'auto',//自动高度适合    
                valueField: 'value',
                textField: 'text'
            });
        };

        function saveStudent() {
            var userName = $("#userName").val();
            var password = $("#password").val();
            var id = $("#userId").val();
            var data = {"id": id, "password": password, "userName": userName}
            $.ajax({
                type: method,//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: url,//url
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(data),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据
                    if (result.resultCode == 200) {
                        $.messager.alert("系统提示", "保存成功");
                        $("#dlg").dialog("close");
                        $("#dg").datagrid("reload");
                        resetValue();
                    }
                    else {
                        $.messager.alert("系统提示", "操作失败");
                        $("#dlg").dialog("close");
                        resetValue();
                    }
                    ;
                },
                error: function () {
                    $.messager.alert("系统提示", "操作失败");
                }
            });
        }

        function openStudentModifyDialog() {
            var selectedRows = $("#dg").datagrid('getSelections');
            if (selectedRows.length != 1) {
                $.messager.alert("系统提示", "请选择一条要编辑的数据！");
                return;
            }
            var row = selectedRows[0];
            $("#dlg").dialog("open").dialog("setTitle", "编辑学生信息");
            $('#fm').form('load', row);
            $("#password").val("******");
            $("#userId").val(row.id);
            method = "PUT";
        }

        function resetValue() {
            $("#userName").val("");
            $("#password").val("");
        }

        function closeStudentDialog() {
            $("#dlg").dialog("close");
            resetValue();
        }
    </script>
</head>
<body style="margin:1px;">
<table id="dg" title="学生信息管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/student/datagrid" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="xm" width="100" align="center">学生姓名</th>
        <th field="xh" width="50" align="center">学号</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        <a href="javascript:openStudentAddDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:openStudentModifyDialog()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:deleteStudnet()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;学生姓名：&nbsp;
        <input type="text" id="s_xm" size="20" class="easyui-textbox"
               onkeydown="if(event.keyCode==13) searchXS()"/> <a
            href="javascript:searchXS()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

<div id="dlg" class="easyui-dialog"
     style="width: 620px;height:550px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
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
                           class="easyui-combobox" required="true"/>
                    &nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
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
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:saveStudent()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a> <a href="javascript:closeStudentDialog()"
                                   class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>