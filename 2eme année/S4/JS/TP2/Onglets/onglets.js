console.log("Ce programme JS vient d'être chargé");
$(document).ready(function()
{
	console.log("Le document est prêt");
  $("#onglets-menu li").mousedown(function(event)
  {
    $(".menu-actif").removeClass('menu-actif');
    $(this).addClass('menu-actif');

    $(".contenu-actif").removeClass('contenu-actif');
    var a= $('#onglets-menu>li').index(this);
    console.log("L'utilisateur a cliqué sur l'onglet:",a);
    $("#onglets-contenu>div").eq(a).addClass('contenu-actif');
  });

});
