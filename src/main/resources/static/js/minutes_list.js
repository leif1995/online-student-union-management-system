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
    
    for (var counter = 0; counter < $(".a-department-name").length; counter++) {
    	if ($("#input_department_name").val() == $(".a-department-name").eq(counter).text()) {
    		$(".a-department-name").eq(counter).parent().addClass("active");
    		break;
    	}
    }
    
    $(".a-department-name").on("click", function() {
    	$(".a-department-name").parent().removeClass("active");
    	$(this).parent().addClass("active");
    	window.location.href = "/minutes/findByDepartmentName?departmentName=" + $(this).text() + "&search=" + $("#input_search").val();
    });
    
    $("#input_search_submit").click(function() {
    	window.location.href = "/minutes/findByDepartmentName?departmentName=" + $("#input_department_name").val() + "&search=" + $("#input_search").val();
    });
    
    $(".a-minutes-name").on("click", function() {
    	$.post("/minutes/findById", {
            id: $(this).parent().parent().next().next().next().next().next().next().next().next().next().next().find(".minutes-id").val()
        }, function(data, status) {
        	$("#input_id_information").val(data.id);
            $("#input_start_time_information").val(data.start_time);
            $("#input_place_information").val(data.place);
            $("#input_host_information").val(data.host);
            $("#input_end_time_information").val(data.end_time);
            $("#input_leaver_information").val(data.leaver);
            $("#input_minutes_name_information").val(data.minutes_name);
            $("#input_later_information").val(data.later);
            $("#input_attendees_information").val(data.attendees);
            $("#input_absenteeismer_information").val(data.absenteeismer);
            $("#textarea_minutes_content_information").val(data.content);
        });
    });
    
    $("#input_host_information").click(function() {
    	$("#h_flag").text("修改主持人");
    	
    	for (var data in $("#input_host_information").val().split(";")) {
    		$("#div_right").append("<li><span>" + $("#input_host_information").val().split(";")[data] + "</span></li>")
    	}
    });
    
    $("#input_leaver_information").click(function() {
    	$("#h_flag").text("修改请假人");
    	
    	for (var data in $("#input_leaver_information").val().split(";")) {
    		$("#div_right").append("<li><span>" + $("#input_leaver_information").val().split(";")[data] + "</span></li>")
    	}
    });
    
    $("#input_later_information").click(function() {
    	$("#h_flag").text("修改迟到人");
    	
    	for (var data in $("#input_later_information").val().split(";")) {
    		$("#div_right").append("<li><span>" + $("#input_later_information").val().split(";")[data] + "</span></li>")
    	}
    });
    
    $("#input_absenteeismer_information").click(function() {
    	$("#h_flag").text("修改旷会人");
    	
    	for (var data in $("#input_absenteeismer_information").val().split(";")) {
    		$("#div_right").append("<li><span>" + $("#input_absenteeismer_information").val().split(";")[data] + "</span></li>")
    	}
    });
    
    $("#input_change_submit").click(function() {
    	var isSubmit = true;

    	if (!$("#input_start_time_information").val()) {
            isSubmit = false;
            alert("开会时间不能为空！")
        }
        
        if (!$("#input_place_information").val()) {
            isSubmit = false;
            alert("会议地址不能为空！")
        }
        
        if (!$("#input_host_information").val()) {
            isSubmit = false;
            alert("主持人不能为空！")
        }
        
        if (!$("#input_end_time_information").val()) {
            isSubmit = false;
            alert("闭会时间不能为空！")
        }
        
        if (!$("#input_minutes_name_information").val()) {
            isSubmit = false;
            alert("会议名称不能为空！")
        }
        
        if (!$("#input_attendees_information").val()) {
            isSubmit = false;
            alert("出席人不能为空！")
        }
        
        if (!$("#textarea_minutes_content_information").val()) {
            isSubmit = false;
            alert("会议内容不能为空！")
        }
        
        if (isSubmit) {
            $.post("/minutes/changeById", {
            	id: $("#input_id_information").val(),
            	minutesName: $("#input_minutes_name_information").val(),
                departmentName: $("#input_department_name_information").val(),
                startTime: $("#input_start_time_information").val(),
                endTime: $("#input_end_time_information").val(),
                place: $("#input_place_information").val(),
                host: $("#input_host_information").val(),
                attendees: $("#input_attendees_information").val(),
                leaver: $("#input_leaver_information").val(),
                later: $("#input_later_information").val(),
                absenteeismer: $("#input_absenteeismer_information").val(),
                content: $("#textarea_minutes_content_information").val(),
            }, function(data, status) {
                if ("success" == data) {
                    alert("保存成功！")
                } else {
                    alert("保存失败！");
                }
            });
        }
    });
    
    $("input[value = '删除']").on("click", function() {
        var id = $(this).next().val();
        
        $("#input_remove_submit").click(function() {
            if (id > 0) {
            	$.post("/minutes/removeById", {
                    id: id
                }, function(data, status) {
                    if ("success" == data) {
                        alert("删除成功！")
                    } else {
                        alert("删除失败！");
                    }
                    
                    window.location.reload();
                });
            }
        });
        
        $("#modal_remove").on("hidden.bs.modal", function() {
        	id = -1;
        });
    });
    
    if ($("#a_current_page").text() == 1) {
    	$("#li_laquo").addClass("disabled");
        $("#li_lt").addClass("disabled");
    }
    
    if ($("#a_current_page").text() == $("#a_page_count").text().substring(2, 3)) {
    	$("#li_raquo").addClass("disabled");
        $("#li_gt").addClass("disabled");
    }
    
    $("#li_laquo").click(function() {
    	var isPrev = true;
    	if ($("#a_current_page").text() <= 1) {
    		isPrev = false;
    	}
    	
    	if (isPrev) {
    		$("#a_current_page").text("1");
        	$("#li_laquo").addClass("disabled");
            $("#li_lt").addClass("disabled");
            $("#li_raquo").removeClass("disabled");
        	$("#li_gt").removeClass("disabled");
        	window.location.href = "/minutes/findByDepartmentName?departmentName=" + $("#input_department_name").val() + "&search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
    	}
    });
    
    $("#li_lt").click(function() {
    	var isPrev = true;
    	
    	if ($("#a_current_page").text() <= 1) {
    		isPrev = false;
    	}
    	
    	if (isPrev) {
    		if ($("#a_current_page").text() == 2) {
        		$("#li_laquo").addClass("disabled");
                $("#li_lt").addClass("disabled");
                $("#li_raquo").removeClass("disabled");
            	$("#li_gt").removeClass("disabled");
        	}
       	
        	$("#a_current_page").text(parseInt($("#a_current_page").text()) - 1);
        	window.location.href = "/minutes/findByDepartmentName?departmentName=" + $("#input_department_name").val() + "&search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
    	}
    });
    
    $("#li_gt").click(function() {
    	var isNext = true;
    	
    	if ($("#a_current_page").text() >= $("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2)) {
    		isNext = false;
    	}
    	
    	if (isNext) {
    		if ($("#a_current_page").text() == parseInt($("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2)) - 1) {
    			$("#li_laquo").removeClass("disabled");
            	$("#li_lt").removeClass("disabled");
        		$("#li_raquo").addClass("disabled");
            	$("#li_gt").addClass("disabled");
        	}
       	
    		$("#a_current_page").text(parseInt($("#a_current_page").text()) + 1);
        	window.location.href = "/minutes/findByDepartmentName?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
    	}
    });
    
    $("#li_raquo").click(function() {
    	var isNext = true;
    	
    	if ($("#a_current_page").text() >= $("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2)) {
    		isNext = false;
    	}
    	
    	if (isNext) {
    		$("#a_current_page").text($("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2));
        	$("#li_laquo").removeClass("disabled");
        	$("#li_lt").removeClass("disabled");
    		$("#li_raquo").addClass("disabled");
        	$("#li_gt").addClass("disabled");
        	window.location.href = "/minutes/findByDepartmentName?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
    	}
    });
    
    $("#li_go").click(function() {
    	if ($.isNumeric($("#input_go").val()) && $("#input_go").val() != "") {
    		$("#a_current_page").text($("#input_go").val());
    		
    		if ($("#input_go").val() > $("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2)) {
            	$("#a_current_page").text($("#a_page_count").text().substring(2, $("#a_page_count").text().length - 2));
            }

            if ($("#input_go").val() < 1) {
            	$("#a_current_page").text("1");
            }
            
            window.location.href = "/minutes/findByDepartmentName?departmentName=" + $("#input_department_name").val() + "&search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
        } else {
            alert("请输入数字！");
            $("#input_go").val("");
        }
    });
    
    $("#input_host").click(function() {
    	$("#h_flag").text("主持人");
    });
    
    $("#input_leaver").click(function() {
    	$("#h_flag").text("请假人");
    });
    
    $("#input_later").click(function() {
    	$("#h_flag").text("迟到人");
    });
    
    $("#input_absenteeismer").click(function() {
    	$("#h_flag").text("旷会人");
    });
    
    $("#modal_switch").on("shown.bs.modal", function() {
    	$(".a-modal-department-name").eq(0).parent().addClass("active");
    	$("#div_left").html("");
    	
    	$.post("/findAllByDepartmentName", {
    		departmentName: $(".a-modal-department-name").eq(0).text()
    	}, function(data, status) {
    		for (var counter = 0; counter < data.length; counter++) {
    			$("#div_left").append("<li><span>" + data[counter].username + "-" + data[counter].nickname + "</span></li>");
    		}
    		
    		for (var rightCounter = 0; rightCounter < $("#div_right li").length; rightCounter++) {
    			for (var leftCounter = 0; leftCounter < $("#div_left li").length; leftCounter++) {
    				if ($("#div_right li").eq(rightCounter).text() == $("#div_left li").eq(leftCounter).text()) {
    					$("#div_left li").eq(leftCounter).remove();
    					break;
    				}
    			}
			}
    	});
    });
    
    $(".a-modal-department-name").on("click", function() {
    	$(".a-modal-department-name").parent().removeClass("active");
    	$(this).parent().addClass("active");
    	$("#div_left").html("");
    	
    	$.post("/findAllByDepartmentName", {
    		departmentName: $(this).text()
    	}, function(data, status) {
    		for (var counter = 0; counter < data.length; counter++) {
    			$("#div_left").append("<li><span>" + data[counter].username + "-" + data[counter].nickname + "</span></li>");
    		}
    		
    		for (var rightCounter = 0; rightCounter < $("#div_right li").length; rightCounter++) {
    			for (var leftCounter = 0; leftCounter < $("#div_left li").length; leftCounter++) {
    				if ($("#div_right li").eq(rightCounter).text() == $("#div_left li").eq(leftCounter).text()) {
    					$("#div_left li").eq(leftCounter).remove();
    					break;
    				}
    			}
			}
    	});
    });
    
    $("#input_switch_submit").click(function() {
    	if ("主持人" == $("#h_flag").text()) {
    		$("#input_host").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_host").val($("#input_host").val() + $("#div_right span").eq(counter).text() + ";");
    		}
    		
    		$("#input_host").val($("#input_host").val().substring(0, $("#input_host").val().length - 1));
    	}
    	
    	if ("请假人" == $("#h_flag").text()) {
    		$("#input_leaver").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_leaver").val($("#input_leaver").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_leaver").val($("#input_leaver").val().substring(0, $("#input_leaver").val().length - 1));
    	}
    	
    	if ("迟到人" == $("#h_flag").text()) {
    		$("#input_later").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_later").val($("#input_later").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_later").val($("#input_later").val().substring(0, $("#input_later").val().length - 1));
    	}
    	
    	if ("旷会人" == $("#h_flag").text()) {
    		$("#input_absenteeismer").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_absenteeismer").val($("#input_absenteeismer").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_absenteeismer").val($("#input_absenteeismer").val().substring(0, $("#input_absenteeismer").val().length - 1));
    	}
    	
    	if ("修改主持人" == $("#h_flag").text()) {
    		$("#input_host_information").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_host_information").val($("#input_host_information").val() + $("#div_right span").eq(counter).text() + ";");
    		}
    		
    		$("#input_host_information").val($("#input_host_information").val().substring(0, $("#input_host_information").val().length - 1));
    	}
    	
    	if ("修改请假人" == $("#h_flag").text()) {
    		$("#input_leaver_information").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_leaver_information").val($("#input_leaver_information").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_leaver_information").val($("#input_leaver_information").val().substring(0, $("#input_leaver_information").val().length - 1));
    	}
    	
    	if ("修改迟到人" == $("#h_flag").text()) {
    		$("#input_later_information").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_later_information").val($("#input_later_information").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_later_information").val($("#input_later_information").val().substring(0, $("#input_later_information").val().length - 1));
    	}
    	
    	if ("修改旷会人" == $("#h_flag").text()) {
    		$("#input_absenteeismer_information").val("");
    		
    		for (var counter = 0; counter < $("#div_right li").length; counter++) {
    			$("#input_absenteeismer_information").val($("#input_absenteeismer_information").val() + $("#div_right li").eq(counter).text() + ";");
    		}
    		
    		$("#input_absenteeismer_information").val($("#input_absenteeismer_information").val().substring(0, $("#input_absenteeismer_information").val().length - 1));
    	}
    	
    	$("#modal_switch").modal("hide");
    });
    
    $("#modal_switch").on("hidden.bs.modal", function() {
    	$("#div_right").html("");
    	$(".a-modal-department-name").parent().removeClass("active");
    });
    
    $("#input_create_submit").click(function() {
    	var isSubmit = true;

    	if (!$("#input_start_time").val()) {
            isSubmit = false;
            alert("开会时间不能为空！")
        }
        
        if (!$("#input_place").val()) {
            isSubmit = false;
            alert("会议地址不能为空！")
        }
        
        if (!$("#input_host").val()) {
            isSubmit = false;
            alert("主持人不能为空！")
        }
        
        if (!$("#input_end_time").val()) {
            isSubmit = false;
            alert("闭会时间不能为空！")
        }
        
        if (!$("#input_minutes_name").val()) {
            isSubmit = false;
            alert("会议名称不能为空！")
        }
        
        if (!$("#input_attendees").val()) {
            isSubmit = false;
            alert("出席人不能为空！")
        }
        
        if (!$("#textarea_minutes_content").val()) {
            isSubmit = false;
            alert("会议内容不能为空！")
        }
        
        if (isSubmit) {
            $.post("/minutes/create", {
            	minutesName: $("#input_minutes_name").val(),
                departmentName: $("#input_department_name").val(),
                startTime: $("#input_start_time").val(),
                endTime: $("#input_end_time").val(),
                place: $("#input_place").val(),
                host: $("#input_host").val(),
                attendees: $("#input_attendees").val(),
                leaver: $("#input_leaver").val(),
                later: $("#input_later").val(),
                absenteeismer: $("#input_absenteeismer").val(),
                content: $("#textarea_minutes_content").val(),
            }, function(data, status) {
                if ("success" == data) {
                    alert("新增成功！")
                } else {
                    alert("新增失败！");
                }
                
                window.location.reload();
            });
        }
    });
    
    $("#modal_create").on("hidden.bs.modal", function() {
    	$("#input_start_time").val("");
    	$("#input_place").val("");
    	$("#input_host").val("");
    	$("#input_end_time").val("");
    	$("#input_leaver").val("");
    	$("#input_minutes_name").val("");
    	$("#input_later").val("");
    	$("#input_attendees").val("");
    	$("#input_absenteeismer").val("");
    	$("#textarea_minutes_content").val("");
    });
    
    $(".box").orso({
		boxl:".box_l",// 左边大盒子
		boxr:".box_r",// 右边大盒子
		boxlrX:"li",// 移动小盒子
		boxon:"on",// 点击添加属性
		idclass:true,// 添加的属性是否为class：true=class; false=id;
		boxlan:"#left",// 单个向左移动按钮
		boxran:"#right",// 单个向右移动按钮
		boxtan:"#top",// 向上移动一位按钮
		boxban:"#bottom",// 向下移动一位按钮
		boxalllan:"#allleft",// 全部向左移动按钮
		boxallran:"#allright",// 全部向右移动按钮
		boxalltan:"#alltop",// 移动至第一位按钮
		boxallban:"#allbottom"// 移动至最后位按钮
	});
});