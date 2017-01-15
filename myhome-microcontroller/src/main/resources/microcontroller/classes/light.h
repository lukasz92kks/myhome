#ifndef LIGHT_H
#define LIGHT_H
#include <WString.h>
#include "pineable.h"

class Light : public Pineable {
private:
    String id;
    String name;
    bool on;

public:
    void setId(String id);
    String getId();
    void setName(String name);
    String getName();
    void setOn(bool on);
    bool isOn();
};

#endif