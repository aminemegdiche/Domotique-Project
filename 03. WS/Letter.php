<?php
   

// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";

// connecting to db
$db = new DB_CONNECT();
if(isset($_GET['id_maison']))  
{
 @$id_maison=$_GET['id_maison'];
    }
	else 
	{
	@$id_maison=0;
	}
 $result = mysql_query("SELECT * FROM `letter`  WHERE `id_maison` =".$id_maison) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
     $response["letter"] = array();  
   while(  $row = mysql_fetch_array($result) )
	 
        {
		 $letter = array();
        $letter["id_letter"] = $row["id_letter"];
        $letter["date_letter"] = $row["date_letter"];
        $letter["heure_letter"] = $row["heure_letter"];
        $letter["status_letter"] = $row["status_letter"];
        $letter["id_maison"] = $row["id_maison"];
		
        // push single per into final response array
        array_push($response["letter"], $letter);
		 }
    // echoing JSON response
	     $response["success"] = 1;
	     $response["message"] = "List";
    echo json_encode($response);
	}else
	{
	    
		 $response["success"] = 0;
	     $response["message"] = "pas de letter ";
    // echoing JSON response
    echo json_encode($response);
	}
    
   
 
 
 
?>
