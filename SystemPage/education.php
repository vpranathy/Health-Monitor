<?php 
	
	session_start();
	
	class education	{
		private $id;
		private $username;
		private $address;
		private $type;
		private $lat;
		private $lng;
		private $conn;
		private $tablename = "HealthMonitoring.HeartData";

		function setId($id) { $this->id = $id; }
		function getId() { return $this->id; }
		function setUsername($username) { $this->username = $username; }
		function getUsername() { return $this->username; }
		function setAddress($address) { $this->address = $address; }
		function getAddress() { return $this->address; }
		function setType($type) { $this->type = $type; }
		function getType() { return $this->type; }
		function setLat($lat) { $this->lat = $lat; }
		function getLat() { return $this->lat; }
		function setLng($lng) { $this->lng = $lng; }
		function getLng() { return $this->lng; }

		public function __construct() {
			require_once('db/DbConnect.php');
			$conn = new DbConnect;
			$this->conn = $conn->connect();
		}

		public function getCollegesBlankLatLng() {
			$sql = "SELECT * FROM $this->tablename WHERE lat IS NULL AND lng IS NULL";
			$stmt = $this->conn->prepare($sql);
			$stmt->execute();
			return $stmt->fetchAll(PDO::FETCH_ASSOC);
		}

		public function getAllColleges() {
			$temp=$_SESSION['username'];
			$sql = "SELECT * FROM $this->tablename WHERE username = '$temp'";
			$stmt = $this->conn->prepare($sql);
			$stmt->execute();
			return $stmt->fetchAll(PDO::FETCH_ASSOC);
		}

		public function updateCollegesWithLatLng() {
			$sql = "UPDATE $this->tablename SET lat = :lat, lng = :lng WHERE id = :id";
			$stmt = $this->conn->prepare($sql);
			$stmt->bindParam(':lat', $this->lat);
			$stmt->bindParam(':lng', $this->lng);
			$stmt->bindParam(':id', $this->id);

			if($stmt->execute()) {
				return true;
			} else {
				return false;
			}
		}
	}

?>