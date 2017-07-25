<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Главная</title>
	<meta charset="UTF-8">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/maincss.css"/>
</head>
<body>
<div class="header">выбрать кофе</div>
<hr>
<div class="container">
	<div class="div img">

	</div>
	<div class="div img2">

	</div>
	<div class="div img3">

	</div><br>
	<div class="sugar">
		добавить сахар
	</div>
	<div class="titlemon">
		положить монету
	</div>
	<div class="mon">
		<p>1</p>
		<p>3</p>
		<p>5</p>
		<p>10</p>
	</div>
	<button id="button">купить</button>
	<div class="result"></div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/scripts/jquery-3.0.0.min.js">
</script>
<script type="text/javascript">
	var price_c=0;
	var result=0;
	var cofname;
	var sugar;
	$('.mon>p').click(function () {

		var c = $(this).text();

		$(this).css({'border':'solid 5px black'});
		c =  parseInt(c);

		if(c==1){
			result+=1;
			alert("текущая сумма "+result);
		}else if(c==3){
			result+=3;
			alert("текущая сумма "+result);
		}
		else if(c==5){
			result+=5;
			alert("текущая сумма "+result);
		}
		else if(c==10){
			result+=10;
			alert("текущая сумма "+result);
		}
	})


	$('.img').click(
			function(){
				$('.img').html("<img src=resources/images/ptichka.png>");
				$('.img2').html("");
				$('.img3').html("");
				price_c = 5;
				cofname = "black coffee"
			});
	$('.img2').click(
			function(){
				$('.img').html("");
				$('.img2').html("<img src=resources/images/ptichka.png>");
				$('.img3').html("");
				price_c = 5;
				cofname = "milk coffee"
			});
	$('.img3').click(
			function(){
				$('.img').html("");
				$('.img2').html("");
				$('.img3').html("<img src=resources/images/ptichka.png>");
				price_c = 5;
				cofname = "other coffee"
			});
	$('.sugar').click(
			function(){
				var cc = $('.sugar').html();
				if(cc==='<img src="resources/images/ptichka.png">'){
					$('.sugar').html("");
					sugar = 0;
				}else{
					$('.sugar').html("<img src=resources/images/ptichka.png>");
					sugar = 1;
				}

			});

	$('#button').click(
			function(){
                if(price_c!=0&&result!=0) {
					var ModelForAjax = {"name_coffee":cofname,"pay":result,"sugar":sugar};
					$.ajax({
						url: "rest",
						type: "POST",
						contentType: "application/json",
						dataType: "json",
						data: JSON.stringify(ModelForAjax),
						success: function (data) {
                        $('.result').html(JSON.stringify(data));
						}
					});
				}}
	);

</script>

</body>
</html>