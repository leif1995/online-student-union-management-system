$(function() {
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
    
    $.post("/feedback/findForDiagramByType", function(data, status) {
    	// diagram start
    	var diagramData = new Array();
    	
    	for (var counter = 0; counter < data.length; counter++) {
    		diagramData[counter] = {
    			"type": data[counter][0],
    			"feedbackNumber": data[counter][1],
    			"color": "#" + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16) + parseInt(Math.random()*257).toString(16)
    		}
    	}
    	
        AmCharts.makeChart("div_area_one", {
            type: "serial", 
            dataProvider: diagramData,
            categoryField: "type",
            depth3D: 20,
            angle: 30,

            categoryAxis: {
                labelRotation: 90,
                gridPosition: "start"
            },

            valueAxes: [{
                title: "各类型问题反馈量"
            }],

            graphs: [{
                valueField: "feedbackNumber",
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
    
    $("input[value = '删除']").on("click", function() {
        var id = $(this).next().val();
        
        $("#input_remove_submit").click(function() {
            if (id > 0) {
            	$.post("/feedback/removeById", {
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
});