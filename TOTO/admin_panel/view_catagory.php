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
		$sql1= "select * from  category";
		$query = $conn->query($sql1);
		echo "<table border='1'><tr><th> Category Name</th> 
		<th>Entry Date </th> 
		<th> Action</th>
		<th> Action2</th></tr>";

		while ($data = mysqli_fetch_assoc($query)){
			$cat_id        = $data ['cat_id'];
			$category_name = $data ['category_name'];
			$entry_date    = $data ['entry_date'];
			$_SESSION['CATEGORY_ID']= $cat_id;
			echo  "<tr><td>$category_name</td>
			<td>$entry_date</td> 
			<td><a href='edit_catagory.php?id=$cat_id' >Edit </a></td>
			<td><a href='delete_category.php?id=$cat_id' >Delete </a></td></tr>";

		}
		echo "</table>";

		?>
	</body>

</html>