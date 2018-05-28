$(function() {
    var cookie = document.cookie + ";";
    var cookieUsername = cookie.substring(cookie.indexOf("=", cookie.indexOf("cookieUsername")) + 1, cookie.indexOf(";", cookie.indexOf("cookieUsername")));
    var cookiePassword = cookie.substring(cookie.indexOf("=", cookie.indexOf("cookiePassword")) + 1, cookie.indexOf(";", cookie.indexOf("cookiePassword")));

    if (cookieUsername && cookiePassword) {
        $("#input_username").val(cookieUsername);
        $("#input_password").val(cookiePassword);
        $("#input_remember").prop("checked", true);
        
        $("#modal_login").on("hidden.bs.modal", function() {
            $("#input_username").val(cookieUsername);
            $("#input_password").val(cookiePassword);
            $("#input_remember").prop("checked", true);
        });
    } else {
        $("#modal_login").on("hidden.bs.modal", function() {
            $("#input_username").val("");
            $("#input_password").val("");
            $("#input_remember").prop("checked", false);
        });
    }
    
    setInterval(function() {
    	var hours = new Date().getHours();
        var minutes = new Date().getMinutes();
        var seconds = new Date().getSeconds();
        var today = new Date().getDay();
        var weeks = new Array('星期日','星期一','星期二','星期三','星期四','星期五','星期六'); 
        
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
    
    $("#input_feedback_submit").click(function() {
    	var isSubmit = true;
    	
    	if (!$("#textarea_content").val()) {
    		isSubmit = false;
    		alert("反馈内容不能为空！")
    	}
    	
    	if (isSubmit) {
    		$.post("/feedback/create", {
    			feedbackContent: $("#textarea_content").val(), 
    			type: $("#select_type").val()
	        }, function(data, status) {
	        	if ("success" == data) {
	                alert("反馈成功！")
	            } else {
	                alert("反馈失败！");
	            }
	            
	            window.location.reload();
	        });
    	}
    });
    
    $("#input_submit").click(function() {
    	var isSubmit = true;
    	
    	if (!$("#input_username").val()) {
    		isSubmit = false;
    		alert("用户名不能为空！")
    	}
    	
    	if (!$("#input_password").val()) {
    		isSubmit = false;
    		alert("密码不能为空！")
    	}
    	
    	if (isSubmit) {
    		$.post("/login", {
	            username: $("#input_username").val(), 
	            password: $("#input_password").val(),
	            remember: $("#input_remember").is(":checked")
	        }, function(data, status) {
	            if ("string" == typeof(data)) {
	                if ("success" == data) {
	                    window.location.href = "/index/rjxy";
	                } else {
	                    alert(data);
	                }
	            } else {
	                if (data.usernameIsEmpty != null) {
	                    alert(data.usernameIsEmpty);
	                }
	                    
	                if (data.passwordIsEmpty != null) {
	                    alert(data.passwordIsEmpty);
	                }
	            }
	        });
    	}
    });
    
    $(document).keydown(function(event) { 
    	if (event.keyCode == 13) { 
    		$("#input_submit").click(); 
    	} 
    }); 
    
    for (var counter = 0; counter < 4; counter++) {
    	$(".a-department").eq(counter).attr("data-placement", "bottom");
    }
    
    $("[data-toggle='tooltip']").tooltip();

    $("#img_head_portrait").click(function() {
    	$("#input_head_portrait").click();
    });
    
    $("#input_head_portrait").hide();
    
    $("#input_head_portrait").change(function() {
    	alert("参加面试时请携带两份纸质报名表，报名表可在首页通知公告栏中下载，祝大家面试顺利！");
    	var isSubmit = true;
    	
    	if (!$("#input_nickname").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("姓名不能为空！")
    	}
    	
    	if (!$("#input_birthday").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("出生日期不能为空！")
    	}
    	
    	if (!$("#input_major").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("专业不能为空！")
    	}
    	
    	if (!$("#input_classs").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("班级不能为空！")
    	}

    	if (!$("#input_native_place").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("籍贯不能为空！")
    	}
    	
    	if (!$("#input_recruitment_username").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("学号不能为空！")
    	}
    	
    	if (!$("input[name='swap']:checked").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("服从调剂不能为空！")
    	}
    	
    	if (!$("#input_phone").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("手机不能为空！")
    	}
    	
    	if (!$("#input_email").val()) {
    		isSubmit = false;
    		$("#input_head_portrait").val("");
    		alert("邮箱不能为空！")
    	}
    	
    	if (isSubmit) {
    		$.post("/recruitment/create", {
    			nickname: $("#input_nickname").val(),
    			gender: $("#select_gender").val(),
    			birthday: $("#input_birthday").val(),
    			major: $("#input_major").val(),
    			classs: $("#input_classs").val(),
    			nativePlace: $("#input_native_place").val(),
    			username: $("#input_recruitment_username").val(),
    			departmentName: $("#select_department_name").val(),
    			swap: $("input[name='swap']:checked").val(),
    			phone: $("#input_phone").val(),
    			email: $("#input_email").val(),
    			qq: $("#input_qq").val(),
    			hobby: $("#textarea_hobby").val(),
    			selfAppraisal: $("#textarea_self_appraisal").val(),
    			departmentUnderstanding: $("#textarea_department_understanding").val(),
    			awardsAndAchievements: $("#textarea_awards_and_achievements").val()
    		}, function(data, status) {
    			if ("success" == data) {
    				$("#form_head_portrait").submit();
    				alert("提交成功！");
    			} else {
    				$("#input_head_portrait").val("");
    				alert(data);
    			}
    		});
    	}
    });
    
    $("#input_recruitment_username").change(function() {
    	$("#input_head_portrait_username").val($("#input_recruitment_username").val());
    });
});