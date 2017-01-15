#include "pin.h"

Pin::Pin() {
}

Pin::Pin(PinType type, int number, int value) {
    this->type = type;
    this->number = number;
    this->value = value;
}

void Pin::setType(PinType type) {
    this->type = type;
}

PinType Pin::getType() {
    return this->type;
}

void Pin::setNumber(int number) {
    this->number = number;
}

int Pin::getNumber() {
    return this->number;
}

void Pin::setValue(int value) {
    this->value = value;
}

int Pin::getValue() {
    return this->value;
}