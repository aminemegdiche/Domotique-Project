<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";

// connecting to db
$db = new DB_CONNECT();
if(isset($_GET['id_user']))  
{
 @$id_user=$_GET['id_user'];
    }
	else 
	{
	@$id_user=0;
	}
 $result = mysql_query("SELECT * FROM `rooms` WHERE `id_rm` in (SELECT `id_rm` FROM `droits_utu` WHERE `id_user`=".$id_user.")") or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
     $response["Room"] = array();  
   while(  $row = mysql_fetch_array($result) )
        {
		 $Room = array();
        $Room["id_rm"] = $row["id_rm"];
        $Room["des_rm"] = $row["des_rm"];
		 $Room["temp_rm"] = $row["temp_rm"];
		   $Room["himu_rm"] = $row["himu_rm"];
		
        // push single per into final response array
        array_push($response["Room"], $Room);
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
