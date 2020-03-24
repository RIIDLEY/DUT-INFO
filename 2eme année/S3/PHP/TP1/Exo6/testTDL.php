<?php

require("TODOlist.php");

$td=new TODOlist;
$td->add_to_do('Dormir');
$td->add_to_do('Faire caca');
$td->add_to_do('Faire pipi');
$td->add_to_do('Manger');

echo '<p>';
if ($td->is_empty()) {
  echo 'vide';
} else {
  echo 'pas vide';
}
echo '</p>';
$td->get_html();
$td->remove_to_do(0);
$td->get_html();

$td->add_to_do('');
$td->get_html();
$td->remove_to_do(1);
$td->get_html();
$td->remove_to_do(2);
$td->get_html();
$td->remove_to_do(3);
$td->get_html();

?>
