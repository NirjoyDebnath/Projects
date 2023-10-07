<html>

<head>
    <title>
        TOTO
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>

<body>
	
    <!--nav bar start-->
    <?php include 'navbar.php'?>
    <!-- nav bar end-->
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
    <h2 class="mx-auto mb-5 text-center "><u>Categories</u></h2> 
    <div class="row">
        <?php
        /*------Latest 5----*/
        $sql = "SELECT * FROM category "; 
        $result = mysqli_query($conn, $sql);
                                     // output data of each row 
        while($row = mysqli_fetch_array($result)) 
        { 


            ?> 
            <!--cat Image-->  
            <div class="col-sm-3 text-center mt-2"><img style = 'height:300px;width:20px' src="upload/<?php echo $row['p_img'];?>"
                class="d-block w-100" alt="image1">
                <!--cat Name-->   
                
                <a  href='shirt.php?id=$cat_id ' ><h5><?php echo $row['category_name']; ?></h5></a>
            
            <!--cat Page-->   

        </div>

        <?php


    } 
    ?>

</section>

<!-- newarrival-->

<section class="container mt-5">
    <h2 class="mx-auto mb-5 text-center ">Recently Added</h2> 
    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="row">
                    <?php
                    /*------Latest 5----*/
                    $sql = "SELECT * FROM product ORDER BY addDate desc limit 4"; 
                    $result = mysqli_query($conn, $sql);
                        			 // output data of each row 
                    while($row = mysqli_fetch_array($result)) 
                    { 


                        ?> 
                        <!--Product Image-->  
                        <div class="col-sm-3 text-center mt-2"><img style = 'height:250px;width:30px' src="upload/<?php echo $row['p_img'];?>"
                            class="d-block w-100" alt="image1">
                            <!--Product Name-->   
                            <h5><?php echo $row['product_name']; ?></h5>
                            <!--Product Page-->   
                            <h4>TK <?php echo $row['product_price']; ?></h4>
                        </div>

                        <?php


                    } 
                    ?>
                </div>
            </div>
        </div>                  


    </div>


</section>












<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
crossorigin="anonymous"></script>

</body>

</html>