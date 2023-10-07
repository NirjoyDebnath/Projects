<?php 

include 'config.php';
?>

<!doctype html>
<html >	
	<head>
		<title>registered users</title>
	</head>
	<body>
		<?php
		$sql1= "select * from  user";
		$query = $conn->query($sql1);
		echo "<table border='1'><tr><th> User Name</th> 
		<th>User Email Address</th> 
		</tr>";

		while ($data = mysqli_fetch_assoc($query)){
			$cat_id        = $data ['ID'];
			$category_name = $data ['username'];
			$entry_date    = $data ['email'];
			$_SESSION['CATEGORY_ID']= $cat_id;
			echo  "<tr><td>$category_name</td>
			<td>$entry_date</td> 
			
			</tr>";

		}
		echo "</table>";

		?>
	</body>

</html>