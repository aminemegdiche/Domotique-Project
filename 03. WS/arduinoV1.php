<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";


// connecting to db
$db = new DB_CONNECT();

 @$id_chmbre=$_GET['id_chmbre'];
    
 $result = mysql_query("SELECT * FROM `lampe`  where id_rm=".$id_chmbre) or die(mysql_error());

 if (mysql_num_rows($result) > 0)
 {
  //   $response["equip"] = array();  
   while(  $row = mysql_fetch_array($result) )
	 
        {
	//	 $equip = array();
        $response["id_lampe"] = $row["id_lampe"];
        $response["id_rm"] = $row["id_rm"];
        $response["etat_lampe"] = $row["etat_lampe"];
        $response["auto_lampe"] = $row["auto_lampe"];
        $response["pin_lampe"] = $row["pin_lampe"];
		
        // push single per into final response array
     //   array_push($response["equip"], $equip);
		 }
    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "List";
  $json=json_encode($response);
    //echo ($json) ;
  
echo(str_replace('"','\"',$json));

	}else
	{
	    
		 $response["success"] = 0;
	     $response["message"] = "pas de equip";
    // echoing JSON response
$json=json_encode($response);
    echo ($json) ;
	}
    
 
 
?>
