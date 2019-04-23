window.onload=function () {
        $.ajax(
            {
                url:"http://rap2api.taobao.org/app/mock/124309/getroom",
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


function showdata(data) {

    var str = "";
    for (var i=0;i<data.roomlist.length;i++)
    {

        str = "<tr><td>"+data.roomlist[i].name+"</td>"+"<td>"+data.roomlist[i].path+"</td>"+"<td>"+data.roomlist[i].name+"</td></tr>";
        $("#tab").append(str);
        $("#tab").show();
    }

}