var url = "/SIMS/baseData";
var method;
var methodName;

function search() {
    $("#dg").datagrid('load', {
        "xm": $("#s_xm").val()
    });
}

function del() {
    var selectedRows = $("#dg").datagrid('getSelections');
    if (selectedRows.length == 0) {
        $.messager.alert("系统提示", "请选择要删除的数据！");
        return;
    }
    var strPkids = [];
    for (var i = 0; i < selectedRows.length; i++) {
        strPkids.push(selectedRows[i].pkid);
    }
    var pkids = strPkids.join(",");
    $.messager.confirm("系统提示", "删除学院会同时删除对应的专业和班级!", function (r) {
        if (r) {
            $.ajax({
                type: "DELETE",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: url + "/deleteDepartment/" + pkids,//url
                data: {},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据
                    if (result.resultCode == 200) {
                        $.messager.alert(
                            "系统提示",
                            "删除成功！");
                        $("#dg").datagrid(
                            "reload");
                    }
                    else {
                        $.messager.alert(
                            "系统提示",
                            "删除失败！");
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

function openAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加学院信息", 'refresh', "");
    method = "POST";
    methodName = "/addDepartment";
}

function save() {
    var departmentName = $("#department_name").val();
    var pkid = $("#pkid").val();
    var data = {
        "pkid": pkid,
        "departmentName": departmentName
    };

    if ($('#fm').form('validate')) {
        $.ajax({
            type: method,//方法类型
            dataType: "json",//服务器返回的数据类型
            url: url + methodName,//url
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result) {
                if (result.resultCode == 200) {
                    $.messager.alert("系统提示", "保存成功");
                    $("#dlg").dialog("close");
                    $("#dg").datagrid("reload");
                    resetValue();
                }
                else {
                    $.messager.alert("系统提示", "操作失败", "error");
                    $("#dlg").dialog("close");
                    resetValue();
                }
            },
            error: function () {
                $.messager.alert("系统提示", "操作失败", "error");
            }
        });
    } else {
        $.messager.alert("系统提示", "您有内容尚未填写", "warning");
    }
}

function openModifyDialog() {
    var selectedRows = $("#dg").datagrid('getSelections');
    if (selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑学院信息");
    $('#fm').form('load', row);
    method = "POST";
    methodName = "/updateDepartment";
}

function resetValue() {
    $('#fm').form('clear');
}

function closeDialog() {
    $("#dlg").dialog("close");
    resetValue();
}