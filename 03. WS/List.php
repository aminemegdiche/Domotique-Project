<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . 'db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id=$_GET['id'];
    
 $result = mysql_query("select * from rooms where id_usr=".$id) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
     $response["Room"] = array();  
   while(  $row = mysql_fetch_array($result) )
	 
        {
		 $room = array();
        $room["room"] = $row["des_rm"];
        $room["id_rm"] = $row["id_rm"];
        $room["li_m"] = $row["li_m"];
         $room["li_s"] = $row["li_s"];
        $room["th_s"] = $row["th_s"];
        	
		
        // push single per into final response array
        array_push($response["Room"], $room);
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
