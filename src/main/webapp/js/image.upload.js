$(document).ready(function() {
	$("#multipart").submit(function(e) {
		var formData = new FormData(this);
		var base_url = window.location.origin;
		$.ajax({
			url : base_url + '/buysellapp/resources/img/uploadImg',
			type : 'POST',
			data : formData,
			mimeType : "multipart/form-data",
			contentType : false,
			cache : false,
			processData : false,
			success : function(data, textStatus, jqXHR) {
				$("#imgUpload").attr("src", JSON.parse(data)[0]);
				$("#image").val(JSON.parse(data)[0]);
			},
			error : function(jqXHR, textStatus, errorThrown) {
			}
		});
		e.preventDefault(); // Prevent Default
		// action.
		e.unbind();
	});

	$("#more").click(function() {
		$('#container').append('<br>Image :<input type="file" name="file" />');
	});

});