<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="org.keroro.member.dto.MemberDTO"%>
<%@ page import="org.keroro.member.dto.ScoreDTO"%>
<%@ page import="org.keroro.member.dao.MemberDAO"%>

<%@ include file="../includes/userheader.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-4 text-gray-800">${mid}님, 반갑습니다!</h1>
      
<form class="form-horizontal" action="/user/challenge/question" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<input type="hidden" name="grade" value="1">
      <button type="submit" class="btn btn-success">초급 CHALLENGE</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/user/challenge/question" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<input type="hidden" name="grade" value="2">	
      <button type="submit" class="btn btn-warning">중급 CHALLENGE</button>
    </div>
  </div>
</form>

<form class="form-horizontal" action="/user/challenge/question" method="get">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    	<input type="hidden" name="grade" value="3">
      <button type="submit" class="btn btn-dark">고급 CHALLENGE</button>
    </div>
  </div>
</form>

<h2 class="h3 mb-4 text-gray-800">상위 : ${(dto.perRank * 100)}%</h1>
<h2 class="h3 mb-4 text-gray-800">총 사용자 수 : ${(total)}명</h1>
<h2 class="h3 mb-4 text-gray-800">종합 평균 점수 : ${(totalAvg)}점</h1>

<!-- CHART -->            
<!-- CHART -->            
<!-- CHART -->            
<%
MemberDAO memberDAO = new MemberDAO();
String mid = (String)session.getAttribute("mid");
Gson gsonObj1 = new Gson();
Map<Object,Object> map1 = null;
List<Map<Object,Object>> list1 = new ArrayList<Map<Object,Object>>();

// resultMap.put("avg", result);
// resultMap.put("date", dateArr);

Map<String, Double[]> resultMap = memberDAO.getChartData(mid);
Double[] date = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
Double[] avg = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	if(null != resultMap)
	{
	date = resultMap.get("date");
	avg = resultMap.get("avg");	
	}
	
for(int i = 0; i < 7; ++i) {
	map1 = new HashMap<Object,Object>(); 
	map1.put("label", date[i]); 
	map1.put("y", avg[i]); 
	list1.add(map1);
}


String dataPoints1 = gsonObj1.toJson(list1);

//===================================

Gson gsonObj2 = new Gson();
Map<Object,Object> map2 = null;
List<Map<Object,Object>> list2 = new ArrayList<Map<Object,Object>>();



List<ScoreDTO> scoreList = memberDAO.getScoreList(mid);

if(0 == scoreList.size()){
	for(int i = 0 ; i < 5; ++i){
	map2 = new HashMap<Object,Object>(); 
	map2.put("label", "Difficulty " + (i+1));
	map2.put("y", 0); 
	}
}
else{
int count = 0;
for(int i = 0 ; i < 5; ++i){
	// 난이도 1을 보고 싶다.
	// 1이 없다.
	// 1은 0을 넣는다.
	// 2를 보고 싶다.
	// 2는 있다.
	// 2는 원래 값.
	// 난이도 3 => 4
	
	ScoreDTO dto = scoreList.get(count);
	if(null == dto){
		map2 = new HashMap<Object,Object>(); 
		map2.put("label", "Difficulty " + (i+1));
		map2.put("y", 0);
		continue;
	}
	
	int difficulty = dto.getDifficulty();
	// 난이도 확인
	if(i + 1 == difficulty){
		// 1단계가 맞음
		map2 = new HashMap<Object,Object>(); 
		map2.put("label", "Difficulty " + difficulty);
		map2.put("y", dto.getAvg()); 
		list2.add(map2);
		++count;
	} else{
		// 1단계가 아님
		map2 = new HashMap<Object,Object>();
		map2.put("label", "Difficulty " + (i + 1));
		map2.put("y", 0);
		list2.add(map2);
	}
}
}
String dataPoints2 = gsonObj2.toJson(list2);

%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
<br></br>
<div id="chartContainer1" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<script>
(function() { 
	
	console.log("load1...");
	
	var chart1 = new CanvasJS.Chart("chartContainer1", {
		theme: "light2",
		title: {
			text: "주간 일별 점수"
		},
		axisX: {
			title: "날짜"
		},
		axisY: {
			title: "점수",
			includeZero: true
		},
		data: [{
			type: "line",
			yValueFormatString: "#,##0mn tonnes",
			dataPoints : <%out.print(dataPoints1);%>
		}]
	});

	chart1.render();

	
	
})();

(function() { 
	
	console.log("load2...");
	
	var chart2 = new CanvasJS.Chart("chartContainer2", {
		theme: "light2",
		title: {
			text: "난이도별 평균 점수"
		},
		subtitles: [{
			text: ""
		}],
		axisY: {
			title: "",
			labelFormatter: addSymbols
		},
		data: [{
			type: "bar",
			indexLabel: "{y}",
			indexLabelFontColor: "#444",
			indexLabelPlacement: "inside",
			dataPoints: <%out.print(dataPoints2);%>
		}]
	});
	
	chart2.render();
	 
	function addSymbols(e) {
		var suffixes = ["", "K", "M", "B"];
	 
		var order = Math.max(Math.floor(Math.log(e.value) / Math.log(1000)), 0);
		if(order > suffixes.length - 1)
		order = suffixes.length - 1;
	 
		var suffix = suffixes[order];
		return CanvasJS.formatNumber(e.value / Math.pow(1000, order)) + suffix;
	}
	
})();


</script>

</body>
</html>                        
          
<!-- CHART -->            
<!-- CHART -->            
<!-- CHART -->            
          
          
<!-- Page Footer -->   
<%@ include file="../includes/userfooter.jsp" %>