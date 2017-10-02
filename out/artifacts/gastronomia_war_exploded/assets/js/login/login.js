$(function() {
    var $cpf = $("#cpf");

    $cpf.mask('999.999.999-99');

    $(".btn-success").click(function (event) {
        event.preventDefault();
        var username = $("#username").val();
        var user = {};
        if(username.indexOf("@") === -1){
            user.matricula = username;
        } else {
            user.email = username;
        }

        user.senha = $("#password").val();

        $.ajax({
            type: "POST",
            url: urlDefault + "auth/login",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify(user),
            success: function (data) {
                if (data.token != '') {
                    console.log(data);

                    Cookies.set("token", data.token);
                    window.location.href = "cadastrarIngrediente.jsp";
                } else {
                    $(".alert-danger").text("Falha ao realizar login");
                    $(".alert-danger").fadeIn(3000).fadeOut(3000);
                }
            },
            error: function(){
                $(".alert-danger").text("Falha ao realizar login");
                $(".alert-danger").fadeIn(2000);
            }
        });
    });

    function removeDotsAndDashes(str) {
        return str.toString().replace(/([.-])/g, '');
    }
});