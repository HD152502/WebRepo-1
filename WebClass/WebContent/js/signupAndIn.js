$(document).ready(function() {
	$('#signupForm').submit(function(e) {
		e.preventDefault();
		var name = $('#name').val();

		$.post("http://httpbin.org/post",
			{"name": name},
			function(data) {
				var myModal = $('#signupModal');
				myModal.modal();
				myModal.find('.modal-body').text(data.form.name + "님 회원가입되었습니다.");
			}
		);
	});

	$('#signinForm').submit(function(e) {
		e.preventDefault();
		var id = $('#id').val();

		$.post("http://httpbin.org/post",
			{"id": id},
			function(data) {
				var myModal = $('#signinModal');
				myModal.modal();
				myModal.find('.modal-body').text(data.form.id + "님 로그인되었습니다.");
			}
		);
	});

	$('#close').on('click', function() {
		$(location).attr('href', 'index.html');
	})
});