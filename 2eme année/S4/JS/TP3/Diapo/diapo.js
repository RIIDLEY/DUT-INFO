console.log("Ce programme JS vient d'être chargé");
$(document).ready(function()
{

var interval;

$("#dia-fleches span").click(function(event){

  var fleche=$(this).attr('id');
  console.log(fleche);
  var position = parseInt($('#dia-images').css('left'));
  console.log(position);
  if (position%600 == 0) {
    var x = parseInt($('#dia-images').css('left'));
    if (fleche == "dia-droite" && position > -1800) {
      clearInterval(interval)
      x=position-600;
      $('#dia-images').animate({left: x });
    }
    if (fleche == "dia-gauche" && position < 0) {
      clearInterval(interval)
      x=position+600;
      $('#dia-images').animate({left: x });
  }
} 
})

$("#dia-fleches").ready(function(event){
    interval = setInterval(function(){
    var x = parseInt($('#dia-images').css('left'));
    console.log(x);
    $('#dia-images').animate({left: x-600 });
    if (x == -1200) {
      $('#dia-images').animate({left: 0 });
    }
  },2000);

})

/*
  $("#dia-droite").click(function(event){
    console.log($('#dia-images').css('left'));
    var x = parseInt($('#dia-images').css('left'));
    if (x>(-1800)) {
      x = x + (-600);
      $("#dia-images").css("left",x);
    }

})

$("#dia-gauche").click(function(event){
  console.log($('#dia-images').css('left'));
  var x = parseInt($('#dia-images').css('left'));
  if (x<0) {
    x = x + 600;
    $("#dia-images").css("left",x);
  }

})*/
  });
