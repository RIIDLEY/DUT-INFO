<?php

require "begin.html";
require "Model.php";

$m =Model::getModel();
$resultat=$m->get_last();

echo '<table>';
foreach ($resultat as $key => $value) {
  foreach ($value as $valu) {
    echo '<td>' . $valu . '</td>';
  }
}
echo "</table>";
 ?>
