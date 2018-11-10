<?php
$temp=$_SESSION['username'];
$db = mysqli_connect('softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com', 'yuyangchen0122', 'a123123q45', 'HealthMonitoring');
$query1 = "SELECT * FROM HealthMonitoring.users WHERE username='$temp'";
$result1 = mysqli_query($db, $query1);
?>
<!DOCTYPE html>
<html>
  <head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css" />
  </head>
  <body>
      <h3 align="left">User Information<br></h3>
      <div class="table-responsive">
        <table id="user_data" class="table table-striped table-bordered">
          <thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">username</th>
							<th scope="col">email</th>
							<th scope="col">firstname</th>
							<th scope="col">lastname</th>
							<th scope="col">address</th>
              <th scope="col">city</th>
              <th scope="col">country</th>
              <th scope="col">postalcode</th>
              <th scope="col">aboutme</th>
					</tr>
          </thead>
          <?php
          while($row = mysqli_fetch_array($result1))
          {
          echo '
					<tr>
								<td>'.$row["id"].'</td>
								<td>'.$row["username"].'</td>
								<td>'.$row["email"].'</td>
								<td>'.$row["firstname"].'</td>
								<td>'.$row["lastname"].'</td>
								<td>'.$row["address"].'</td>
                <td>'.$row["city"].'</td>
                <td>'.$row["country"].'</td>
                <td>'.$row["postalcode"].'</td>
                <td>'.$row["aboutme"].'</td>
						</tr>
					';
          }
          ?>
        </table>
    </div>
  </body>
</html>
<script>
$(document).ready(function(){
$('#user_data').DataTable();
});
</script>
