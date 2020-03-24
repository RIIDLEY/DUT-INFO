$(document).ready(function()
{
	console.log("Le document est prêt");
	$('#nom').keyup(function(event)
		{
			console.log("Une touche a été appuyée");
			var nom=$('#nom').val();
			$('#erreur-nom').css('display',"none");
			if (/[^a-zA-Z '-]/.test($('#nom').val())) {
				console.log('je suis la');
				$('#erreur-nom').css('display',"contents");
			}

			$('#login').val(nom.toLowerCase());
		});
	console.log("La mise en place est finie. En attente d'événements...");

});
