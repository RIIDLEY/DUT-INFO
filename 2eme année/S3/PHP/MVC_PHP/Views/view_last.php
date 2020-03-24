<?php
require('view_begin.php');
?>
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Category</th>
      <th>Year</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach($tab as $ligne): ?>
      <tr>
        <td><a href="?controller=list&action=informations&id=<?=$ligne['id']?>"><?=$ligne['name']?></a></td>
        <td><?=$ligne['category']?></td>
        <td><?=$ligne['year']?></td>

      </tr>
    <?php endforeach; ?>
  </tbody>
</table>

<?php
require('view_end.php');
?>
