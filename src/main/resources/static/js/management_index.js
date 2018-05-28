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
    	window.location.href = "/index/findAll?search=" + $("#input_search").val();
    });
    
    $(".a-indexs-name").on("click", function() {
    	var id = $(this).parent().parent().next().next().next().next().next().next().next().find(".indesx-id").val();
    
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
    
    $("input[value = '通过']").on("click", function() {
        var id = $(this).next().next().val();
        
        $("#input_change_for_pass_submit").click(function() {
            if (id > 0) {
            	$.post("/index/changeStatusForPassById", {
                    id: id
                }, function(data, status) {
                    if ("success" == data) {
                        alert("通过成功！")
                    } else {
                        alert("通过失败！");
                    }
                    
                    window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
                });
            }
        });
        
        $("#modal_change_for_pass").on("hidden.bs.modal", function() {
        	id = -1;
        });
    });
    
    $("input[value = '删除']").on("click", function() {
        var id = $(this).next().val();
        
        $("#input_remove_submit").click(function() {
            if (id > 0) {
            	$.post("/index/removeById", {
                    id: id
                }, function(data, status) {
                    if ("success" == data) {
                        alert("删除成功！")
                    } else {
                        alert("删除失败！");
                    }
                    
                    window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
        	window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
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
            
            window.location.href = "/index/findAll?search=" + $("#input_search").val() + "&currentPage=" + $("#a_current_page").text();
        } else {
            alert("请输入数字！");
            $("#input_go").val("");
        }
    });
    
    $("#input_create_submit").click(function() {
    	var isSubmit = true;

        if (!$("#input_indexs_name").val()) {
            isSubmit = false;
            alert("标题不能为空！");
        }
        
        if (isSubmit) {
        	$("#form_create").submit();
        }
    });
    
    $("#modal_create").on("hidden.bs.modal", function() {
    	$("#input_indexs_name").val("");
    	$("#textarea_indexs_content").val("");
    	$("#input_attachment").val("");
    });
});