<?php 

include 'config.php';
?>
<!doctype html>
	<html >	
	<head>
		<title>view category</title>
	</head>
	<body>

		<?php
		$getid="";
		$getname="";
		
		if(isset( $_GET['id'])&& isset($_GET['name']))
			{ $getid = $_GET['id'];
			$getname = $_GET['name'];}

		if(isset( $_POST['submit']  )){
			$getid =$_POST['id'] ;
			ECHO "$getid";

			$sql= "delete from category where cat_id = $getid";
			$sql1 ="delete from product where product_category like '$getname'";
			echo $sql1;
			$query = $conn->query($sql);
			$query = $conn->query($sql1);
			if($conn-> query($sql) == true)
			{
				echo "sucsessful";
				header("Location: view_catagory.php");
			}
			else{ echo 'not';}

		}
		if(isset( $_POST['submit1']  )){
			$getid =$_POST['id'] ;
			ECHO "$getid";
			header("Location: view_catagory.php");}
			
			?>
			<form action="#" method="POST">
				<h3> are you sure? </h3>

				<input type="submit" value="Yes" name="submit">
				<input type="submit" value="Cancel" name="submit1">
				<input type="TEXT" name="id"
				value = "<?php echo $getid ?>"hidden> 


			</form>
		</body>
		</html>
