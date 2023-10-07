 <?php 
 //session_start();
 ?>
 <div class="row p-3">
                <div class="col-sm-9">
                   <h1><a href="admin_panel.php" class="text-secondary text-decoration-none">ADMIN PANEL</a></h1>  
                </div>
                <div class="col-sm-3">
                     <p class="pt-3"><?php echo $_SESSION['email']; ?>
                      <a href="logout.php" class="text-white text-decoration-none btn btn-secondary py-1 px-0">Logout</a></p>
                </div>
                
            </div>
