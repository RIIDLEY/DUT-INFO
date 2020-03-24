console.log("Ce programme JS vient d'être chargé");
$(document).ready(function()
{
	console.log("Le document est pret");


	console.log("La mise en place est finie. En attente d'événements...");

function  ajouter_joueur(joueur){
	console.log(joueur);
	var ligne0=$('<tr><td class="nom"></td><td class="score"></td></tr>');
	ligne0.find(".nom").text(joueur["nom"]);
	ligne0.find(".score").text(joueur["score"]);
	$("table").append(ligne0);

}

function calculer_total(){
	var score = 0;
	$(".score").each(function(){
				score+=parseInt($(this).text());
	})
	$("#total").text(score);
}

function calculer_mediane(){
	var tab=[];
	$(".score").each(function(){
				tab.push(parseInt($(this).text()));
	})
		tab.sort(function(a,b){return a-b;});
		var y = Math.floor(tab.length/2);
		console.log(tab);
		$('#mediane').text(tab[y]);
}


	$('#ajout-bouton').click(function(event)
	{
		var joueur={
			nom: $("#ajout-nom").val(),
			score: $("#ajout-score").val()
		}
		ajouter_joueur(joueur);
		calculer_total();
		calculer_mediane();
	});

});
