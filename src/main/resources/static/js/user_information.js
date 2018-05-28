$(function() {
    setInterval(function() {
        var hours = new Date().getHours();
        var minutes = new Date().getMinutes();
        var seconds = new Date().getSeconds();
        var today = new Date().getDay();
        var weeks = new Array('星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六');

        if (hours < 10) {
            hours = "0" + hours;
        }

        if (minutes < 10) {
            minutes = "0" + minutes;
        }

        if (seconds < 10) {
            seconds = "0" + seconds;
        }

        $("#span_time").text(hours + "时" + minutes + "分" + seconds + "秒" + " " + weeks[today]);
    });
    
    $("#textarea_content").val($("#p_notice").text());
    
    $("#input_notice_submit").click(function() {
    	$.post("/notice/changeContent", {
    		content: $("#textarea_content").val()
    	}, function(data, status) {
    		if ("success" == data) {
                alert("通知成功！")
            } else {
                alert("通知失败！");
            }
            
            window.location.reload();
    	});
    });
    
    $("#modal_notice").on("hidden.bs.modal", function() {
    	$("#textarea_content").val($("#p_notice").text());
    });
    
    $("#modal_change_password").on("hidden.bs.modal", function() {
        $("#input_old_password").val("");
        $("#input_new_password").val("");
        $("#input_new_password_twice").val("");
    });
    
    $("#input_change_password_submit").click(function() {
    	var isSubmit = true;

        if (!$("#input_old_password").val()) {
            isSubmit = false;
            alert("旧密码不能为空！")
        }
        
        if (!$("#input_new_password").val()) {
            isSubmit = false;
            alert("新密码不能为空！")
        }
        
        if (!$("#input_new_password_twice").val()) {
            isSubmit = false;
            alert("确认密码不能为空！")
        }
        
        if (isSubmit) {
        	$.post("/changePasswordByUsername", {
        		username: $("#input_username").val(),
        		oldPassword: $("#input_old_password").val(),
        		newPassword: $("#input_new_password").val(),
        		newPasswordTwice: $("#input_new_password_twice").val()
        	}, function(data, status) {
        		if ("success" == data) {
                    alert("修改成功！");
                    window.location.href = "/information";
                } else {
                    alert(data);
                    $("#input_old_password").val("");
                    $("#input_new_password").val("");
                    $("#input_new_password_twice").val("");
                }
        	});
        }
    });
    
    $("#select_gender option[value='" + $("#input_gender").val() + "']").prop("selected", "selected");
    $("#img_head_portrait").prop("src", $("#img_head_portrait").prop("src") + "#" + Math.random());
    
    $("#img_head_portrait").click(function() {
    	$("#input_head_portrait").click();
    });
    
    $("#input_head_portrait").hide();
    
    $("#input_head_portrait").change(function() {
    	$("#form_head_portrait").submit();
    	alert("替换成功！");
    });
    
    // diagram start
    var diagramData = [{
        "key": "请假",
        "value": $("#input_leave_number").val()
    }, {
        "key": "迟到",
        "value": $("#input_late_number").val()
    }, {
        "key": "旷会",
        "value": $("#input_absenteeism_number").val()
    }, {
        "key": "策划未通过",
        "value": $("#input_plan_overdue_number").val()
    }, {
        "key": "策划通过",
        "value": $("#input_plan_completed_number").val()
    }, {
        "key": "策划申请",
        "value": $("#input_plan_active_number").val()
    }];
    
    var chart = new AmCharts.AmRadarChart();
    chart.dataProvider = diagramData;
    chart.categoryField = "key";
    chart.startDuration = 2;
    var valueAxis = new AmCharts.ValueAxis();
    valueAxis.axisAlpha = 0.15;
    valueAxis.minimum = 0;
    valueAxis.dashLength = 3;
    valueAxis.axisTitleOffset = 20;
    valueAxis.gridCount = 5;
    chart.addValueAxis(valueAxis);
    var graph = new AmCharts.AmGraph();
    graph.valueField = "value";
    graph.bullet = "round";
    graph.balloonText = "[[value]]次";
    chart.addGraph(graph);
    chart.write("div_diagram");
    // diagram end
    
    $("#input_change_submit").click(function() {
        var isSubmit = true;

        if (!$("#input_native_place").val()) {
            isSubmit = false;
            alert("籍贯不能为空！")
        }
        
        if (!$("#input_birthday").val()) {
            isSubmit = false;
            alert("出生日期不能为空！")
        }
        
        if (!$("#input_phone").val()) {
            isSubmit = false;
            alert("联系方式不能为空！")
        }
        
        if (!$("#input_email").val()) {
            isSubmit = false;
            alert("邮箱不能为空！")
        }

        if (isSubmit) {
            $.post("/changeBasicByUsername", {
                username: $("#input_username").val(),
                gender: $("#select_gender").val(),
                birthday: $("#input_birthday").val(),
                major: $("#input_major").val(),
                classs: $("#input_classs").val(),
                native_place: $("#input_native_place").val(),
                phone: $("#input_phone").val(),
                email: $("#input_email").val(),
                qq: $("#input_qq").val(),
                hobby: $("#textarea_hobby").val(),
                self_appraisal: $("#textarea_self_appraisal").val(),
                awards_and_achievements : $("#textarea_awards_and_achievements").val()
            }, function(data, status) {
                if ("success" == data) {
                	$("#input_updated_time").val($("#span_time").prev().text().substring(0, 4) + "-" + $("#span_time").prev().text().substring(5, 7) + "-" + $("#span_time").prev().text().substring(8, 10) + " " + $("#span_time").text().substring(0, 2) + ":" + $("#span_time").text().substring(3, 5) + ":" + $("#span_time").text().substring(6, 8));
                    $("#input_updated_by").val($("#a_nickname").text());
                	alert("保存成功！")
                } else {
                    alert("保存失败！");
                }
                
                window.location.reload();
            });
        }
    });
    
    $("#input_remove_submit").click(function() {
		$.post("/removeByUsername", {
    		username: $("#input_username").val()
    	}, function(data, status) {
    		if ("success" == data) {
                alert("退部成功！");
            } else {
            	alert("退部失败！");
            }
    		
    		window.location.href="/logout";
    	});
    });
});