
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
			if(isset($_GET['id'])){
				$getid =$_GET['id'];
				$sql = "select * from product where product_id = $getid";
				$query = $conn->query($sql);
				while ($data = mysqli_fetch_assoc($query))
				{
					
					$Product_id        = $data ['product_id'];
					$Product_name = $data ['product_name'];
					$Product_Category    = $data ['product_category'];
					$Product_price    = $data ['product_price'];
					$Product_quantity    = $data ['p_quantity'];
					$Product_image    = $data ['p_img'];
				

				}
			}
			
			
			if(isset($_POST['submit'])){
				$n_product_id = $_GET['id'];
				$n_product_name = $_POST['product_name'];
				$n_product_category = $_POST['product_category'];
				$n_product_price = $_POST['product_price'];
				$n_product_quantity = $_POST['product_quantity'];
				$n_p_img_name =$_FILES['p_img']['name'];
				$n_p_img_size=$_FILES['p_img']['size'];
				$n_p_tmp_name=$_FILES['p_img']['tmp_name'];
				$n_p_ext= pathinfo($n_p_img_name,PATHINFO_EXTENSION);
				if($n_p_ext == 'jpg' or $n_p_ext == 'png' or $n_p_ext == 'jpeg')
				{
					$sql = "update product
					set product_name = '$n_product_name',product_category ='$n_product_category ',product_price='$n_product_price',p_quantity='$n_product_quantity',p_img='$n_p_img_name ' where product_id = $n_product_id ";
					//echo $sql;
					$result = mysqli_query($conn, $sql);

					if($result){ 
						move_uploaded_file($n_p_tmp_name,'upload/'.$n_p_img_name);
						echo 'saved';
						header("Location: view_product.php");
						
					}
				}

				else{
					$msg ="your file must be jpg or png";
					echo $msg;
				}
	

			}
				
			?>
			<form action="#" method="post" enctype = "multipart/form-data">
				Product name:<br>
				<input type="text" name="product_name" value="<?php echo $Product_name ?>"><br><br>
				Product category:<br>
				<select name="product_category" value="<?php echo $Product_Category ?>">
					<?php
						while($data=mysqli_fetch_array($result))
						{
							if($data == $Product_Category) {
								continue;
							}
							$cat_id=$data['cat_id'];
							$category_name=$data['category_name'];
							echo "<option name='$cat_id'>$category_name</option>";
						}
						echo "<option value='$Product_Category' selected>$Product_Category</option>";
					?>
				</select><br><br>
				Product price:<br>
				<input type="number" name="product_price" value="<?php echo $Product_price ?>"><br><br>
				Product quantity:<br>
				<input type="number" name="product_quantity" value="<?php echo $Product_quantity ?>"><br><br>
				Upload Image:<br>
				<input type="file" name="p_img"><br><br>
				<input type="submit" value="Save" name="submit">
			</form>
			
		</body>


	</html>