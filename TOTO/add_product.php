
<?php 

include 'config.php';
?>

<!doctype html>
	<html >	
		<head>
				<title>add product</title>
		</head>
		<body>
				
			<?php
			
				$sql = "SELECT * FROM category";
				$result = mysqli_query($conn, $sql);
			
			?>
			<?php
			
			
			if(isset($_POST['submit'])){
				
				$product_name = $_POST['product_name'];
				$product_category = $_POST['product_category'];
				$product_price = $_POST['product_price'];
				$product_quantity = $_POST['product_quantity'];
				$p_img_name =$_FILES['p_img']['name'];
				$p_img_size=$_FILES['p_img']['size'];
				$p_tmp_name=$_FILES['p_img']['tmp_name'];
				$p_ext= pathinfo($p_img_name,PATHINFO_EXTENSION);
				if($p_ext == 'jpg' or $p_ext == 'png' or $p_ext == 'jpeg')
				{
					$sql= "insert into product (product_name,product_category,product_price,p_quantity,p_img) 
				values ('$product_name ','$product_category ','$product_price ','$product_quantity','$p_img_name')" ;
				$result = mysqli_query($conn, $sql);

				if($result){ 
					move_uploaded_file($p_tmp_name,'upload/'.$p_img_name);
					echo 'saved';
					header("Location: view_product.php");
					
				}else{
					echo 'not saved';
				}

				}else{
					$msg ="your file must be jpg or png";
					echo $msg;
				}
				
				
			}
		


				?>
			<form action="add_product.php" method="post" enctype = "multipart/form-data">
				Product name:<br>
				<input type="text" name="product_name"><br><br>
				Product category:<br>
				<select name="product_category">
					<?php
						while($data=mysqli_fetch_array($result))
						{
							$cat_id=$data['cat_id'];
							$category_name=$data['category_name'];
							echo "<option name='$cat_id'>$category_name</option>";
						}
						
					?>
					
				</select><br><br>
				Product price:<br>
				<input type="number" name="product_price"><br><br>
				Product quantity:<br>
				<input type="number" name="product_quantity"><br><br>
				Upload Image:<br>
				<input type="file" name="p_img"><br><br>
				<input type="submit" value="Save" name="submit">
			</form>
			
		</body>


	</html>