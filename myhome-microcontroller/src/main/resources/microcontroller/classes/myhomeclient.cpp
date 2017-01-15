#include "myhomeclient.h"

MyHomeClient::MyHomeClient() {
    client = new RestClient("192.168.88.17", 8080);
    Serial.println("connect to network");
    client->dhcp();
    Serial.println("connected");
}

Light MyHomeClient::getLight(String id) {
    String response;
    String request = "/api/lights/" + id;
    int statusCode = client->get(request.c_str(), &response);

    String dto = response.substring(4, response.length() - 6);
    Serial.print("DTO: '");
    Serial.print(dto);
    Serial.print("'");

    Light light = jsonMapper.jsonToLight(dto);
    return light;
}

//List<Light> MyHomeClient::getLights(String controllerId) {

//}

void MyHomeClient::test() {
    Serial.println("test");
}