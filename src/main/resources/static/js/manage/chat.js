window.onload=function () {
        $.ajax(
            {
                url:"/getroom",
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
    for (var i=0;i<data.length;i++)
    {

        str = "<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td>"+"<td>"+data[i].location+"</td>"+"<td>"+data[i].end_TIME+"</td></tr>";
        $("#tab").append(str);
        $("#tab").show();
    }

}