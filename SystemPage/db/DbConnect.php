<?php 
	class DbConnect {
		private $host = 'softenggroup2.czmkb4udcq6o.us-east-2.rds.amazonaws.com';
		private $dbName = 'HealthMonitoring';
		private $user = 'yuyangchen0122';
		private $pass = 'a123123q45';

		public function connect() {
			try {
				$conn = new PDO('mysql:host=' . $this->host . '; dbname=' . $this->dbName, $this->user, $this->pass);
				$conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
				return $conn;
			} catch( PDOException $e) {
				echo 'Database Error: ' . $e->getMessage();
			}
		}
	}
 ?>