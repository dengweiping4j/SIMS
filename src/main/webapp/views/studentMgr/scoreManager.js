var url = "/SIMS/student";
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
    $.messager.confirm("系统提示", "您确认要删除这<font color=red>"
        + selectedRows.length + "</font>条数据吗？", function (r) {
        if (r) {
            $.ajax({
                type: "DELETE",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: url + "/deleteScore/" + pkids,//url
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
    $("#dlg").dialog("open").dialog("setTitle", "学生成绩录入", 'refresh', "");
    findcombobox();
    method = "POST";
    methodName = "/addScore";
}

function save() {
    var pkid = $("#pkid").val();
    var studentKey = $("#studentKey").combobox("getValue");
    var courseKey = $("#courseKey").combobox("getValue");
    var examScore = $("#examScore").val();
    var data = {
        "pkid": pkid,
        "studentKey": studentKey,
        "courseKey": courseKey,
        "examScore": examScore
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
    $("#dlg").dialog("open").dialog("setTitle", "编辑学生成绩");
    findcombobox();
    $('#fm').form('load', row);
    $('#departmentKey').combobox('setValue', row.departmentKey);
    $('#majorKey').combobox('setValue', row.majorKey);
    $('#classKey').combobox('setValue', row.classKey);
    $('#courseKey').combobox('setValue', row.courseKey);
    $('#studentKey').combobox('setValue', row.studentKey);
    method = "POST";
    methodName = "/updateScore";
}

//加载下拉框
function findcombobox() {
    //学院下拉框
    $.ajax({
        async: false,
        type: "post",
        url: "/SIMS/student/getDepartmentList",//请求后台数据
        dataType: "json",
        success: function (departmentList) {
            $("#departmentKey").combobox({//往下拉框赋值
                prompt: '请选择...',
                data: departmentList,
                valueField: "value",//value值
                textField: "text",//文本值
                panelHeight: "auto"
            })
        }
    });
    //触发学院选项  
    $("#departmentKey").combobox({
        onChange: function () {
            $("#majorKey").combobox('setValue', ''); //清空专业 
            $("#classKey").combobox('setValue', ''); //清空班级
            var departmentKey = $('#departmentKey').combobox('getValue');
            $("#majorKey").combobox("loadData", "");
            $.ajax({
                async: false,
                url: "/SIMS/student/getMajorList",
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
        prompt: '请选择...',
        editable: false, //不可编辑状态    
        cache: false,
        panelHeight: 'auto',//自动高度适合    
        valueField: 'value',
        textField: 'text'
    });
    //触发专业选项时  
    $("#majorKey").combobox({
        onChange: function () {
            $("#classKey").combobox('setValue', ''); //清空班级
            var majorKey = $('#majorKey').combobox('getValue');
            $("#classKey").combobox("loadData", "");
            $.ajax({
                async: false,
                url: "/SIMS/student/getClassList",
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
        prompt: '请选择...',
        editable: false, //不可编辑状态    
        cache: false,
        panelHeight: 'auto',//自动高度适合    
        valueField: 'value',
        textField: 'text'
    });
    //触发班级选项时  
    $("#classKey").combobox({
        onChange: function () {
            $("#courseKey").combobox('setValue', ''); //清空课程和学生
            $("#studentKey").combobox('setValue', ''); //清空课程和学生
            var classKey = $('#classKey').combobox('getValue');
            $("#courseKey").combobox("loadData", "");
            $.ajax({
                async: false,
                url: "/SIMS/course/getCourseList",
                cache: false,
                data: {classKey: classKey},
                type: "POST",
                dataType: "json",
                success: function (courseList) {
                    $("#courseKey").combobox("loadData", courseList);
                }
            });
            $("#studentKey").combobox("loadData", "");
            $.ajax({
                async: false,
                url: "/SIMS/student/getStudentList",
                cache: false,
                data: {classKey: classKey},
                type: "POST",
                dataType: "json",
                success: function (studentList) {
                    $("#studentKey").combobox("loadData", studentList);
                }
            });
        }
    });
    $('#courseKey').combobox({
        prompt: '请选择...',
        editable: false, //不可编辑状态    
        cache: false,
        panelHeight: 'auto',//自动高度适合    
        valueField: 'value',
        textField: 'text'
    });
    $('#studentKey').combobox({
        prompt: '请选择...',
        editable: false, //不可编辑状态    
        cache: false,
        panelHeight: 'auto',//自动高度适合    
        valueField: 'value',
        textField: 'text'
    });
}

function resetValue() {
    $('#fm').form('clear');
}

function closeDialog() {
    $("#dlg").dialog("close");
    resetValue();
}