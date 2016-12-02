<?php
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";


// connecting to db
$db = new DB_CONNECT();

 @$id_user=$_GET['id_user'];
  //  print("SELECT * FROM users WHERE email_user = ".$mail." AND mdp_user = ".$mdp);
	$result = mysql_query("SELECT * FROM droits_utu WHERE id_user= ".$id_user)or die(mysql_error());
	
	if (mysql_num_rows($result) > 0)
 {
     $response["droit"] = array();  
   while(  $row = mysql_fetch_array($result) )
	 
        {
		 $droit = array();
        $droit["id_droit"] = $row["id_droit"];
        $droit["id_maison"] = $row["id_maison"];
        $droit["id_user"] = $row["id_user"];
         $droit["id_rfid"] = $row["id_rfid"];
        	
		
        // push single per into final response array
        array_push($response["droit"], $droit);
		 }
    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "List";
    echo json_encode($response);
	}else
	{ 
		 $response["success"] = 0;
	     $response["message"] = "pas de piéce ";
    // echoing JSON response
    echo json_encode($response);
	}
    
   ?>