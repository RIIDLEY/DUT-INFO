console.log("Ce programme JS vient d'être chargé");
var joueur = 1
$(document).ready(function()
{
	console.log("Le document est prêt");
  $("td").mousedown(function(event)
  {
    var a= $('td').index(this);
    console.log("L'utilisateur a cliqué sur l'onglet:",a);

		if (!$(this).hasClass("croix") || $(this).hasClass("rond")) {
			if (joueur==1) {
	      $(this).addClass("croix");
	      joueur = 2
	    }
	    else {
	      $(this).addClass("rond");
	      joueur = 1
	    }
		}


  });

});
