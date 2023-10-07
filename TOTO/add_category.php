
<?php 

include 'config.php';
?>

<!doctype html>
	<html >	
	<head>
		<title>add category</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	</head>
	<body>
		<?php
		if(isset($_POST['submit'])) {
			$category_name = $_POST['category_name'];
			$entry_date = $_POST['entry_date'];
			$p_img_name =$_FILES['p_img']['name'];
			$p_img_size=$_FILES['p_img']['size'];
			$p_tmp_name=$_FILES['p_img']['tmp_name'];
			$p_ext= pathinfo($p_img_name,PATHINFO_EXTENSION);
			if($p_ext == 'jpg' or $p_ext == 'png' or $p_ext == 'jpeg') {
				$sql= "insert into category (category_name,entry_date,p_img)" . 
				" values ('$category_name ','$entry_date','$p_img_name')" ;
				$result = mysqli_query($conn, $sql);
				if($result){ 
					move_uploaded_file($p_tmp_name,'upload/'.$p_img_name);
					echo 'saved';
					header("Location: view_catagory.php");

				} else {
					echo 'not saved';
				}
			} else {
				$msg ="your file must be jpg or png";
				echo $msg;
			}
		}
		if(isset($_POST['submit'])){
			echo $_POST['category_name'];
			echo $_POST['entry_date'];
		}
		?>
		<form action="#" method="post" enctype = "multipart/form-data">
			Category:<br>
			<input type="text" name="category_name"><br><br>
			Category Entry Date :<br>
			<input type="date" name="entry_date"><br><br>
			Upload Image:<br>
			<input type="file" name="p_img"><br><br>

			<input type="submit" value="Save" name="submit">
		</form>

		
</body>


</html>