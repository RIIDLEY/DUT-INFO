<?php
require('view_begin.php');
?>>

		<header>
			<h1><a href=""> Nobel Prizes </a></h1>
		</header>

		<main>

			<h1> Add a Nobel Prize </h1>

			<form action = "?controller=set&action=form_add" method="post">
				<p> <label> Name: <input type="text" name="Name"/> </label> </p>
				<p> <label> Year: <input type="text" name="Year"/> </label></p>
				<p> <label> Birth Date: <input type="text" name="Birthdate"/></label> </p>
				<p> <label> Birth Place: <input type="text" name="BirthPlace"/> </label></p>
				<p> <label> County: <input type="text" name="County"/></label> </p>

				<p>
					<label> <input type="radio" name="Category" value="chemistry" /> Chemistry </label>
					<label> <input type="radio" name="Category" value="economics" /> Economics </label>
					<label> <input type="radio" name="Category" value="literature" /> Literature </label>
					<label> <input type="radio" name="Category" value="medicine" /> Medicine </label>
					<label> <input type="radio" name="Category" value="peace" /> Peace </label>
					<label> <input type="radio" name="Category" value="physics" /> Physics </label>

				</p>
				<textarea name="Motivation" cols="70" rows="10"></textarea>
				<p>  <input type="submit" value="Add in database"/> </p>
			</form>
			<?php
			require('view_end.php');
			?>
