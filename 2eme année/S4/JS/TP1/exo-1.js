$(document).ready(function()
{
     console.log("Le document est prêt");
     $('input').click(function()
     {
       console.log("Le bouton a été cliqué");
       if($('input').val() == 'montrer'){
         $('img').slideDown('img');
         console.log("Affiche l'image");
         $('input').val('cacher');
       }
       else{
       $('img').slideUp();
       console.log("Cache l'image");
       $('input').val('montrer');
     }
   });
});
