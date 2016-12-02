<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require "db_connect.php";

// connecting to db
$db = new DB_CONNECT();
if(isset($_GET['id_user'])and isset($_GET['id_maison']))  
{
 @$id_user=$_GET['id_user'];
  @$id_maison=$_GET['id_maison'];
    }
	else 
	{
	@$id_user=0;
	@$id_maison=0;
	}
	 $result1 = mysql_query("SELECT * FROM `rooms` WHERE `id_rm` in (SELECT `id_rm` FROM `droits_utu` WHERE `id_user`=".$id_user." and `id_maison`=".$id_maison.")") or die(mysql_error());
 
if (mysql_num_rows($result1) > 0)
 {
  $response["lampe"] = array();  
  while(  $row1 = mysql_fetch_array($result1) )
        {
 	@$id_rm=$row1["id_rm"];
			$result = mysql_query("SELECT * FROM `lampe` WHERE `id_rm`=".$id_rm) or die(mysql_error());
 if (mysql_num_rows($result) > 0)
 {
    
  
		 while(  $row = mysql_fetch_array($result) )
        {
		 $lampe = array();
        $lampe["id_lampe"] = $row["id_lampe"];
        $lampe["id_rm"] = $row["id_rm"];
		$lampe["des_rm"] = $row1["des_rm"];
		 $lampe["temp_rm"] = $row1["temp_rm"];
		   $lampe["himu_rm"] = $row1["himu_rm"];
		 $lampe["etat_lampe"] = $row["etat_lampe"];
		  array_push($response["lampe"], $lampe);
		
        // push single per into final response array
		 }
		        
		 }

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
