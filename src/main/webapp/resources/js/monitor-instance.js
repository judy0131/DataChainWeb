/**
 * 
 */
/**
 * 
 */

function colorlarge() {

	var colorbox_params = {

		reposition : true,
		scalePhotos : true,
		scrolling : false,
		previous : '<i class="icon-arrow-left"></i>',
		next : '<i class="icon-arrow-right"></i>',
		close : '&times;',
		current : '{current} of {total}',
		maxWidth : '100%',
		maxHeight : '100%',
		onOpen : function() {
			document.body.style.overflow = 'hidden';
		},
		onClosed : function() {
			document.body.style.overflow = 'auto';
			$.colorbox.remove();
			window.setTimeout("colorlarge()", 100);
		},
		onComplete : function() {
			$.colorbox.resize();
		}
	};
	var acti;
	jQuery('#instance_monitor li[class*="active"] ').each(function() {
		if (typeof $(this).attr("data-type") != 'undefined') {
			acti = ($(this).attr("data-type")).toLowerCase();
		}

	});
	var clb = "colorbox_" + acti;
	$('#ul_' + acti + ' [data-rel=' + clb + ']').colorbox(colorbox_params);
	if ($("#cboxLoadingGraphic i").length == 0) {
		$("#cboxLoadingGraphic").append("<i class='icon-spinner orange'></i>");
                // let's add a custom loading icon
	}

	/**
	 * $(window).on('resize.colorbox', function() { try { //this function has
	 * been changed in recent versions of colorbox, so it won't work
	 * $.fn.colorbox.load();//to redraw the current frame } catch(e){} });
	 */
}

function delLi(id, user_id) {
	var cookie_id = user_id + ":instances";
	var ids = horizon.cookies.read(cookie_id).split(',');
	for (var i = 0; i < ids.length - 1; i++) {
		if (id == ids[i]) {
			ids.splice(i, 1);
			break;
		}
	}
	horizon.cookies.write(cookie_id, ids.join(','));
	window.location.href = "/ceilometer/instance/";

}

function dateFormate(date) {
	var str = date.getUTCFullYear();
	str += (date.getUTCMonth() < 9 ? "-0" : "-") + (date.getUTCMonth() + 1);
	str += (date.getUTCDate() < 10 ? "-0" : "-") + date.getUTCDate();
	str += (date.getUTCHours() < 10 ? " 0" : " ") + date.getUTCHours();
	str += (date.getUTCMinutes() < 10 ? ":0" : ":") + date.getUTCMinutes();
	str += (date.getUTCSeconds() < 10 ? ":0" : ":") + date.getUTCSeconds();
	return str;
}

function getCtn(parm) {
	var list = []
	if (parm == 'cpu') {
		list.push('instance.cpu.usage');
	} else if (parm == 'memory') {
		list.push('instance.mem.usage');
	} else if (parm == 'disk') {
		list.push('instance.disk.read.bytes');
		list.push('instance.disk.write.bytes');
	} else if (parm == 'network') {
		list.push('instance.net.in.bytes')
		list.push('instance.net.out.bytes')
	}
	return list;
}
var tip_label = [], labels = [], pre_num = 0;
var lineBasic2dConfig = {
	align : 'center',
	title : '虚拟机',
	// subtitle : '?-3??',
	// footnote : '?,
	width : 410,
	height : 300,
	background_color : '#FEFEFE',
	tip : {
		enable : true,
		shadow : true,
		move_duration : 300,
		border : {
			enable : true,
			radius : 5,
			width : 2,
			color : '#3f8695'
		},
		listeners : {
			// tip:?name:value:?text:i:
			parseText : function(tip, name, value, text, i) {
				return name + ": " + parseFloat(value).toFixed(2);
			}
		}
	},
	tipMocker : function(tips, i) {
		return "<div style='font-weight:500'>" + tip_label[Math.floor(i)]
				+ "</div>" + tips.join("<br/>");
	},
	legend : {
		enable : true,
		row : 2,// column
		column : 'max',
		valign : 'top',
		sign : 'bar',
		background_color : null,//
		offsetx : -5,// x?
		border : true
	},
	crosshair : {
		enable : true,
		line_color : '#62bce9'//
	},
	sub_option : {
		label : false,
		point_size : 10
	},
        listeners:{
	        /**
		* d:相当于data[0],即是一个线段的对象
		* v:相当于data[0].value
		* x:计算出来的横坐标
		* y:计算出来的纵坐标
		* j:序号 从0开始
		*/
		parsePoint:function(d,v,x,y,j){
			//利用序号进行过滤春节休息期间
			if(v == -1)
			        return {ignored:true}//ignored为true表示忽略该点
                }
	},
	coordinate : {
		width : 280,
		height : 200,
		axis : {
			color : '#dcdcdc',
			width : 1
		},
		scale : [ {
			position : 'left',
			start_scale : 0,
			end_scale : 100,
			scale_space : 20,
			scale_size : 2,
			scale_color : '#9f9f9f'
		}, {
			position : 'bottom',
			labels : labels
		} ]
	}
}

function createLineBasic2d(elemId, config, data) {
	config.id = elemId;
	config.data = data;
	config.render = elemId;
	var chart = iChart.get(elemId);
	if (typeof chart == "undefined") {
		chart = new iChart.LineBasic2D(config);
	}
	// 开始画图
	chart.draw();
	return chart;
}

function getRandomC() {
	return '#' + (function(h) {
		return new Array(7 - h.length).join("0") + h
	})((Math.random() * 0x1000000 << 0).toString(16))
}

function getName(parm, unit) {
	var name = null;
	if (parm == 'instance.cpu.usage') {
		name = "cpu_usage(" + unit + ")"
	} else if (parm == 'instance.mem.usage') {
		name = "mem_usage (" + unit + ")";
	} else if (parm == 'instance.disk.read.bytes') {
		name = "Read(" + unit + ")";
	} else if (parm == 'instance.disk.write.bytes') {
		name = "Write(" + unit +")";
	} else if (parm == 'instance.net.in.bytes') {
		name = "In   (" + unit + ")";
	} else if (parm == 'instance.net.out.bytes') {
		name = "Out (" + unit + ")";
	}
	return name;
}

function getLabels(label_set, num, m) {
	if (label_set.length <= 1)
		return [];
	if (num <= m)
		m = 1;
	var tmp_labels = [], n = 1;
	tmp_labels.push((label_set[0].split(" "))[1]);
	for (var i = 1; i <= num; i++) {
		if (n == m) {
			tmp_labels.push((label_set[i].split(" "))[1]);
			n = 1;
		} else {
			n++;
			continue;
		}
	}
	if (tmp_labels.length == 1)
		tmp_labels.push((label_set[num].split(" "))[1]);
	return tmp_labels;
}

function getY(ymax, ymin, parm) {
        var yrange = parseFloat((ymax - ymin).toFixed(3));
        if(yrange != 0){
            var end_scl = (ymax + 0.1 * yrange);
            var st_scl = (ymin - 0.1 * yrange) > 0 ? (ymin - 0.1 * yrange) : 0;
        }else{
            end_scl = ymax + 0.1 * ymax;
            st_scl = (ymin - 0.1 * ymax) > 0 ? (ymin - 0.1 * ymax) : 0;
        }
        var y_scl = (parseFloat(((end_scl - st_scl) / 4).toFixed(3))) == 0 ? (end_scl - st_scl) : (parseFloat(((end_scl - st_scl) / 4).toFixed(3)));
	var list = [];
	list.push(end_scl);
	list.push(st_scl);
	list.push(y_scl);
	return list;
}

function get_unit(basic_u, ymax){
	var new_u = basic_u;
	var u_id = 0;
	var is_match = false;
	var ch_unit = 1;
	// find basic unit
	var result = [];
	if(basic_u == "B") basic_u = "bytes";
	for (; u_id < units.length; u_id++) {
		if (basic_u.indexOf(units[u_id]) != -1) {
			is_match = true;
			break;
		}
	}

	if (is_match) {
		// find change unit
		var d_range = ymax;
		var tmp_u = units[u_id];
		for (; u_id < units.length; u_id++) {
			if (d_range < 1000) {
				new_u = basic_u.replace(tmp_u,
						units[u_id]);
				break;
			} else {
				ch_unit = ch_unit * 1024;
				d_range = d_range / ch_unit;
			}
		}
		if (u_id == units.length) {
			new_u = basic_u.replace(tmp_u,
					units[u_id]);
		}
	} else {
		ch_unit = 1;
	}
	result.push(ch_unit);
	result.push(new_u);
	return result;
}

fixed_color = [ '#63d673', '#db170c', '#05447c', '#18c9cb', '#81fd8f',
		'#aa18b1', '#63ace3' ]

var linechart_parm, distance = 300;
var names = new Array();
units = ['B', 'KB', 'MB', 'GB'];
function initChart() {

	jQuery('#instance_monitor li[class*="active"] a').each(function() {
		if (typeof $(this).attr("data-type") != 'undefined') {
			linechart_parm = ($(this).attr("data-type")).toLowerCase();
		}

	});
	ctn = getCtn(linechart_parm);
	strctn = ctn.join(",");
	var ids = [];

	$('#instance_monitor__' + linechart_parm + ' div[class*="cboxElement"] ')
			.each(function() {
				ids.push($(this).data("id"));
				names[$(this).data("id")] = $(this).data("name");
			});
	if (ids.length <= 0)
		return;
	var strIds = ids.join(",");
	distance = linechart_parm == "disk" ? 900 : 300;
	var date = new Date();
	var sdate = new Date(date.getTime() - distance * 1000);
	etm = dateFormate(date);
	stm = dateFormate(sdate);

	jQuery
			.ajax({
				url : '/monitor/getMeter',
				type : "GET",
				data : {
					query : strIds,
					counter_name : strctn,
					stime : stm,
					etime : etm,
					limit : 13
				},
				dataType : "json",
				success : function(resdata) {
					for (var key in resdata) {

						if (key == 'each')
							return;

						var is_right = false, num;
						var data_key_list = Object.keys(resdata[key]["items"]);
						var required_key_list = getCtn(linechart_parm);
						var ymin = 0;
						var ymax = 0;
						var label_set = [];
						var meterName = null;
						var data = [];
						if ((resdata[key].items)[data_key_list[0]].length <= 4) {
							is_right = true;
							ymin = 0;
							ymax = 100;
							data = []
							data.push({
								name : "等待数据中......",
								value : [ 0 ],
								color : fixed_color[0],
								line_width : 2
							});
							num = 3;
							label_set = [ "0", "0", "0", "0" ];
						} else {
							ymin = eval((resdata[key].items)[data_key_list[0]])[0]['counter_volume'];
							ymax = eval((resdata[key].items)[data_key_list[0]])[0]['counter_volume'];
							var basic_u = (resdata[key].units)[data_key_list[0]];
							var new_u = basic_u;
							var u_id = 0;
							var is_match = false;
							var ch_unit = 1;
							// find basic unit
							for(;u_id<units.length;u_id++){
								if(basic_u.indexOf(units[u_id]) != -1){
									is_match = true;
									break;
								}
							}
							if(is_match){
								// find change unit
								var d_range = ymax;
								var tmp_u = units[u_id];
								for(;u_id<units.length;u_id++){
									if(d_range < 1000){
										new_u = basic_u.replace(tmp_u, units[u_id]);
										break;
									}else{
										ch_unit = ch_unit * 1024;
										d_range = d_range / ch_unit;
									}
								}
								if(u_id == units.length){
									new_u = basic_u.replace(tmp_u, units[u_id]);
								}
							}else{
								ch_unit = 1;
							}
							ymax = ymax / ch_unit;
							ymin = ymin / ch_unit;

							for (var it = 0; it < data_key_list.length; it++) {
								if (required_key_list.indexOf(data_key_list[it]) != -1) {
									var tmp_data_set_ori = [];
                                    var tmp_data_set = [];
									var tmp_label_set = [];
									var temp_data = eval((resdata[key].items)[data_key_list[it]]);
									num = temp_data.length-1;
									for (var data_it = num; data_it >= 0; data_it--) {
										if (data_it != "each" && data_it != "eachAll" && data_it != "sor") {
											var value = temp_data[data_it]['counter_volume'];
											if(value == -1) value = 0;
											value = value / ch_unit;
											ymax = value > ymax ? value : ymax;
											ymin = value < ymin ? value : ymin;
											tmp_data_set_ori.push(value);
											tmp_label_set.push(temp_data[data_it]['timestamp']);
										}
									}
									meterName = getName(data_key_list[it], new_u);
									tmp_data_set = tmp_data_set_ori;
									data.push({
										name : meterName,
										value : tmp_data_set,
										color : fixed_color[it],
										line_width : 2
									})
									if (tmp_label_set.length > label_set.length) {
										label_set = tmp_label_set;
									}
									is_right = true;
								} else {
									is_right = false;
									continue;
								}
							}
						}
						if (!is_right)
							return;
						var yAxis = getY(ymax, ymin, linechart_parm);
						var labels = getLabels(label_set, num, 3);
						var tip_label = label_set;
						var hrender = linechart_parm + '_'
								+ resdata[key].resource_id;
						lineBasic2dConfig.title = names[resdata[key].resource_id];
						lineBasic2dConfig.coordinate.scale[1].labels = labels;
						lineBasic2dConfig.coordinate.scale[0].min_scale = yAxis[1];
						lineBasic2dConfig.coordinate.scale[0].start_scale = yAxis[1];
						lineBasic2dConfig.coordinate.scale[0].end_scale = yAxis[0];
						lineBasic2dConfig.coordinate.scale[0].scale_space = yAxis[2];
						lineBasic2dConfig.tipMocker = function(tips, i) {
							return "<div style='font-weight:500'>"
									+ tip_label[Math.floor(i)] + "</div>"
									+ tips.join("<br/>");
						};
						createLineBasic2d(hrender, lineBasic2dConfig, data);
					}
				}
			});

}

function loadChart(chartId, data, configDict) {
	var chart = iChart.get(chartId);
	if (configDict) {
		for (attr in configDict) {
			chart.push(attr, configDict[attr]);
		}
	}
	chart.load(data);
	return chart;
}

function line_chart(linechart_parm) {
	if(linechart_parm == 'undefined'){
		jQuery('#instance_monitor li[class*="active"] a').each(function() {
			if (typeof $(this).attr("data-type") != 'undefined') {
				linechart_parm = ($(this).attr("data-type")).toLowerCase();
			}

		});
	}
	if(linechart_parm == 'undefined') return;
	var ctn = getCtn(linechart_parm);
	var strctn = ctn.join(",");
	var ids = [];
	$('#instance_monitor__' + linechart_parm + ' div[class*="cboxElement"] ')
			.each(function() {
				ids.push($(this).data("id"));
				names[$(this).data("id")] = $(this).data("name");
			});
	if (ids.length <= 0)
		return;
	var strIds = ids.join(",");
	distance = linechart_parm == "disk" ? 900 : 300;
	var date = new Date();
	var sdate = new Date(date.getTime() - distance * 1000);
	var etm = dateFormate(date);
	var stm = dateFormate(sdate);

	jQuery
			.ajax({
				url : '/monitor/getMeter',
				type : "GET",
				data : {
					query : strIds,
					counter_name : strctn,
					stime : stm,
					etime : etm,
					limit : 13
				},
				dataType : "json",
				success : function(resdata) {
					for (key in resdata) {
						if (key == 'each')
							return;
						var hrender = linechart_parm + '_'
								+ resdata[key].resource_id;
						if (typeof iChart.get(hrender) == "undefined") {
							initChart();
							return;
						}
						var is_right = false, num;
						var data_key_list = Object.keys(resdata[key]["items"]);
						var required_key_list = getCtn(linechart_parm);
						var ymin = 0;
						var ymax = 0;
						var label_set = [];
						var meterName = null;
						var data = [];
						if ((resdata[key].items)[data_key_list[0]].length <= 4) {
							is_right = true;
							ymin = 0;
							ymax = 100;
							data = []
							data.push({
								name : "等待数据中......",
								value : [ 0 ],
								color : fixed_color[0],
								line_width : 2
							});
							num = 3;
							label_set = [ "0", "0", "0", "0" ];
						} else {
							ymin = eval((resdata[key].items)[data_key_list[0]])[0]['counter_volume'];
							ymax = eval((resdata[key].items)[data_key_list[0]])[0]['counter_volume'];
							var basic_u = (resdata[key].units)[data_key_list[0]];
							var new_u = basic_u;
							var u_id = 0;
							var is_match = false;
							var ch_unit = 1;
							// find basic unit
							for(;u_id<units.length;u_id++){
								if(basic_u.indexOf(units[u_id]) != -1){
									is_match = true;
									break;
								}
							}
							if(is_match){
								// find change unit
								var d_range = ymax;
								var tmp_u = units[u_id];
								for(;u_id<units.length;u_id++){
									if(d_range < 1000){
										new_u = basic_u.replace(tmp_u, units[u_id]);
										break;
									}else{
										ch_unit = ch_unit * 1024;
										d_range = d_range / ch_unit;
									}
								}
								if(u_id == units.length){
									new_u = basic_u.replace(tmp_u, units[u_id]);
								}
							}else{
								ch_unit = 1;
							}
							ymax = ymax / ch_unit;
							ymin = ymin / ch_unit;
							for (var it = 0; it < data_key_list.length; it++) {
								if (required_key_list.indexOf(data_key_list[it]) != -1) {
									var tmp_data_set_ori = [];
									var tmp_data_set = [];
									var tmp_label_set = [];
									var temp_data = eval((resdata[key].items)[data_key_list[it]]);
									num = temp_data.length-1;
									for (var data_it = num; data_it >= 0; data_it--) {
										if (data_it != "each" && data_it != "eachAll" && data_it != "sor") {
											var value = temp_data[data_it]['counter_volume'];
											if(value == -1) value = 0;
											value = value / ch_unit;
											ymax = value > ymax ? value : ymax;
											ymin = value < ymin ? value : ymin;
											tmp_data_set_ori.push(value);
											tmp_label_set.push(temp_data[data_it]['timestamp']);
										}
									}
									meterName = getName(data_key_list[it], new_u);
									tmp_data_set = tmp_data_set_ori;
									data.push({
										name : meterName,
										value : tmp_data_set,
										color : fixed_color[it],
										line_width : 2
									})
									if (tmp_label_set.length > label_set.length) {
										label_set = tmp_label_set;
									}
									is_right = true;
								} else {
									is_right = false;
									continue;
								}
							}
						}
						if (!is_right)
							return;
						var yAxis = getY(ymax, ymin, linechart_parm);
						var labels = getLabels(label_set, num, 3);
						var tip_label = label_set;
						loadChart(hrender, data, {
							'coordinate.scale' : [ {
								position : 'left',
								start_scale : yAxis[1],
								end_scale : yAxis[0],
								scale_space : yAxis[2],
								scale_size : 2,
								scale_color : '#9f9f9f'
							}, {
								position : 'bottom',
								labels : labels
							} ],
							'tipMocker' : function(tips, i) {
								return "<div style='font-weight:500'>"
										+ tip_label[Math.floor(i)] + "</div>"
										+ tips.join("<br/>");
							}
						});
					}
				}
			});

}
$(document).on("shown", ".nav-tabs li a[data-toggle='tab']", function() {
	//line_chart();
	//colorlarge();
});
jQuery(function() {
	initChart();
});

