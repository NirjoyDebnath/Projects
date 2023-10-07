<?php 

include 'config.php';
?>
<!doctype html>
	<html >	
	<head>
		<title>view product</title>
	</head>
	<body>

		<?php
		$getid="";
		
		if(isset( $_GET['id']))
			{ $getid = $_GET['id'];}

		if(isset( $_POST['submit']  )){
			$getid =$_POST['id'] ;
			ECHO "$getid";

			$sql= "delete from product where product_id = $getid";
			$query = $conn->query($sql);
			if($conn-> query($sql) == true)
				{echo "sucsessful";
			header("Location: view_product.php");}
			else{ echo 'not';}

		}
		if(isset( $_POST['submit1']  )){
			$getid =$_POST['id'] ;
			ECHO "$getid";
			header("Location: view_product.php");}
			
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
