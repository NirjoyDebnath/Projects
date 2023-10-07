<?php 
include 'config.php';
?>

<!doctype html>
	<html >	
	<head>
		<title>Edit Category</title>
	</head>
	<body>
		<?php
		
		if(isset($_GET['id'])){
			$getid =$_GET['id'];
			$sql = "select * from category where cat_id = $getid";
			$query = $conn->query($sql);
			while ($data = mysqli_fetch_assoc($query))
			{
				$cat_id = $data['cat_id'];

				$category_name = $data['category_name'];


				$entry_date = $data['entry_date'];

			}
		}
		if(isset($_POST['submit'])){
			$new_cat_name = $_POST['category_name'];
			$new_cat_date = $_POST['entry_date'];
			$new_cat_id = $_POST['cat_id'];

			$sql = "update category
			set category_name = '$new_cat_name',entry_date ='$new_cat_date ' where cat_id = $new_cat_id ";
			if($conn-> query($sql) == true)
				{echo "sucsessful";
			$category_name = "";
			header("Location: view_catagory.php");
			

		}

		else{
			echo "not sucessful";
		}

	}
	?>

	<form action="edit_catagory.php" method="POST">
		Category:<br>

		<input type="text" name="category_name" value = "<?php echo $category_name ?>"> <br><br>

		Category Entry Date :<br>
		<input type="date" name="entry_date"
		value = "<?php echo $entry_date ?>"> <br><br>
		<input type="TEXT" name="cat_id"
		value = "<?php echo $cat_id ?>"hidden> 

		<input type="submit" value="Save Changes" name="submit">
	</form>
</body>
</html>


