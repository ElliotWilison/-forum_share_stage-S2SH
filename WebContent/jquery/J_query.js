$(document).ready(function(){
	
	var uname=$("#uname").val();
	if(uname!=null){
		$("#login").text(uname);
		$("#login").attr('href','#');
		
		}
	
	
	$("#search").click(function(){
		var key=$("#searchKey").val();
		window.location.href("topicInput.action?searchKey="+key);		
	});
	
});