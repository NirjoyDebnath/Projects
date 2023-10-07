<?php 

session_start();

if (!isset($_SESSION['email'])) {
   header("Location: index.php");
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin panel</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container bg-light"><!--start of container-->
        <div class="container - fluid border-bottom border-success "><!--top bar-->
           
            <?php include('topbar.php');?>
            
        </div><!--end of top bar--> 
        <div class="container-fluid">
            <div class="row"><!--left bar-->
                <div class="col-sm-3 bg-light p-0 m-o">
                    <?php include('leftbar.php');?>
                </div><!--end of left bar-->
                <div class="col-sm-9"><!--start of right bar-->
                    right
                </div><!--end of right bar-->
                
            </div>
            
        </div>
        <div class="container-fluid">
            bottom bar
            
        </div>
    </div><!--end of container-->





   
</body>
</html>