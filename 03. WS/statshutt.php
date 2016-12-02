<?php
// array for JSON response
$response = array();

// include db connect class
require "db_connect.php";
// connecting to db
$db = new DB_CONNECT();




if(isset($_GET['id_shutter']))  
{
@$id_shutter=$_GET['id_shutter'];
}
else
{@$id_shutter=0;
}

  

   // print("SELECT * FROM users WHERE email_user = '".$mail."' AND mdp_user = ".$mdp);
	$result = mysql_query("SELECT `etat` FROM `shutter` WHERE `id_shutter`=".$id_shutter)or die(mysql_error());
	
	

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;

		 $response["etat"] =$row["etat"];
		 	    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "etat shutter";
    echo json_encode($response);
		}
		
	else
	{
	     $response["id"] =0;
		 $response["success"] = 0;
	     $response["message"] = "shutter incorrect";
    // echoing JSON response
    echo json_encode($response);
	}
	
 
 
 
?>
