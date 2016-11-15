<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id=$_GET['id'];
    
 $result = mysql_query("select * from rooms where id_rm=".$id) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;
     	 

	 	 
	 	 
      
        echo "<li>".$row["li_v"]."</li>";
		}
    
   
 
 
 
?>
