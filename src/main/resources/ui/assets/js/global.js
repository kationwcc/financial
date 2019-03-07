var link = document.createElement("link");
link.rel = "stylesheet";
link.type = "text/css";
link.href = "/assets/css/toastr.min.css";
document.getElementsByTagName("head")[0].appendChild(link);

document.write("<script src='assets/js/toastr.min.js'></script>");
document.write("<script src='assets/js/jquery-1.10.2.js' ></script>");
document.write("<script src='assets/js/jquery.cookie.js'></script>");


$(
    $('body').ready(function () {
        var token = $.cookie('token');
        if(!token){
            toastr.warning("请先登入。");
            setTimeout(function () {
                $(location).attr('href', 'index.html');
            }, 2000);
        }
    })
)


