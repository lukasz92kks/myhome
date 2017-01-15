#ifndef PIN_H
#define PIN_H
#include <WString.h>
#include "pintype.h"

class Pin {
private:
    PinType type;
    int number;
    int value;

public:
    Pin();
    Pin(PinType type, int number, int value);

    void setType(PinType type);
    PinType getType();
    void setNumber(int number);
    int getNumber();
    void setValue(int value);
    int getValue();
};

#endif