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
    
    $(".a-department-name").on("click", function() {
    	$(".a-department-name").parent().removeClass("active");
    	$(this).parent().addClass("active");
    	
    	$.post("/findAllByDepartmentName", {
    		departmentName: $(this).text()
    	}, function(data, status) {
			// diagram start
			var diagramData = new Array();
			
			for (var counter = 0; counter < data.length; counter++) {
				diagramData[counter] = {
					"nickname": data[counter].nickname,
					"planNumber": data[counter].plan_completed_number
				}
			}
			
		    var chart = new AmCharts.AmPieChart();
		    chart.addTitle($("#div_department_list .active").text() + "策划通过量占比", 16);
		    chart.dataProvider = diagramData;
		    chart.titleField = "nickname";
		    chart.valueField = "planNumber";
		    chart.sequencedAnimation = true;
		    chart.startEffect = "elastic";
		    chart.innerRadius = "30%";
		    chart.startDuration = 2;
		    chart.labelRadius = 15;
		    chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
		    chart.depth3D = 10;
		    chart.angle = 15;
		    chart.write("div_user_diagram_department_plan");
		    // diagram end
		    $("#ul_user_link_department_nickname li").hide();
    		
    		for (var counterX = 0; counterX < data.length; counterX++) {
    			for (var counterY = 0; counterY < $(".a-information").length; counterY++) {
    				if ($(".a-information").eq(counterY).next().val() == data[counterX].username) {
        				$(".a-information").eq(counterY).parent().show();
        			}
        		}
    		}
    	});
    });
    
    $.post("/findTopEight", function(data, status) {
		// diagram start
		var diagramData = new Array();
		
		for (var counter = 0; counter < data.length; counter++) {
			diagramData[counter] = {
				"nickname": data[counter].nickname + "[" + data[counter].department_name.substring(0, 1) + "]",
				"planNumber": data[counter].plan_completed_number
			}
		}
		
	    var chart = new AmCharts.AmPieChart();
	    chart.addTitle("总成员策划通过量前八名占比", 16);
	    chart.dataProvider = diagramData;
	    chart.titleField = "nickname";
	    chart.valueField = "planNumber";
	    chart.sequencedAnimation = true;
	    chart.startEffect = "elastic";
	    chart.innerRadius = "30%";
	    chart.startDuration = 2;
	    chart.labelRadius = 15;
	    chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
	    chart.depth3D = 10;
	    chart.angle = 15;
	    chart.write("div_user_diagram_plan");
	    // diagram end
	});
    
    $("#a_top_eight").click(function() {
    	$("#a_top_eight").parent().addClass("active");
    	$("#a_top_one").parent().removeClass("active");
    	
    	$.post("/findTopEight", function(data, status) {
    		// diagram start
    		var diagramData = new Array();
    		
    		for (var counter = 0; counter < data.length; counter++) {
    			diagramData[counter] = {
    				"nickname": data[counter].nickname + "[" + data[counter].department_name.substring(0, 1) + "]",
    				"planNumber": data[counter].plan_completed_number
    			}
    		}
    		
    	    var chart = new AmCharts.AmPieChart();
    	    chart.addTitle("总成员策划通过量前八名占比", 16);
    	    chart.dataProvider = diagramData;
    	    chart.titleField = "nickname";
    	    chart.valueField = "planNumber";
    	    chart.sequencedAnimation = true;
    	    chart.startEffect = "elastic";
    	    chart.innerRadius = "30%";
    	    chart.startDuration = 2;
    	    chart.labelRadius = 15;
    	    chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
    	    chart.depth3D = 10;
    	    chart.angle = 15;
    	    chart.write("div_user_diagram_plan");
    	    // diagram end
    	});
    });
    
    $("#a_top_one").click(function() {
    	$("#a_top_one").parent().addClass("active");
    	$("#a_top_eight").parent().removeClass("active");
    	
    	$.post("/findTopOneByDepartmentName", function(data, status) {
    		// diagram start
    		var diagramData = new Array();
    		
    		for (var counter = 0; counter < data.length; counter++) {
    			diagramData[counter] = {
    				"nickname": data[counter].nickname + "[" + data[counter].department_name.substring(0, 1) + "]",
    				"planNumber": data[counter].plan_completed_number
    			}
    		}
    		
    	    var chart = new AmCharts.AmPieChart();
    	    chart.addTitle("各部门策划通过量第一名占比", 16);
    	    chart.dataProvider = diagramData;
    	    chart.titleField = "nickname";
    	    chart.valueField = "planNumber";
    	    chart.sequencedAnimation = true;
    	    chart.startEffect = "elastic";
    	    chart.innerRadius = "30%";
    	    chart.startDuration = 2;
    	    chart.labelRadius = 15;
    	    chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
    	    chart.depth3D = 10;
    	    chart.angle = 15;
    	    chart.write("div_user_diagram_plan");
    	    // diagram end
    	});
    });
    
    $("#div_table").hide();
    
    $(".a-information").on("click", function() {
    	$("#div_table").fadeIn();
    	
    	$.post("/findByUsername", {
    		username: $(this).next().val()
    	}, function(data, status) {
    		$("#h4_title").text(data.nickname + "的详细信息");
    		$("#input_nickname").val(data.nickname);
    		$("#input_gender").val(data.gender);
    		$("#input_birthday").val(data.birthday);
    		$("#img_head_portrait").prop("src", "ftp://127.0.0.1/head portrait/" + data.username + ".jpg");
    	    $("#input_major").val(data.major);
    	    $("#input_classs").val(data.classs);
    	    $("#input_native_place").val(data.native_place);
    	    $("#input_username").val(data.username);
    	    $("#select_department_name option[value='" + data.department_name + "']").prop("selected", "selected");
    	    $("#input_department_name").val(data.department_name);
    	    $("#select_position_name option[value='" + data.position_name + "']").prop("selected", "selected");
    	    $("#input_position_name").val(data.position_name);
    	    $("#input_phone").val(data.phone);
    	    $("#input_email").val(data.email);
    	    $("#input_qq").val(data.qq);
    	    $("#textarea_hobby").val(data.hobby);
    	    $("#textarea_self_appraisal").val(data.self_appraisal);
    	    $("#textarea_awards_and_achievements").val(data.awards_and_achievements);
    	    
    	    // diagram start
    	    var diagramData = [{
    	        "key": "请假",
    	        "value": data.leave_number
    	    }, {
    	        "key": "迟到",
    	        "value": data.late_number
    	    }, {
    	        "key": "旷会",
    	        "value": data.absenteeism_number
    	    }, {
    	        "key": "策划未通过",
    	        "value": data.plan_overdue_number
    	    }, {
    	        "key": "策划通过",
    	        "value": data.plan_completed_number
    	    }, {
    	        "key": "策划申请",
    	        "value": data.plan_active_number
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

    	        if (!$("#input_nickname").val()) {
    	            isSubmit = false;
    	            alert("姓名不能为空！")
    	        }
    	        
    	        if (isSubmit) {
    	        	if (data.username == $("#input_username").val()) {
	    	        	$.post("/changeByUsername", {
	    	        		username: data.username,
	    	        		nickname: $("#input_nickname").val(),
	    	        		departmentName: $("#select_department_name").val(),
	    	        		positionName: $("#select_position_name").val()
	    	        	}, function(data, status) {
	    	        		if ("success" == data) {
	    	                    alert("修改成功！");
	    	                } else {
	    	                	alert("修改失败！");
	    	                }
	    	        	});
    	        	}
    	        }
    	    });
    	    
    	    $("#input_reset_password_submit").click(function() {
    	    	if (data.username == $("#input_username").val()) {
    	    		$.post("/changePasswordForResetByUsername", {
        	    		username: data.username
        	    	}, function(data, status) {
    	        		if ("success" == data) {
    	                    alert("重置密码成功！");
    	                } else {
    	                	alert("重置密码失败！");
    	                }
    	        		
    	        		$('#modal_reset_password').modal('hide');
    	        	});
    	    	}
    	    });
    	    
    	    $("#input_remove_submit").click(function() {
    	    	if (data.username == $("#input_username").val()) {
    	    		$.post("/removeByUsername", {
        	    		username: data.username
        	    	}, function(data, status) {
    	        		if ("success" == data) {
    	                    alert("退部成功！");
    	                } else {
    	                	alert("退部失败！");
    	                }
    	        		
    	        		window.location.reload();
    	        	});
    	    	}
    	    });
    	    
    	    $("#input_close").click(function() {
    	    	$("#div_table").fadeOut();
    	    });
    	});
    });
});