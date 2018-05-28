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
    
    $("#modal_feedback").on("hidden.bs.modal", function() {
    	$("#textarea_content").val("");
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
    
    $(".a-indexs-name").eq(0).parent().addClass("active");
    
    $("#myCarousel").carousel({
    	interval: 2000
    });
    
    $("#input_notice_board_search_submit, #input_news_center_search_submit, #input_organization_structure_search_submit").click(function() {
    	window.location.href = "/index/rjxy?noticeBoardSearch=" + $("#input_notice_board_search").val() + "&newsCenterSearch=" + $("#input_news_center_search").val() + "&organizationStructureSearch=" + $("#input_organization_structure_search").val();
    });
    
    $(".a-indexs-name").on("click", function() {
    	var id = $(this).next().val();
    
    	$.post("/index/findById", {
    		id: id
    	}, function(data, status) {
    		$("#h_information_indexs_name").text(data.indexs_name + "【" + data.type + "】");
    		$("#span_information_time_by").text(data.updated_time + " 编辑：" + data.created_by + " 审核：" + data.updated_by);
    		
    		if (data.content != "") {
    			$("#textarea_information_indexs_content").val(data.content);
    		} else {
    			$("#textarea_information_indexs_content").hide();
    		}
    		
    		if ("新闻中心" == data.type) {
    			if (data.suffix != " ") {
    				$("#div_footer").append("<img alt='" + data.id + data.suffix + "' src='ftp://127.0.0.1/index/" + data.id + data.suffix + "' width='487px' height='345px' />");
    			}
    		} else {
    			if (data.suffix != " ") {
    				$("#div_footer").append("<div class='input-group div-information-attachment'><span class='input-group-addon'>附件：</span><a href='ftp://127.0.0.1/index/" + data.id + data.suffix + "' class='form-control'>" + data.attachment + data.suffix + "</a></div>");
    			}
    		}
    	});
    });
    
    $("#modal_information").on("hidden.bs.modal", function() {
    	$("#textarea_information_indexs_content").show();
    	$("#div_footer").html("");
    });
    
    $(".div-updated-time span").text($(".div-updated-time span").text().substring(0, 10));
});