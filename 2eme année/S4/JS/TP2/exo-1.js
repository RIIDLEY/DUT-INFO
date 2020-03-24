console.log("Ce programme JS vient d'être chargé");
$(document).ready(function()
{
	console.log("Le document est prêt");

	$('#nom').keyup(function(event)
		{
			console.log("Une touche a été appuyée");
			var texte=$("#nom").val();
			if(/[^a-zA-Z '-]/.test(texte))
			{
				$('#erreur-nom').show();
			}
			else
			{
				$('#erreur-nom').hide();
			}
			texte=texte.toLowerCase();
			$('#login').val(texte.replace(/ /g,"-"));
		});

		$('#mdp').keyup(function(event)
			{
				var mdp=$("#mdp").val();
				var conf=$("#conf").val();
				$('#erreur-mdp').toggle(mdp.length<6);
				$('#erreur-conf').toggle(mdp !== conf);
			});

			$('#conf').keyup(function(event)
				{
					var mdp=$("#mdp").val();
					var conf=$("#conf").val();
					$('#erreur-conf').toggle(mdp !== conf);
				});

				$('#email').keyup(function(event)
					{
						var email=$("#email").val();
						$('#erreur-email').toggle(!(/^([\w-\.]+)@((?:[\w]+\.)+)([a-zA-Z]{2,4})/i.test(email)));
					});

					$('form').submit(function(event)
							{
								if($('.erreur:visible').length!==0)
								{
									event.preventDefault();
									alert('Merci de corriger les erreurs.');
								}
							});
							
		console.log("La mise en place est finie. En attente d'événements...");


	});
