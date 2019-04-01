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
    <link rel="stylesheet" href="./css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="./css/Navigation-Clean1.css">
    <link rel="stylesheet" href="./css/styles.css">
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
            <div class="row">
                <div class="col-md-12">
                    <h1 class="text-center">Dealer's cards</h1></div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <h1 class="top-letter"><c:out value="${ sessionScope.simulatorFunctions.getDealer().getCards().get(0) }"></c:out> </h1>
                        <p class="text-center"><i class="glyphicon glyphicon-heart" style="font-size:82px;color:#800000;"></i></p>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.simulatorFunctions.dealer.cards.get(0) }"></c:out> </h1></div>
                </div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <!--  <h1 class="top-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out> </h1>
                        <p class="text-center"> <i class="glyphicon glyphicon-heart" style="font-size:82px;"></i></p>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out></h1></div>  -->
                	</div>
                </div>
                <div class="col-md-12" style="margin-top:50px;">
                    <h1 class="text-center">Player's cards</h1></div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <h1 class="top-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out></h1>
                        <p class="text-center"> <i class="glyphicon glyphicon-heart" style="font-size:82px;"></i></p>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(0) }"></c:out> </h1></div>
                </div>
                <div class="col-md-4 col-md-offset-1">
                    <div class="card">
                        <h1 class="top-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(1) }"></c:out> </h1>
                        <p class="text-center"><i class="glyphicon glyphicon-heart" style="font-size:82px;color:#800000;"></i></p>
                        <h1 class="text-right bottom-letter"><c:out value="${ sessionScope.simulatorFunctions.customer.cards.get(1) }"></c:out> </h1></div>
                </div>
            </div>
        </div>
        <div class="col-md-2">
            <h4>Hands: <span class="badge" style="float:right;">42</span></h4>
            <h4>Won: <span class="badge" style="float:right;">42</span></h4>
            <h4>Lost: <span class="badge" style="float:right;">42</span></h4>
            <h4>Win/loss: <span class="badge" style="float:right;">42%</span></h4>
            <button class="btn btn-primary btn-block" type="button" style="margin-top:30px;">Next hand</button>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>