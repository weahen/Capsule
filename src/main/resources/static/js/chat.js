var stompClient = null;
var path = null;
function connect() {
    var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);

    stompClient.connect({},
        function (frame) {

 //       path = document.getElementById("RoomSelector");
        path = $("#RoomSelector").val();
        console.log('connected'+frame);
        stompClient.subscribe('/chat'+path);
            stompClient.subscribe('/chat/1091728760')
 //       stompClient.send('/app/chatroom',{},JSON.stringify({'content':path}));


        });

}

function sendmessage() {
    stompClient.send('/app/chatroom'+path,{},JSON.stringify({'content':$("#textarea").val(),'path':path,'uid':"0"}));
    //console.log("send to : "+'/app/chat'+path);
}


$(function () {
        $("#send").click(function () {sendmessage();});
        $("#connect").click(function () {connect();});
        
    }
);