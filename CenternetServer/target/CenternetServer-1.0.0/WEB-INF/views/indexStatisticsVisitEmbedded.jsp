<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	var chart;

	var chartData = [];

	AmCharts.ready(function() {
		// generate some random data first   
		generateChartData();

		// SERIAL CHART
		chart = new AmCharts.AmSerialChart();
		chart.pathToImages = "i/amcharts";
		chart.marginLeft = 0;
		chart.marginRight = 0;
		chart.marginTop = 0;
		chart.dataProvider = chartData;
		chart.categoryField = "date";

		// AXES
		// category
		var categoryAxis = chart.categoryAxis;
		categoryAxis.parseDates = true; // as our data is date-based, we set parseDates to true
		categoryAxis.minPeriod = "DD"; // our data is daily, so we set minPeriod to DD
		// value axis
		var valueAxis = new AmCharts.ValueAxis();
		valueAxis.inside = true;
		valueAxis.tickLength = 0;
		valueAxis.axisAlpha = 0;
		valueAxis.minimum = 100;
		valueAxis.maximum = 140;
		chart.addValueAxis(valueAxis);

		// GRAPH
		var graph = new AmCharts.AmGraph();
		graph.dashLength = 3;
		graph.lineColor = "#7717D7";
		graph.valueField = "visits";
		graph.dashLength = 3;
		graph.bullet = "round";
		chart.addGraph(graph);

		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.cursorAlpha = 0;
		chart.addChartCursor(chartCursor);

		// GUIDES are used to create horizontal range fills
		var guide = new AmCharts.Guide();
		guide.value = 0;
		guide.toValue = 105;
		guide.fillColor = "#CC0000";
		guide.fillAlpha = 0.2;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 105;
		guide.toValue = 110;
		guide.fillColor = "#CC0000";
		guide.fillAlpha = 0.15;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 110;
		guide.toValue = 115;
		guide.fillColor = "#CC0000";
		guide.fillAlpha = 0.1;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 115;
		guide.toValue = 120;
		guide.fillColor = "#CC0000";
		guide.fillAlpha = 0.05;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 120;
		guide.toValue = 125;
		guide.fillColor = "#0000cc";
		guide.fillAlpha = 0.05;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 125;
		guide.toValue = 130;
		guide.fillColor = "#0000cc";
		guide.fillAlpha = 0.1;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 130;
		guide.toValue = 135;
		guide.fillColor = "#0000cc";
		guide.fillAlpha = 0.15;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		var guide = new AmCharts.Guide();
		guide.value = 135;
		guide.toValue = 140;
		guide.fillColor = "#0000cc";
		guide.fillAlpha = 0.2;
		guide.lineAlpha = 0;
		valueAxis.addGuide(guide);

		// WRITE
		chart.write("chartdiv");
	});

	// generate some random data
	function generateChartData() {
		var firstDate = new Date();
		firstDate.setDate(firstDate.getDate() - 10);

		for ( var i = 0; i < 10; i++) {
			var newDate = new Date(firstDate);
			newDate.setDate(newDate.getDate() + i);

			var visits = Math.round(Math.random() * 40) + 100;

			chartData.push({
				date : newDate,
				visits : visits
			});
		}
	}
</script>
<div class="columnBlock">
	<div class="blockTitle">统计记录</div>
	<div id="staticsVisit">
		<div id="chartdiv"></div>
	</div>
</div>
