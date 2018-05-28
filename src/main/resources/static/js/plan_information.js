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
    
    $("#select_plan_type option[value='" + $("#input_plan_type").val() + "']").prop("selected", "selected");
    
    $("#input_change_attachment").click(function() {
    	$("#input_attachment").click();
    });
    
    $("#input_attachment").change(function() {
    	$("#form_create").submit();
    });
    
    $("#input_attachment").hide();
    
    $.post("/department/findForDiagramByPlanType", function(data, status) {
		// diagram start
		var diagramData = new Array();
		
		for (var counter = 0; counter < data.length; counter++) {
			diagramData[counter] = {
				"planType": data[counter][0],
				"planNumber": data[counter][1],
			}
		}
		
        var chart = new AmCharts.AmSerialChart();
        chart.dataProvider = diagramData;
        chart.categoryField = "planType";
        chart.rotate = true;
        chart.depth3D = 20;
        chart.angle = 30;
        var categoryAxis = chart.categoryAxis;
        categoryAxis.gridPosition = "start";
        categoryAxis.axisColor = "#DADADA";
        categoryAxis.fillAlpha = 1;
        categoryAxis.gridAlpha = 0;
        categoryAxis.fillColor = "#FAFAFA";
        var valueAxis = new AmCharts.ValueAxis();
        valueAxis.axisColor = "#DADADA";
        valueAxis.title = "各类型策划通过量";
        valueAxis.gridAlpha = 0.1;
        chart.addValueAxis(valueAxis);
        var graph = new AmCharts.AmGraph();
        graph.valueField = "planNumber";
        graph.type = "column";
        graph.balloonText = "[[value]]";
        graph.lineAlpha = 0;
        graph.fillColors = "#BF1C25";
        graph.fillAlphas = 1;
        chart.addGraph(graph);
        chart.creditsPosition = "top-right";
        chart.write("div_diagram");
	    // diagram end
	});
    
    $("#input_change_submit").click(function() {
    	var isSubmit = true;

        if (!$("#input_plan_name").val()) {
            isSubmit = false;
            alert("活动名称不能为空！")
        }
        
        if (!$("#input_activity_date").val()) {
            isSubmit = false;
            alert("活动时间不能为空！")
        }
        
        if (!$("#input_activity_place").val()) {
            isSubmit = false;
            alert("活动地点不能为空！")
        }
        
        if (!$("#textarea_activity_background").val()) {
            isSubmit = false;
            alert("活动背景不能为空！")
        }
        
        if (!$("#textarea_activity_purpose").val()) {
            isSubmit = false;
            alert("活动目的不能为空！")
        }
        
        if (!$("#select_plan_type").val()) {
            isSubmit = false;
            alert("活动类型不能为空！")
        }
        
        if (!$("#input_activity_theme").val()) {
            isSubmit = false;
            alert("活动主题不能为空！")
        }
        
        if (!$("#input_activity_object").val()) {
            isSubmit = false;
            alert("活动对象不能为空！")
        }
        
        if (isSubmit) {
            var date = $("#input_activity_date").val().substring(0, $("#input_activity_date").val().indexOf("T")) + " " + $("#input_activity_date").val().substring($("#input_activity_date").val().indexOf("T") + 1);
            
            $.post("/plan/changeById", {
            	id: $("#input_id").val(),
            	planName: $("#input_plan_name").val(),
                planType: $("#select_plan_type").val(),
                activityDate: date,
                activityPlace: $("#input_activity_place").val(),
                activityBackground: $("#textarea_activity_background").val(),
                activityPurpose: $("#textarea_activity_purpose").val(),
                activityTheme: $("#input_activity_theme").val(),
                activityObject: $("#input_activity_object").val()
            }, function(data, status) {
                if ("success" == data) {
                    alert("修改成功！")
                } else {
                    alert("修改失败！");
                }
                
                window.location.reload();
            });
        }
    });
    
    $("#input_change_for_pass_submit").click(function() {
        $.post("/plan/changeStatusForPassByIds", {
        	ids: $("#input_id").val() + ", ",
        }, function(data, status) {
            if ("success" == data) {
                alert("通过成功！")
            } else {
                alert("通过失败！");
            }
            
            window.location.href = "/plan/findActive";
        });
    });
    
    $("#input_change_for_remove_submit").click(function() {
        $.post("/plan/changeStatusForRemoveByIds", {
        	ids: $("#input_id").val() + ", ",
        }, function(data, status) {
            if ("success" == data) {
                alert("删除成功！")
            } else {
                alert("删除失败！");
            }
            
            window.location.href = $("#a_find").prop("href");
        });
    });
    
    $("#input_remove_submit").click(function() {
        $.post("/plan/removeByIds", {
        	ids: $("#input_id").val() + ", ",
        }, function(data, status) {
            if ("success" == data) {
                alert("删除成功！")
            } else {
                alert("删除失败！");
            }
            
            window.location.href = "/plan/findOverdue";
        });
    });
});