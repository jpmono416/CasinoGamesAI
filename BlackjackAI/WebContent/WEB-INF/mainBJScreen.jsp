<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="./js/jquery.min.js"></script>
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
                        <li class="active" role="presentation"><a href="#">Blackjack simulator</a></li>
                        <li role="presentation"><a href="#">Statistics </a></li>
                        <li role="presentation"><a href="#">Report </a></li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">Choose game<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation"><a href="#">Blackjack </a></li>
                                <li role="presentation"><a href="#">Roulette </a></li>
                                <li role="presentation"><a href="#">Poker </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="row" style="margin-top:70px;">
        <div class="col-md-7 col-md-offset-1">
            <div class="row" id="dealersRow">
                <div class="col-md-12">
                    <h1 class="text-center">Dealer's cards
                    	<span id="dealerTotalAmount" class="badge">
                    		<c:out value="${ sessionScope.functionsObject.getDealer().getTotalAmount() }"></c:out>
                    	</span>
                    </h1></div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <h1 class="top-letter"><c:out value="${ sessionScope.functionsObject.getDealer().getCards().get(0).getValue() }"></c:out> </h1>
                        <c:choose>
                        	<c:when test="${ sessionScope.functionsObject.getDealer().getCards().get(0).getSuit() == 'SPADES'}">
                        		<div class="centerImg">
                        			<img src="./img/SpadesImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getDealer().getCards().get(0).getSuit() == 'HEARTS'}">
                        		<div class="centerImg">
                        			<img src="./img/HeartsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getDealer().getCards().get(0).getSuit() == 'CLUBS'}">
                        		<div class="centerImg">
                        			<img src="./img/ClubsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getDealer().getCards().get(0).getSuit() == 'DIAMONDS'}">
                        		<div class="centerImg">
                        			<img src="./img/DiamondsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        </c:choose>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.functionsObject.dealer.cards.get(0).getValue() }"></c:out> </h1></div>
                </div>
                <div class="col-md-4 col-md-offset-1">
                    <!--<div class="card">
                          <h1 class="top-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out> </h1>
                        <p class="text-center"> <i class="glyphicon glyphicon-heart" style="font-size:82px;"></i></p>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out></h1></div>  
                	</div> -->
                </div>
            </div>
            <div class="row" id="playersRow">
                <div class="col-md-12" style="margin-top:50px;">
                    <h1 class="text-center">Player's cards
                    	<span id="customerTotalAmount" class="badge">
                    		<c:out value="${ sessionScope.functionsObject.getCustomer().getTotalAmount() }"></c:out>
                    	</span>
                    </h1></div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <h1 class="top-letter"><c:out value="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getValue() }"></c:out></h1>
							<c:choose>
	                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'SPADES'}">
	                        		<div class="centerImg">
	                        			<img src="./img/SpadesImg.png" class="centerImage">
	                        		</div>
	                        	</c:when>
	                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'HEARTS'}">
	                        		<div class="centerImg">
	                        			<img src="./img/HeartsImg.png" class="centerImage">
	                        		</div>
	                        	</c:when>
	                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'CLUBS'}">
	                        		<div class="centerImg">
	                        			<img src="./img/ClubsImg.png" class="centerImage">
	                        		</div>
	                        	</c:when>
	                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'DIAMONDS'}">
	                        		<div class="centerImg">
	                        			<img src="./img/DiamondsImg.png" class="centerImage">
	                        		</div>
	                        	</c:when>
	                        </c:choose>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getValue() }"></c:out> </h1></div>
                </div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
	                    <h1 class="top-letter"><c:out value="${ sessionScope.functionsObject.getCustomer().getCards().get(1).getValue() }"></c:out> </h1>
	                    <c:choose>
                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'SPADES'}">
                        		<div class="centerImg">
                        			<img src="./img/SpadesImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'HEARTS'}">
                        		<div class="centerImg">
                        			<img src="./img/HeartsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'CLUBS'}">
                        		<div class="centerImg">
                        			<img src="./img/ClubsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        	<c:when test="${ sessionScope.functionsObject.getCustomer().getCards().get(0).getSuit() == 'DIAMONDS'}">
                        		<div class="centerImg">
                        			<img src="./img/DiamondsImg.png" class="centerImage">
                        		</div>
                        	</c:when>
                        </c:choose>
	                    <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.functionsObject.getCustomer().getCards().get(1).getValue() }"></c:out> </h1></div>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <h4>Hands: <span class="badge" style="float:right;" id="handsPlayed"><c:out value="${ sessionScope.handsPlayed }"></c:out></span></h4>
            <h4>Won: <span class="badge" style="float:right;" id="handsWon"><c:out value="${ sessionScope.handsWon }"></c:out></span></h4>
            <h4>Lost: <span class="badge" style="float:right;" id="handsLost"><c:out value="${ sessionScope.handsLost }"></c:out></span></h4>
            <h4>Win ratio: <span class="badge" style="float:right;" id="WLRatio"><c:out value="${ sessionScope.WLRatio }"></c:out>%</span></h4>
            <div class="row" style="margin-bottom:0;">
            	<div class="col-md-6">
            		<button class="btn btn-primary btn-block" type="button" style="margin-top:30px;" id="newCardButton">Draw</button>
            	</div>
            	<div class="col-md-6">
					<button class="btn btn-primary btn-block" type="button" style="margin-top:30px;" id="stayButton">Stay</button>            	
            	</div>
            </div>
			<button class="btn btn-primary btn-block" type="button" style="margin-top:30px;" id="nextHandButton">Next hand</button>
			
            
        </div>
        
    </div>
    
    
    
    <script>

	$(document).ready(function(){
	 	$("#newCardButton").click(function(){
	 		$.ajax({
	 			url: "./SimulatorFunctions?action=drawCard", 
				success: function(data){

					var customerJson = JSON.parse(data);
					const cNumericValue = customerJson.cards[customerJson.cards.length - 1].value.cardValue;
					var suitImageSource = "";
					switch(customerJson.cards[customerJson.cards.length - 1].suit)
					{
						case "DIAMONDS" :
							suitImageSource = "./img/DiamondsImg.png";
							break;
							
						case "SPADES" :
							suitImageSource = "./img/SpadesImg.png";
							break;
							
						case "HEARTS" : 
							suitImageSource = "./img/HeartsImg.png";
							break;
							
						case "CLUBS" : 
							suitImageSource = "./img/ClubsImg.png";
							break;
					}
					$('#playersRow').append('<div class="col-md-4 col-md-offset-1">'+
	                    '<div class="card">'+
	                    '<h1 class="top-letter">' + cNumericValue + '</h1>'+
	                    '<div class="centerImg">' +
                        	'<img src="' + suitImageSource + '" class="centerImage">' + 
                        '</div>'+
	                	'<h1 class="text-right bottom-letter">' + cNumericValue + '</h1></div>'+
	            	'</div>')
					
	            	$('#customerTotalAmount').text(customerJson.totalAmount);
					if(customerJson.busted == true)
					{
						$('#newCardButton').prop('disabled', true);
					}
			}});
	 	});
	});
	
	
	$(document).ready(function(){
		$("#stayButton").click(function(){
			$.ajax({
				url: "./SimulatorFunctions?action=stay",
				success: function(data){
					var dealerJson = JSON.parse(data);
					
					var suitImageSource = "";
					for(var counter = 1; counter < dealerJson.cards.length; ++counter)
					{
						switch(dealerJson.cards[counter].suit)
						{
							case "DIAMONDS" :
								suitImageSource = "./img/DiamondsImg.png";
								break;
								
							case "SPADES" :
								suitImageSource = "./img/SpadesImg.png";
								break;
								
							case "HEARTS" : 
								suitImageSource = "./img/HeartsImg.png";
								break;
								
							case "CLUBS" : 
								suitImageSource = "./img/ClubsImg.png";
								break;
						}
						const dNumericValue = dealerJson.cards[counter].value.cardValue;
						$('#dealersRow').append('<div class="col-md-4 col-md-offset-1">'+
		                    	'<div class="card">'+
			                    '<h1 class="top-letter">' + dNumericValue + '</h1>'+
			                    '<div class="centerImg">' +
	                        		'<img src="' + suitImageSource + '" class="centerImage">' + 
	                        	'</div>'+
			                	'<h1 class="text-right bottom-letter">' + dNumericValue + '</h1></div>'+
			            	'</div>')
					}
					
	            	$('#dealerTotalAmount').text(dealerJson.totalAmount);
					finishHand();
				}
			});
		});
	});
	</script>
	<script src="./bootstrap/js/bootstrap.min.js"></script>
    <script src="./js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="./js/sim-stats-functions.js"></script>
</body>

</html>