<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id_usr=$_GET['id_usr'];
  @$id_rm=$_GET['id_rm'];
  
 
		
 
		$result = mysql_query(" select * from rooms where id_usr=$id_usr and id_rm=$id_rm ; ") or die(mysql_error());
if (mysql_num_rows($result) > 0)
 {
     
   while(  $row = mysql_fetch_array($result) )
	 
        {
		 
		  $response["th_v"] = $row["th_v"];
        $response["th_m"] = $row["th_m"];
       
		 }
    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "";
    echo json_encode($response);
	}else
	{
	    
		 $response["success"] = 0;
	     $response["message"] = "etat non disponible ";
    // echoing JSON response
    echo json_encode($response);
	}
    
 
?>
