<?php 

include 'config.php';


session_start();

error_reporting(0);




if (isset($_POST['submit'])) {
	
	
	$v_code = $_POST['v_code'];
	$v_code1 = $_SESSION['v_code'];
	$password = $_POST['password'];
	$cpassword = $_POST['cpassword'];
	
	
	$email=$_SESSION['email'];
	$sql = "SELECT * FROM user WHERE email='$email'"; 
	$result = mysqli_query($conn, $sql);
	if ($result->num_rows > 0) {
		$row = mysqli_fetch_assoc($result);
		if($v_code1==$v_code)
		{
			if ($password == $cpassword)
			{
				$upd="update user set password='$password' where email='$email'";
				$result = mysqli_query($conn, $upd);
				echo "<script>alert('Password changed.')</script>";
				header("Location: index.php");
			}
			else{
				echo "<script>alert('Password didnot match.')</script>";
			}
			
			
			//header("Location: welcome.php");
		}
		else{
			echo "<script>alert('Wrong verification code')</script>";
		}
		
	} 
	else echo "<script>alert('Woops! Email is not verified $email')</script>";
}

?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="style.css">
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body {
    width: 100%;
    min-height: 100vh;
   
   

   background-color: #485461;
background-image: linear-gradient(315deg, #485461 0%, #28313b 74%);
   
    background-position: center;
    background-size: cover;
   
    display: flex;
    justify-content: center;
    align-items: center;
   
}

.container {
    width: 400px;
    min-height: 400px;
    float:right;
    clear: right;
    background: #FFF;
    border-radius: 5px;
    box-shadow: 0 0 5px rgba(0,0,0,.3);
    padding: 40px 30px;
}

.container .login-text {
    color: #111;
    font-weight: 500;
    font-size: 1.1rem;
    text-align: center;
    margin-bottom: 20px;
    display: block;
    text-transform: capitalize;
}

.container .login-social {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(50%, 1fr));
    margin-bottom: 25px;
}

.container .login-social a {
    padding: 12px;
    margin: 10px;
    border-radius: 3px;
    box-shadow: 0 0 5px rgba(0,0,0,.3);
    text-decoration: none;
    font-size: 1rem;
    text-align: center;
    color: #FFF;
    transition: .3s;
}



.container .login-email .input-group {
    width: 100%;
    height: 50px;
    margin-bottom: 25px;
}

.container .login-email .input-group input {
    width: 100%;
    height: 100%;
    border: 2px solid #e7e7e7;
    padding: 15px 20px;
    font-size: 1rem;
    border-radius: 30px;
    background: transparent;
    outline: none;
    transition: .3s;
}

.container .login-email .input-group input:focus, .container .login-email .input-group input:valid {
    border-color: #a29bfe;
}

.container .login-email .input-group .btn {
    display: block;
    width: 100%;
    padding: 15px 20px;
    text-align: center;
    border: none;
    background: #a29bfe;
    outline: none;
    border-radius: 30px;
    font-size: 1.2rem;
    color: #FFF;
    cursor: pointer;
    transition: .3s;
}

.container .login-email .input-group .btn:hover {
    transform: translateY(-5px);
    background: #6c5ce7;
}

.login-register-text {
    color: #111;
    font-weight: 600;
}

.login-register-text a {
    text-decoration: none;
    color: #6c5ce7;
}


	</style>

	<title>Verify</title>
</head>
<body>
	<div class="container">
		<form action="" method="POST" class="login-email">
			<p class="login-text" style="font-size: 2rem; font-weight: 800;">Verify your account</p>
			<div class="input-group">
				<input type="v_code" placeholder="Enter Verify Code" name="v_code" value="<?php echo $_POST['email']; ?>" required>
			</div>
			<div class="input-group">
				<input type="password" placeholder="Password" name="password" value="<?php echo $_POST['password']; ?>" required>
            </div>
            <div class="input-group">
				<input type="password" placeholder="Confirm Password" name="cpassword" value="<?php echo $_POST['cpassword']; ?>" required>
			</div>
			<div class="input-group">
				<button name="submit" class="btn">Confirm password</button>
			</div>
			
		</form>
	</div>
</body>
</html>