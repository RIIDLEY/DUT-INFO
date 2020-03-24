<?php
require('view_begin.php');
?>


			<h1> Add a Nobel Prize </h1>

			<form action = "?controller=set&action=add" method="post">
				<p> <label> Name: <input type="text" name="name"/> </label> </p>
				<p> <label> Year: <input type="text" name="year"/> </label></p>
				<p> <label> Birth Date: <input type="text" name="birthdate"/></label> </p>
				<p> <label> Birth Place: <input type="text" name="birthPlace"/> </label></p>
				<p> <label> County: <input type="text" name="county"/></label> </p>

				<?php foreach ($category as $key => $value):  ?>
				<input type="radio" name="category" value="<?=$value?>"><?=$value?></br>
			<?php endforeach ?>
				<textarea name="motivation" cols="70" rows="10"></textarea>
				<p>  <input type="submit" value="Add in database"/> </p>
			</form>

		<?php
			require('view_end.php');
			?>
