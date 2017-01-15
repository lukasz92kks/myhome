#ifndef MYHOMECLIENT_H
#define MYHOMECLIENT_H
#include <WString.h>
#include <SPI.h>
#include "light.h"
#include "jsonmapper.h"

class MyHomeClient {
private:
    RestClient *client;
    JsonMapper jsonMapper;

public:
    MyHomeClient();

    Light getLight(String id);
    //List<Light> getLights(String controllerId);
    void test();

};

#endif