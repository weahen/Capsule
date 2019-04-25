var stompClient = null;

// function setConnected(connected) {
//     $("#connect").prop("disabled", connected);
//     $("#disconnect").prop("disabled", !connected);
//     if (connected) {
//         $("#conversation").show();
//     }
//     else {
//         $("#conversation").hide();
//     }
//     $("#notice").html("");
// }

function connect() {
    var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
//    welcome();
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        //订阅群聊消息
        stompClient.subscribe('/chat/IOT', function (result) {
            showContent(JSON.parse(result.body));
        });

        //订阅在线用户消息
        // stompClient.subscribe('/topic/onlineuser', function (result) {
        // 	showOnlieUser(JSON.parse(result.body));
        // });
//        stompClient.send("/app/v6/ol", {},JSON.stringify({'content': $("#editArea").val()}));


    });

}

// function sendonlinerequest()
// {
// 	stompClient.send("/app/v6/ol",{},null);
// 	console.log("Online Request");
// }
//断开连接
function disconnect() {
    // stompClient.send("/app/Logoff", {}, JSON.stringify({'content': $("#editArea").val()}));
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

//发送聊天记录
function sendContent() {
    stompClient.send("/app/chatroom/IOT", {}, JSON.stringify({'content': $("#editArea").val(),'path':"/IOT"}));


}

//显示聊天记录
function showContent(body) {
    $("#record").append("<tr><td>" + body.content + "</td> <td>");
}

// function welcome() {
// 	var xmlHttp;
// 	function GetXmlObj()
// 	{
// 		if(window.XMLHttpRequest)
// 			{
// 				xmlhttp = new XMLHttpRequest();
//
// 			}
// 		else
// 			{
// 				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
// 			}
// 		return xmlhttp;
// 	}
// 	xmlHttp=GetXmlObj();
// 	if(xmlHttp)
//
//
// 	xmlHttp.open("get","/welcome",false);
// 	xmlHttp.send();
// 	$("#welcome").html(xmlHttp.responseText);
// }
//
// //显示实时在线用户
// function showOnlieUser(body) {
//     $("#online").html("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleTimeString()+"</td></tr>");
// }


$(function () {

    connect();//自动上线

    // welcome();

    $("form").on('submit', function (e) {
        e.preventDefault();
    });

    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() {
        sendContent();
    });
});

