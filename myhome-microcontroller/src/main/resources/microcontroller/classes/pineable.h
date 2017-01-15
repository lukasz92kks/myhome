#ifndef PINEABLE_H
#define PINEABLE_H
#include <WString.h>
#include "pin.h"

class Pineable {
private:
    Pin input;
    Pin output;

public:
    Pineable();
    Pineable(Pin input, Pin output);

    void setInput(Pin input);
    Pin getInput();
    void setOutput(Pin output);
    Pin getOutput();
};

#endif