var stompClient = null;
var path = null;
var subscription = null;
function connect() {
    var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);

    stompClient.connect({},
        function (frame) {

 //       path = document.getElementById("RoomSelector");
        path = $("#RoomSelector").val();
        console.log('connected'+frame);
        subscription = stompClient.subscribe('/chat'+path);

 //       stompClient.send('/app/chatroom',{},JSON.stringify({'content':path}));


        });

}

function sendmessage() {
    stompClient.send('/app/chatroom'+path,{},JSON.stringify({'content':$("#textarea").val(),'path':path,'uid':"0"}));
    //console.log("send to : "+'/app/chat'+path);
}

function disconnect() {
    console.log('disconnected0');
    subscription.unsubscribe();
    console.log('disconnected');
    stompClient.disconnect();
}

$(function () {
        $("#send").click(function () {sendmessage();});
        $("#connect").click(function () {connect();});
        $("#disconnect").click(function () {disconnect();});
        
    }
);
