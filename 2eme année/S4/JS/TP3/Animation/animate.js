$(document).ready(function()
{

  var options={
    top: 100,
    left: 250,
    opacity: .5,
    padding: 10,
    "border-radius": 100
  };

  var options1={
    top: 0,
    left: 0,
    opacity: 1,
    padding: 22,
    "border-radius": 0
  };

  fonction=function(){
    console.log("je suis la");
  }

  fonction1=function(){
    $('h1').animate(options1,1000)
  }

    $('h1').mousedown(function (event){
        $('h1').animate(options,1000,fonction1);
      });
      
});
