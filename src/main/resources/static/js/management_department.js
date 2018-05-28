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
    
    $.post("/department/findForDiagramByDepartmentName", function(data, status) {
    	// diagram start
    	var diagramData = new Array();
    	
    	for (var counter = 0; counter < data.length - 1; counter++) {
    		diagramData[counter] = {
    			"departmentName": data[counter][0].department_name,
    			"peopleNumber": data[counter][0].people_number,
    			"planNumber": data[counter][1],
    			"color": "#" + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16)
    		}
    	}
    	
        AmCharts.makeChart("div_department_diagram_plan", {
            type: "serial", 
            dataProvider: diagramData,
            categoryField: "departmentName",
            depth3D: 20,
            angle: 30,

            categoryAxis: {
                labelRotation: 90,
                gridPosition: "start"
            },

            valueAxes: [{
                title: "部门策划通过量（共" + data[data.length - 1][0] + "份）"
            }],

            graphs: [{
                valueField: "planNumber",
                colorField: "color",
                type: "column",
                lineAlpha: 0,
                fillAlphas: 1
            }],

            chartCursor: {
                cursorAlpha: 0,
                zoomable: false,
                categoryBalloonEnabled: false
            },

            exportConfig: {
                menuTop: "21px",
                menuBottom: "auto",
                menuRight: "21px",
                backgroundColor: "#efefef",

                menuItemStyle: {
                	backgroundColor: "#EFEFEF",
                	rollOverBackgroundColor: "#DDDDDD"
                },

                menuItems: [{
                    textAlign: "center",
                    icon: "/images/export.png",
                    onclick: function() {},
                    items: [{
                        title: "JPG",
                        format: "jpg"
                    }, {
                        title: "PNG",
                        format: "png"
                    }, {
                        title: "SVG",
                        format: "svg"
                    }, {
                        title: "PDF",
                        format: "pdf"
                    }]
                }]
            }
        });
        
        AmCharts.makeChart("div_department_diagram_people", {
            type: "serial", 
            dataProvider: diagramData,
            categoryField: "departmentName",
            depth3D: 20,
            angle: 30,

            categoryAxis: {
                labelRotation: 90,
                gridPosition: "start"
            },

            valueAxes: [{
                title: "部门人数（共" + data[data.length - 1][1] + "人）"
            }],

            graphs: [{
                valueField: "peopleNumber",
                colorField: "color",
                type: "column",
                lineAlpha: 0,
                fillAlphas: 1
            }],

            chartCursor: {
                cursorAlpha: 0,
                zoomable: false,
                categoryBalloonEnabled: false
            },

            exportConfig: {
                menuTop: "21px",
                menuBottom: "auto",
                menuRight: "21px",
                backgroundColor: "#efefef",

                menuItemStyle: {
                	backgroundColor: "#EFEFEF",
                	rollOverBackgroundColor: "#DDDDDD"
                },

                menuItems: [{
                    textAlign: "center",
                    icon: "/images/export.png",
                    onclick: function() {},
                    items: [{
                        title: "JPG",
                        format: "jpg"
                    }, {
                        title: "PNG",
                        format: "png"
                    }, {
                        title: "SVG",
                        format: "svg"
                    }, {
                        title: "PDF",
                        format: "pdf"
                    }]
                }]
            }
        });
        // diagram end
    });
    
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
        chart.write("div_department_diagram_type");
	    // diagram end
	});
    
    $("#a_department_number").hide();
    
    $("#a_position_number").click(function() {
    	$("#a_position_number").hide();
    	$("#a_department_number").show();
    	
    	$.post("/position/findForDiagramByPositionName", function(data, status) {
    		// diagram start
        	var diagramData = new Array();
        	
        	for (var counter = 0; counter < data.length - 1; counter++) {
        		diagramData[counter] = {
        			"positionName": data[counter].position_name,
        			"peopleNumber": data[counter].people_number,
        			"color": "#" + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16)
        		}
        	}
        	
            AmCharts.makeChart("div_department_diagram_people", {
                type: "serial", 
                dataProvider: diagramData,
                categoryField: "positionName",
                depth3D: 20,
                angle: 30,

                categoryAxis: {
                    labelRotation: 90,
                    gridPosition: "start"
                },

                valueAxes: [{
                    title: "职务人数（共" + data[data.length - 1] + "人）"
                }],

                graphs: [{
                    valueField: "peopleNumber",
                    colorField: "color",
                    type: "column",
                    lineAlpha: 0,
                    fillAlphas: 1
                }],

                chartCursor: {
                    cursorAlpha: 0,
                    zoomable: false,
                    categoryBalloonEnabled: false
                },

                exportConfig: {
                    menuTop: "21px",
                    menuBottom: "auto",
                    menuRight: "21px",
                    backgroundColor: "#efefef",

                    menuItemStyle: {
                    	backgroundColor: "#EFEFEF",
                    	rollOverBackgroundColor: "#DDDDDD"
                    },

                    menuItems: [{
                        textAlign: "center",
                        icon: "/images/export.png",
                        onclick: function() {},
                        items: [{
                            title: "JPG",
                            format: "jpg"
                        }, {
                            title: "PNG",
                            format: "png"
                        }, {
                            title: "SVG",
                            format: "svg"
                        }, {
                            title: "PDF",
                            format: "pdf"
                        }]
                    }]
                }
            });
            // diagram end
    	});
    });
    
    $("#a_department_number").click(function() {
    	$("#a_department_number").hide();
    	$("#a_position_number").show();
    	
    	$.post("/department/findForDiagramByDepartmentName", function(data, status) {
        	// diagram start
        	var diagramData = new Array();
        	
        	for (var counter = 0; counter < data.length - 1; counter++) {
        		diagramData[counter] = {
        			"departmentName": data[counter][0].department_name,
        			"peopleNumber": data[counter][0].people_number,
        			"color": "#" + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16)
        		}
        	}
            
            AmCharts.makeChart("div_department_diagram_people", {
                type: "serial", 
                dataProvider: diagramData,
                categoryField: "departmentName",
                depth3D: 20,
                angle: 30,

                categoryAxis: {
                    labelRotation: 90,
                    gridPosition: "start"
                },

                valueAxes: [{
                    title: "部门人数（共" + data[data.length - 1][1] + "人）"
                }],

                graphs: [{
                    valueField: "peopleNumber",
                    colorField: "color",
                    type: "column",
                    lineAlpha: 0,
                    fillAlphas: 1
                }],

                chartCursor: {
                    cursorAlpha: 0,
                    zoomable: false,
                    categoryBalloonEnabled: false
                },

                exportConfig: {
                    menuTop: "21px",
                    menuBottom: "auto",
                    menuRight: "21px",
                    backgroundColor: "#efefef",

                    menuItemStyle: {
                    	backgroundColor: "#EFEFEF",
                    	rollOverBackgroundColor: "#DDDDDD"
                    },

                    menuItems: [{
                        textAlign: "center",
                        icon: "/images/export.png",
                        onclick: function() {},
                        items: [{
                            title: "JPG",
                            format: "jpg"
                        }, {
                            title: "PNG",
                            format: "png"
                        }, {
                            title: "SVG",
                            format: "svg"
                        }, {
                            title: "PDF",
                            format: "pdf"
                        }]
                    }]
                }
            });
            // diagram end
        });
    });
    
    if ("团学会介绍" == $("#p_department_name").text()) {
    	$("#textarea_introduction").attr("readonly", "readonly");
    	$("#input_change_submit").hide();
    	$("#input_remove").hide();
    }
    
    $(".a-department-name").on("click", function() {
    	$(".a-department-name").parent().removeClass("active");
    	$(this).parent().addClass("active");
    	$("#textarea_introduction").removeAttr("readonly");
    	$("#input_change_submit").show();
    	
    	$.post("/department/findById", {
    		id: $(this).next().val()
    	}, function(data, status) {
    		$("#p_department_name").text(data.department_name + "介绍");
    		$("#textarea_introduction").val(data.introduction);
    		
    		if ("主席团介绍" != $("#p_department_name").text() && "秘书处介绍" != $("#p_department_name").text() && "办公室介绍" != $("#p_department_name").text() && "提案调研部介绍" != $("#p_department_name").text() && "组织部介绍" != $("#p_department_name").text() && "新媒体宣传部介绍" != $("#p_department_name").text()) {
        		$("#input_remove").show();
        	} else {
        		$("#input_remove").hide();
        	}
    	});
    });
    
    $("#input_create_submit").click(function() {
    	if ($("#input_department_name").val()) {
    		$.post("/department/create", {
    			departmentName: $("#input_department_name").val()
    		}, function(data, status) {
    			if ("success" == data) {
    				alert("新增成功！");
    			} else {
    				alert(data);
    			}
    			
    			window.location.reload();
    		});
    	} else {
    		alert("部门名称不能为空！");
    		window.location.reload();
    	}
    }); 
    
    $("#modal_create").on("hidden.bs.modal", function() {
    	$("#input_department_name").val("");
    });
    
    $("#input_change_submit").click(function() {
		$.post("/department/changeById", {
			id: $(".active .a-department-name").next().val(),
			introduction: $("#textarea_introduction").val()
		}, function(data, status) {
			if ("success" == data) {
            	alert("保存成功！")
            } else {
                alert("保存失败！");
            }
		});
    });
    
    $("#input_remove").hide();
    
    $("#input_remove_submit").click(function() {
		$.post("/department/removeById", {
			id: $(".active .a-department-name").next().val(),
			departmentName: $(".active .a-department-name").text()
		}, function(data, status) {
			if ("success" == data) {
            	alert("删除成功！");
            } else {
                alert("删除失败！");
            }
			
			window.location.reload();
		});
    });
});