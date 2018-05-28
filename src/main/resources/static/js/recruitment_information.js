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
    
    $("#input_change_for_pass_submit").click(function() {
    	$.post("/recruitment/changeForDepartmentById", {
            id: $("#recruitment_id").val(),
            departmentName: $("#user_department_name").val()
        }, function(data, status) {
        	if ("success" == data) {
        		$.post("/recruitment/changeStatusForPassById", {
                    id: $("#recruitment_id").val()
                }, function(data, status) {
                    if ("success" == data) {
                        alert("通过成功！")
                    } else {
                        alert("通过失败！");
                    }
                    
                    window.location.href = "/recruitment/findApplication";
                });
            } else {
                alert("通过失败！");
            } 
        });
    });
    
    $("#input_change_for_remove_submit").click(function() {
        $.post("/recruitment/changeStatusForRemoveById", {
            id: $("#recruitment_id").val()
        }, function(data, status) {
            if ("success" == data) {
                alert("淘汰成功！")
            } else {
                alert("淘汰失败！");
            }
            
            window.location.href = "/recruitment/findApplication";
        });
    });
});