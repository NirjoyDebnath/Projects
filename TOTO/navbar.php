<?php 

session_start();

if (!isset($_SESSION['email'])) {
   header("Location: index.php");
}

?>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">TOTO</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Category
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <?php
            $server = "localhost";
            $user = "root";
            $pass = "";
            $database = "toto";
            $conn = mysqli_connect($server, $user, $pass, $database);

            $sql = "SELECT * FROM category "; 
            $result = mysqli_query($conn, $sql);
            while($row = mysqli_fetch_array($result)) 
            {
              echo "<li><a class='dropdown-item' href='product_view.php?name=$row[category_name]'>$row[category_name]</a></li>";
            }
            ?>
          </ul>
        </li>
        
      </ul>
      <form class="d-flex">
        <p class="pt-3"><?php echo $_SESSION['email']; ?>
                      <a href="logout.php" class="text-white text-decoration-none btn btn-secondary py-1 px-0">Logout</a>
                     <a href="logout.php" class="text-white text-decoration-none btn btn-secondary py-1 px-0">User</a></p>
      </form>
    </div>
  </div>
</nav>