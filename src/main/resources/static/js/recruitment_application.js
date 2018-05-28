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
    
    $("#input_remove_all_submit").click(function() {
        $.post("/recruitment/removeAll", function(data, status) {
            if ("success" == data) {
                alert("结束招新成功！")
            } else {
                alert("结束招新失败！");
            }
            
            window.location.href = "/activity/findActive";
        });
    });
    
	for (var counter = 0; counter < $(".department-name").length; counter++) {
    	if ($(".department-name").eq(counter).parent().prev().prev().prev().prev().prev().prev().text() == $(".department-name").eq(counter).val()) {
    		$(".department-name").eq(counter).parent().prev().prev().prev().prev().prev().prev().css("background-color","aqua");
    	}
    }
	
	$("input[value = '通过']").on("click", function() {
        $("#span_change_for_pass_nickname").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_pass_gender").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_pass_username").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().text());
        var id = $(this).next().next().val();
        var departmentName = $(this).next().next().next().val()
        
        $("#input_change_for_pass_submit").click(function() {
            if (id > 0) {
            	$.post("/recruitment/changeForDepartmentById", {
                    id: id,
                    departmentName: departmentName
                }, function(data, status) {
                	if ("success" == data) {
                		$.post("/recruitment/changeStatusForPassById", {
                            id: id
                        }, function(data, status) {
                            if ("success" == data) {
                                alert("通过成功！");
                            } else {
                                alert("通过失败！");
                            }
                            
                            window.location.href = "/recruitment/findApplication?currentPage=" + $("#a_current_page").text();
                        });
                    } else {
                        alert("通过失败！");
                    } 
                });
            }
        });
        
        $("#modal_change_for_pass").on("hidden.bs.modal", function() {
        	id = -1;
        });
    });
	
	$("input[value = '淘汰']").on("click", function() {
        $("#span_change_for_remove_nickname").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_remove_gender").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_remove_username").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().text());
        var id = $(this).next().val();
        
        $("#input_change_for_remove_submit").click(function() {
            if (id > 0) {
            	$.post("/recruitment/changeStatusForRemoveById", {
                    id: id
                }, function(data, status) {
                    if ("success" == data) {
                        alert("淘汰成功！")
                    } else {
                        alert("淘汰失败！");
                    }
                    
                    window.location.href = "/recruitment/findApplication?currentPage=" + $("#a_current_page").text();
                });
            }
        });
        
        $("#modal_change_for_remove").on("hidden.bs.modal", function() {
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
        	window.location.href = "/recruitment/findApplication?currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/recruitment/findApplication?currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/recruitment/findApplication?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/recruitment/findApplication?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
            
            window.location.href = "/recruitment/findApplication?currentPage=" + $("#a_current_page").text();
        } else {
            alert("请输入数字！");
            $("#input_go").val("");
        }
    });
});