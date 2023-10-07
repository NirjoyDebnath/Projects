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
		$sql1= "select * from  product";
		$query = $conn->query($sql1);
		echo "<table border='1'><tr><th> Product Name</th> 
		<th>Product Category </th> 
		<th>Product Price </th>
		<th>Product Quantity </th>
		<th>Product Image </th>
		<th> Action</th>
		<th> Action2</th></tr>";

		while ($data = mysqli_fetch_assoc($query)){
			$Product_id        = $data ['product_id'];
			$Product_name = $data ['product_name'];
			$Product_Category    = $data ['product_category'];
			$Product_price    = $data ['product_price'];
			$Product_quantity    = $data ['p_quantity'];
			$Product_image    = $data ['p_img'];
			
			echo  "<tr><td>$Product_name</td>
			<td>$Product_Category</td> 
			<td>$Product_price </td> 
			<td>$Product_quantity</td>
			<td><img style = 'height : 100px;width:100px' src ='upload/$Product_image'> </td>
			<td><a  href='edit_product.php?id=$Product_id ' >Edit </a></td>
			<td><a href='delete_product.php?id=$Product_id ' >Delete </a></td></tr>";

			
			}
		echo "</table>";

		?>
			
	</body>

</html>