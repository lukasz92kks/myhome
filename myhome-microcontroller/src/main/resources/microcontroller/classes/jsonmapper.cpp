#include "jsonmapper.h"

Light JsonMapper::jsonToLight(String json) {
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& object = jsonBuffer.parseObject(json);

    Light light;
    light.setId(object["id"]);
    light.setName(object["name"]);
    light.setOn(object["on"]);

    return light;
}

Blind JsonMapper::jsonToBlind(String json) {
    StaticJsonBuffer<200> jsonBuffer;
    JsonObject& object = jsonBuffer.parseObject(json);

    Blind blind;
    blind.setId(object["id"]);
    blind.setName(object["name"]);
    blind.setOpen(object["open"]);

    return blind;
}

String JsonMapper::lightToJson(Light light) {
    StaticJsonBuffer<200> jsonBuffer;

    JsonObject& object = jsonBuffer.createObject();
    object["id"] = light.getId();
    object["name"] = light.getName();
    object["on"] = light.isOn();

    char json[200];
    object.printTo(json, 200);
    String jsonString(json);
    return jsonString;
}

String JsonMapper::blindToJson(Blind blind) {
    StaticJsonBuffer<200> jsonBuffer;

    JsonObject& object = jsonBuffer.createObject();
    object["id"] = blind.getId();
    object["name"] = blind.getName();
    object["open"] = blind.isOpen();

    char json[200];
    object.printTo(json, 200);
    String jsonString(json);
    return jsonString;
}