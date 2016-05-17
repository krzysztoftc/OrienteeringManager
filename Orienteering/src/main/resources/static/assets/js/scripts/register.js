
jQuery(document).ready(function() {
	change_type();
    /*
        Fullscreen background
    */
});

function change_type() {
	var type = $("#register-club-type").val();
	var club_fields = $(".only-club");

	if (type == "CLUB"){
		club_fields.each(function () {
			$(this).show();
		});

		$("#register-address").attr("placeholder", "Adres klubu");
		$("#register-agent-surnaname").attr("placeholder", "Nazwisko przedstawiciela");
		$("#register-agent_name").attr("placeholder", "Imię przedstawiciela");
	}

	else {
		club_fields.each(function () {
			$(this).hide();
		});
		
		$("#register-address").attr("placeholder", "Adres");
		$("#register-agent-surnaname").attr("placeholder", "Nazwisko");
		$("#register-agent_name").attr("placeholder", "Imię");
	}
	$.backstretch("assets/img/backgrounds/1.jpg");

}