<?php
$temp=$_SESSION['username'];
$db = mysqli_connect('softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com', 'yuyangchen0122', 'a123123q45', 'HealthMonitoring');
$query5 = "SELECT * FROM HealthMonitoring.HeartData WHERE username='$temp'";
$result5 = mysqli_query($db, $query5);
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
      <h3 align="left">HeartBeat Data while Studying<br></h3>
      <div class="table-responsive">
        <table id="studying_data" class="table table-striped table-bordered">
          <thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">username</th>
							<th scope="col">HeartRate</th>
							<th scope="col">Date</th>
							<th scope="col">Time</th>
							<th scope="col">Music</th>
					</tr>
          </thead>
          <?php
          while($row = mysqli_fetch_array($result5))
          {
          echo '
					<tr>
								<td>'.$row["id"].'</td>
								<td>'.$row["username"].'</td>
								<td>'.$row["HeartRate"].'</td>
								<td>'.$row["Date"].'</td>
								<td>'.$row["Time"].'</td>
								<td>'.$row["Music"].'</td>
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
$('#studying_data').DataTable();
});
</script>
