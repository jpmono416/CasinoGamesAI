var handsPlayed = $('#handsPlayed').text();
var handsWon 	= $('#handsWon').text();
var handsLost 	= $('#handsLost').text();
var WLRatio 	= $('#WLRatio').text();
var winner;

$(document).ready(function(){
	$("#nextHandButton").click(function(){
		reloadPage();
	});
	
});

function finishHand()
{
	checkWinner();
	updateScores();
	updScoresSession();
}

function checkWinner()
{
	const playerCaret = $('#customerTotalAmount');
	const dealerCaret = $('#dealerTotalAmount');
	const customerAmount = playerCaret.text();
	const dealerAmount = dealerCaret.text();
	
	if(customerAmount <= 21 && customerAmount > dealerAmount || customerAmount <= 21 && dealerAmount > 21)
	{
		++handsWon;
	} 
	else 
	{
		++handsLost;
	}
	
	++handsPlayed;
	
	WLRatio = (handsWon / handsPlayed * 100).toFixed(1);
}


function updateScores()
{
	$('#handsPlayed').text(handsPlayed);
	$('#handsWon').text(handsWon);
	$('#handsLost').text(handsLost);
	$('#WLRatio').text(WLRatio + '%');
}

/*
 * I started to do all of this process client-side but the session where I 
 * store the values in Java is server-side so I had to send a request anyway
 * With a bit more time I would have done the operations in the server and 
 * only send the winner as a parameter along with the request. 
 */
function updScoresSession()
{
	const path = "./SimulatorFunctions?action=updateStats&played=" + handsPlayed
		+ "&won=" + handsWon + "&lost=" + handsLost + "&wl=" + WLRatio;  
	$.ajax({
		url: path, 
		success: function(){
			
	}});
}

function reloadPage()
{
	window.location.reload(true); 
}
