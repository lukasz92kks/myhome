#include <Ethernet.h>
#include "classes/myhomeclient.h"
#include "classes/jsonmapper.h"
#include "classes/light.h"

MyHomeClient *myHomeClient;

void setup() {
  Serial.begin(9600);
  myHomeClient = new MyHomeClient();
}

void loop() {
  
  Light light = myHomeClient->getLight("58712c2ec03b240708676513");
  JsonMapper jsonMapper;
  String lightDto = jsonMapper.lightToJson(light);
  Serial.print("LightDTO: ");
  Serial.println(lightDto);

  delay(3000);
}

