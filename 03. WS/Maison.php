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
 $result = mysql_query("SELECT * FROM `maison` WHERE `id_maison` in (SELECT `id_maison` FROM `droits_utu` WHERE `id_user`=".$id_user.")") or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
     $response["maison"] = array();  
   while(  $row = mysql_fetch_array($result) )
	 
        {
		 $maison = array();
        $maison["id_maison"] = $row["id_maison"];
        $maison["adr_maison"] = $row["adr_maison"];
        $maison["latitude_maison"] = $row["latitude_maison"];
        $maison["longitude_maison"] = $row["longitude_maison"];
        $maison["tel_maison"] = $row["tel_maison"];
         $maison["ip_maison"] = $row["ip_maison"];
		
        // push single per into final response array
        array_push($response["maison"], $maison);
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
