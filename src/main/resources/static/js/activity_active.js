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
    
    $("#input_search_submit").click(function() {
    	window.location.href = "/activity/findActive?search=" + $("#input_search").val();
    });
    
    $("#input_checkbox_all").click(function() {
        $("input[type = 'checkbox']").prop("checked", $("#input_checkbox_all").prop("checked"));
        $("#input_change_for_remove_all").val("");
        
        if ($("#input_checkbox_all").prop("checked")) {
            for (var counter = 0; counter < $(".activity-id").length; counter++) {
                $("#input_change_for_remove_all").val($("#input_change_for_remove_all").val() + $(".activity-id").eq(counter).val() + ", ");
            }
        } 
    });

    $(".input-checkbox").on("click", function() {
        if ($(this).prop("checked")) {
            $("#input_change_for_remove_all").val($("#input_change_for_remove_all").val() + $(this).parent().parent().next().next().next().next().next().next().next().next().next().find(".activity-id").val() + ", ");
        } else {
            $("#input_change_for_remove_all").val($("#input_change_for_remove_all").val().replace($(this).parent().parent().next().next().next().next().next().next().next().next().next().find(".activity-id").val() + ", ", ""));
        }
    });
    
    $("input[value = '修改']").on("click", function() {
        var currentDate = $(this).parent().prev().prev().prev().prev().prev().prev().text().substring(0, $(this).parent().prev().prev().prev().prev().prev().prev().text().indexOf(" ")) + "T" + $(this).parent().prev().prev().prev().prev().prev().prev().text().substring($(this).parent().prev().prev().prev().prev().prev().prev().text().indexOf(" ") + 1);
        $("#input_change_name").val($(this).parent().prev().prev().prev().prev().prev().prev().prev().text());
        $("#input_change_date").val(currentDate);
        $("#input_change_place").val($(this).parent().prev().prev().prev().prev().prev().text());
        var id = $(this).next().next().val();
        
        $("#input_change_submit").click(function() {
            if (id > 0) {
            	var isSubmit = true;

                if (!$("#input_change_name").val()) {
                    isSubmit = false;
                    alert("活动名称不能为空！")
                }
                
                if (!$("#input_change_date").val()) {
                    isSubmit = false;
                    alert("活动时间不能为空！")
                }
                
                if (!$("#input_change_place").val()) {
                    isSubmit = false;
                    alert("活动地点不能为空！")
                }
                
                if (isSubmit) {
                    var date = $("#input_change_date").val().substring(0, $("#input_change_date").val().indexOf("T")) + " " + $("#input_change_date").val().substring($("#input_change_date").val().indexOf("T") + 1);
                    
                    $.post("/activity/changeById", {
                        id: id,
                        activityName: $("#input_change_name").val(),
                        activityDate: date,
                        activityPlace: $("#input_change_place").val()
                    }, function(data, status) {
                        if ("success" == data) {
                            alert("修改成功！")
                        } else {
                            alert("修改失败！");
                        }
                        
                        window.location.href = "/activity/findActive?currentPage=" + $("#a_current_page").text();
                    });
                }
            }
        });
        
        $("#modal_change").on("hidden.bs.modal", function() {
        	id = -1;
        });
    });
    
    $("input[value = '删除']").on("click", function() {
        $("#span_change_for_remove_name").text($(this).parent().prev().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_remove_date").text($(this).parent().prev().prev().prev().prev().prev().prev().text());
        $("#span_change_for_remove_place").text($(this).parent().prev().prev().prev().prev().prev().text());
        var id = $(this).next().val();
        
        $("#input_change_for_remove_submit").click(function() {
            if (id > 0) {
            	$.post("/activity/changeStatusForRemoveByIds", {
                    ids: id + ", "
                }, function(data, status) {
                    if ("success" == data) {
                        alert("删除成功！")
                    } else {
                        alert("删除失败！");
                    }
                    
                    window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
            
            window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
        } else {
            alert("请输入数字！");
            $("#input_go").val("");
        }
    });
    
    $("#modal_create").on("hidden.bs.modal", function() {
        $("#input_create_name").val("");
        $("#input_create_date").val("");
        $("#input_create_place").val("");
    });
    
    $("#input_create_submit").click(function() {
        var isSubmit = true;

        if (!$("#input_create_name").val()) {
            isSubmit = false;
            alert("活动名称不能为空！")
        }
        
        if (!$("#input_create_date").val()) {
            isSubmit = false;
            alert("活动时间不能为空！")
        }
        
        if (!$("#input_create_place").val()) {
            isSubmit = false;
            alert("活动地点不能为空！")
        }
        
        if (isSubmit) {
            var date = $("#input_create_date").val().substring(0, $("#input_create_date").val().indexOf("T")) + " " + $("#input_create_date").val().substring($("#input_create_date").val().indexOf("T") + 1);
            
            $.post("/activity/create", {
                activityName: $("#input_create_name").val(),
                activityDate: date,
                activityPlace: $("#input_create_place").val()
            }, function(data, status) {
                if ("success" == data) {
                    alert("创建成功！")
                } else {
                    alert("创建失败！");
                }
                
                window.location.href = "/activity/findActive";
            });
        }
    });
    
    $("#input_change_for_remove_all_submit").click(function() {
        if (!$("#input_change_for_remove_all").val()) {
        	alert("请选择至少一条记录！");
        	window.location.reload();
        }
        
        $.post("/activity/changeStatusForRemoveByIds", {
            ids: $("#input_change_for_remove_all").val()
        }, function(data, status) {
            if ("success" == data) {
                alert("删除成功！")
            } else {
                alert("删除失败！");
            }
            
            window.location.href = "/activity/findActive?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
        });
    });
});