var link = document.createElement("link");
link.rel = "stylesheet";
link.type = "text/css";
link.href = "assets/css/toastr.min.css";
document.getElementsByTagName("head")[0].appendChild(link);

document.write("<script src='assets/js/toastr.min.js'></script>");
document.write("<script src='assets/js/jquery-1.10.2.js' ></script>");
document.write("<script src='assets/js/jquery.cookie.js'></script>");


setTimeout(function () {
    $('body').ready(function () {
        var user = $.cookie('user');
        if(user == null){
            $(location).attr('href', 'index.html');
        }
        var $obj = JSON.parse(user);
        $(".user-name").text($obj.name);

    });

    $("#logout").click(function(){
        $.cookie('user', '', { expires: -1 });
        $(location).attr('href', 'index.html');
    });



}, 100)




