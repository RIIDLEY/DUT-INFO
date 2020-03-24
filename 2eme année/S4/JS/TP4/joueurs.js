console.log("Ce programme JS vient d'être chargé");
$(document).ready(function()
{
	console.log("Le document est pret");

	$('#ajout-bouton').click(function()
		{
			if ( $('#ajout-nom').val() !== "" && $('#ajout-score').val().match(/[0-9]/)) {
				var joueur={ nom:   $('#ajout-nom'  ).val(),
							 score: $('#ajout-score').val()
							 };
				ajouter_joueur(joueur);
				$('#ajout-nom'	).val('');
				$('#ajout-score').val('');

				$('#total'  ).text(calculer_total());
				$('#mediane').text(calculer_mediane());
				trier();
			}else {
				alert("Il y a un probleme");
			}

		});

	console.log("La mise en place est finie. En attente d'événements...");
});

function ajouter_joueur(joueur)
{
	var ligne=$('<tr><td><img src="effacer.png"/></td><td class="nom"></td><td class="score"></td></tr>');
	ligne.find(".nom"  ).text(joueur.nom  );
	ligne.find(".score").text(joueur.score);
	$('#joueurs').append(ligne);
}

function calculer_total()
{
	var total=0;
	// Pour chaque ligne du tableau .each() appelle la fonction.
	$('#joueurs tr').each(function()
		{
			// $(this) est la ligne (tr) ...
			// on veut le texte dans la case avec le score
			var score=parseInt($(this).find('.score').text());
			// La variable "total" est définie dans la fonction calculer_total...
			// mais on peut y accéder ici (fermeture)
			total+=score;
		});
	return total;
}

function calculer_mediane()
{
	var scores=[];
	$('#joueurs tr').each(function()
		{
			var s=parseInt($(this).find('.score').text());
			scores.push(s);
		});
	scores.sort(function(a,b){return a-b;});
	return scores[Math.floor(scores.length/2)];
}

function trier()
{
	var joueurs=[];
	$('#joueurs tr').each(function()
		{
			var s=parseInt($(this).find('.score').text());
			var j=
				{
					ligne:$(this),
					score:s
				};
			joueurs.push(j);
		});
	joueurs.sort(function(a,b){return b.score-a.score;});
	for(var i=0;i<joueurs.length;i++)
	{
		var ligne=joueurs[i].ligne;
		$('#joueurs').append(ligne);
	}
}
