<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Casino simulator</title>
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="./css/Navigation-Clean1.css">
	<link rel="stylesheet" href="./css/styles.css">
	<link rel="stylesheet" href="./css/Footer-Dark.css">   
</head>

<body style="background:#e7e7e7;">
    <div>
        <nav class="navbar navbar-default navigation-clean">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="#">Casino Simulator</a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li role="presentation"><a href="./MainBJSimulator">Blackjack simulator</a></li>
                        <li role="presentation"><a href="./AIFunctions?action=none">AI </a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="row" style="margin-top:70px;">
        <div class="col-md-7 col-md-offset-1">
            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <caption>Generated strategy based on starting card values. H means hit card and S means stand</caption>
                    <thead>
                        <tr>
                            <th>AI/Dealer </th>
                            <th>A </th>
                            <th>2 </th>
                            <th>3 </th>
                            <th>4 </th>
                            <th>5 </th>
                            <th>6 </th>
                            <th>7 </th>
                            <th>8 </th>
                            <th>9 </th>
                            <th>10 </th>
                        </tr>
                    </thead>
                    <tbody id="table">
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-2">
            <h3>Select the amount of hands to play</h3>
            <form>
                <input id="amount" class="form-control" type="number" placeholder="Amount" min="1000" max="100000" step="1000">
                <button id="playButton" class="btn btn-primary btn-block" type="button" style="margin-top:30px;">Play </button>
                <hr style="height:5px;width:136px;background-color:rgba(169,108,247,0.43);">
            </form>
            <h4>Hands: <span class="badge" style="float:right;">42</span></h4>
            <h4>Won: <span class="badge" style="float:right;">42</span></h4>
            <h4>Lost: <span class="badge" style="float:right;">42</span></h4>
            <h4>Win/loss: <span class="badge" style="float:right;">42%</span></h4></div>
    </div>
    <script>
    	$(document).ready(function(){
    		$("#playButton").click(function(){
    			$.ajax({
    				url: "./AIFunctions?action=autoGame&amountOfHands=" + $("#amount").val(),
    				success: function(data){
    					var jsonString = JSON.parse(data);
    					var stats = jsonString.stats;
    					
    					$.each(stats, function(key, val){
    						$("#table").append('<tr><td style="font-weight: bold;">' + key + '</td>');
    						$.each(stats.key, function(key, val){
    							$("#table").append('<td>' + val + '</td>');
    						});
    					});
    				}
    			});
    		});
    	});
    </script>
    <script src="/js/jquery-1.12.4.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script id="bs-live-reload" data-sseport="56920" data-lastchange="1556913194712" src="/js/livereload.js"></script>
</body>

</html>