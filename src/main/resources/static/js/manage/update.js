window.onload=function () {
        $.ajax(
            {
                url:"/regist_cache",
                type:"post",
                dataType:"json",
                success:function (data) {
                    showdata(data);

                },
                error:function (msg) {

                    alert("AJAX ERROR"+msg);

                }
            }
        )

    }
var index="";

function returnIndex() {
    return index;
}

function setIndex(s) {
   index=s;
}

function getIndex() {
    $("#aaaaaaa").val(index);
}

function showdata(data) {

    var str = "";
    for (var i=0;i<data.length;i++)
    {

        str = "<tr><td>"+data[i].name+"</td>"+"<td>"+data[i].password+"</td>"+"<td>"+data[i].email + "</td>" + "<td>" + "<button class='btn btn-primary btn-sm' data-toggle='modal' data-target='#myModal' onclick='setIndex(data[i].name)'>审批管理员</button>"+"</td></tr>";
        $("#tab").append(str);
        $("#tab").show();
    }

}