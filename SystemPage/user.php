<?php include('server.php') ?>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Health Monitoring</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

    <div class="wrapper">
       <div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

   <div class="sidebar-wrapper">
    <div class="logo">
        <a href="http://yuyangchen.com" class="simple-text">
            Creative Yuyang Chen
        </a>
    </div>

    <ul class="nav">
        <li>
            <a href="index.php">
                <i class="ti-panel"></i>
                <p>Dashboard</p>
            </a>
        </li>
        <li class="active">
            <a href="user.php">
                <i class="ti-user"></i>
                <p>User Profile</p>
            </a>
        </li>
        <li>
            <a href="table.php">
                <i class="ti-view-list-alt"></i>
                <p>Table List</p>
            </a>
        </li>
        <li>
            <a href="typography.php">
                <i class="ti-text"></i>
                <p>Typography</p>
            </a>
        </li>
        <li>
            <a href="maps.html">
                <i class="ti-map"></i>
                <p>Maps</p>
            </a>
        </li>
        <li>
            <a href="http://healthmonitoringhomepage-env.5ndteffiz2.us-east-2.elasticbeanstalk.com/">
                <i class="ti-bell"></i>
                <p>Home Page</p>
            </a>
        </li>
    </ul>
</div>
</div>

<div class="main-panel">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar bar1"></span>
                <span class="icon-bar bar2"></span>
                <span class="icon-bar bar3"></span>
            </button>
            <a class="navbar-brand" href="#">User Profile</a>
        </div>
        <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="ti-bell"></i>
                        <p>Login/Sign Up</p>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="login.php">Log In</a></li>
                        <li><a href="register.php">Sign Up</a></li>
                    </ul>
                </li>
                    <li>
                        <a href="index?logout='1'">
                            <i class="ti-panel"></i>
                            <p>Log Out</p>
                            <?php
                            if (isset($_GET['logout'])) {
                             session_destroy();
                             unset($_SESSION['username']);
                            }
                            ?>
                        </a>
                    </li>
                <li>
                    <a href="#">
                        <i class="ti-settings"></i>
                        <p>Settings</p>
                    </a>
                </li>
            </ul>

        </div>
</div>
</nav>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4 col-md-5">
                <div class="card card-user">
                    <div class="image">
                        <img src="assets/img/background.jpg" alt="..."/>
                    </div>
                    <div class="content">
                        <div class="author">
                          <img class="avatar border-white" src="assets/img/faces/face-2.jpg" alt="..."/>
                          <h4 class="title"><?php echo $_SESSION['username']; ?><br />
                           <a href="#"><small>@<?php echo $_SESSION['username']; ?></small></a>
                       </h4>
                   </div>
                   <p class="description text-center">
                    <strong><?php echo $_SESSION['aboutme']; ?></strong>
                </p>
            </div>
            <hr>
        </div>
    </div>
    <div class="col-lg-8 col-md-7">
        <div class="card">
            <div class="header">
                <h4 class="title">Edit Profile</h4>
            </div>
            <form action="user.php" method="post"> 

                <div class="content">
                    <form>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Company</label>
                                    <input type="text" class="form-control border-input" disabled placeholder="Company" value="Soft Eng Gourp #2">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Username</label>
                                    <input value='<?php echo $_SESSION['username']; ?>' type="text" name="username" class="form-control border-input" disabled placeholder="Username">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Email address</label>
                                    <input type="text" name="email" class="form-control border-input" value="
                                    <?php 
                                    echo $email; ?>">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>First Name</label>
                                    <input type="text" name="firstname" class="form-control border-input" value="<?php 
                                    echo $firstname; ?>">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Last Name</label>
                                    <input type="text" name="lastname" class="form-control border-input" value="<?php echo $lastname; ?>">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>Address</label>
                                    <input type="text" name="address" class="form-control border-input" value="<?php echo $address; ?>">
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>City</label>
                                    <input type="text" name="city" class="form-control border-input" value="<?php echo $city; ?>">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Country</label>
                                    <input type="text" name="country" class="form-control border-input" value="<?php echo $country; ?>">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Postal Code</label>
                                    <input type="text" name="postalcode" class="form-control border-input" value="<?php echo $postalcode; ?>">                                            
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label>About me</label>
                                    <input type="text" name="aboutme" class="form-control border-input" value="<?php echo $aboutme; ?>">
                                </div>
                            </div>
                        </div>
                        <div class="input-group">
                            <button type="submit" class="btn" name="update_profile">Update Profile</button>
                        </div>
                        <div class="clearfix"></div>
                    </form>
                </form>
            </div>
        </div>
    </div>


</div>
</div>
</div>


<footer class="footer">
    <div class="container-fluid">
        <nav class="pull-left">
            <ul>

                <li>
                    <a href="http://yuyangchen.com/">
                        Yuyang Chen
                    </a>
                </li>
                <li>
                    <a href="https://yuyangchen0122.github.io/Health-Monitoring/">
                     Home Page
                 </a>
             </li>
             <li>
                <a href="https://github.com/yuyangchen0122">
                    GitHub
                </a>
            </li>
        </ul>
    </nav>
    <div class="copyright pull-right">
        &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> by <a href="http://yuyangchen.com/">Creative Yuyang Chen</a>
    </div>
</div>
</footer>

</div>
</div>


</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
