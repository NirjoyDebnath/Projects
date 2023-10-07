
<?php 

include 'config.php';
?>

<!doctype html>
	<html >	
		<head>
				<title>add category</title>
		</head>
		<body>
				<?php
			if(isset($_POST['submit'])){
				$category_name = $_POST['category_name'];
				$entry_date = $_POST['entry_date'];
				$sql= "insert into category (category_name,entry_date) 
				values ('$category_name ','$entry_date')" ;
				$result = mysqli_query($conn, $sql);

				if($result){
					echo 'saved';
					header("Location: view_catagory.php");
				}else{
					echo 'not saved';
				}

				
			}
				?>
			
			<form action="add_category.php" method="POST">
				Category:<br>
				<input type="text" name="category_name"><br><br>
				Category Entry Date :<br>
				<input type="date" name="entry_date"><br><br>
				<input type="submit" value="Save" name="submit">
			</form>
			<?php
			if(isset($_POST['submit'])){
				echo $_POST['category_name'];
				echo $_POST['entry_date'];
			}
				?>
		</body>


	</html>