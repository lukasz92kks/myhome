#ifndef JSON_MAPPER_H
#define JSON_MAPPER_H
#include <WString.h>
#include "light.h"
#include "blind.h"
#include "RestClient.h"
#include "ArduinoJson.h"

class JsonMapper {
public:
    Light jsonToLight(String json);
    Blind jsonToBlind(String json);

    String lightToJson(Light light);
    String blindToJson(Blind blind);
};

#endif