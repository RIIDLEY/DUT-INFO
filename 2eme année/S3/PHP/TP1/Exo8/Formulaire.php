<?php
session_start();







?>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    <h1> Mon Formulaire </h1>
    <form action="personne.php" method="GET">
      <label> pseudo: </label>
      <input type="text" name="pseudo"/>
      <label> mdp: </label>
      <input type="password" name="mdp"/>
      <input type="submit" name="OK"/>

    </form>
  </body>
</html>
