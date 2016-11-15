<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$pin=$_GET['pin'];
    
 $result = mysql_query("select * from users where pin=".$pin) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;

		 $response["id"] =$row["id_usr"];
		 $response["success"] = 1;
	     $response["message"] = "pin accepté";
    // echoing JSON response
    echo json_encode($response);
	}else
	{
	     $response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "pin incorrecte";
    // echoing JSON response
    echo json_encode($response);
	}
    
   
 
 
 
?>
