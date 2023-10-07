<?php
session_start();
?>
<html>

<head>
    <title>

    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>



<body>
  <!--nav bar start-->
  <?php include 'navbar.php'?>
  <?php

  $server = "localhost";
  $user = "root";
  $pass = "";
  $database = "toto";
  $conn = mysqli_connect($server, $user, $pass, $database);
  if(!$conn) 
  { 
   die("Connection failed: " . mysqli_connect_error()); 
} 
?>
<section class="container">
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="row">


                    <?php
                  
                    if(isset( $_GET['id']))
                        { $getid = $_GET['id'];

                    $sql = "SELECT*  FROM Category where cat_id=$getid"; 
                    $result = mysqli_query($conn, $sql); 

			 // output data of each row 
                    while($row = mysqli_fetch_array($result)) 
                    { 


                     ?>




                     <div class="col-sm-3 text-center mt-2"><img src="<?php echo $row['p_img'];?>"
                        class="d-block w-100" alt="image1">


                        <form method="post" action="Cart.php?action=add&id=<?php echo $row["id"]; ?>">
                            <!--sean-->
                            <h4><?php echo $row['name']; ?></h4>
                            <h5>TK <?php echo $row['price']; ?></h5>
                            <h6>Avaibility: <?php echo $row['quantity'];?></h6>
                            <input type="number" name="quantity_select" id="quantity1" class="form-control my-2"
                            value="0">
                            <input type="hidden" name="hidden_image" value="<?php echo $row["pimage"]; ?>">
                            <input type="hidden" name="hidden_name" value="<?php echo $row["name"]; ?>">
                            <input type="hidden" name="hidden_price" value="<?php echo $row["price"]; ?>">
                            <input type="hidden" name="hidden_quantity" value="<?php echo $row["quantity"]; ?>">
                            <button type="submit" name="submit1" class="btn btn-success">
                                <i class="fa fa-shopping-cart"></i>
                                <a href="Cart.php" style=text-decoration:none></a>
                                Add to Cart
                            </button>

                        </div>
                    </form>


                    <?php


                } 
            }
                ?>
            </div>
        </div>
    </div>


</div>


</section>

</body>

</html>