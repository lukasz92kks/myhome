#include "light.h"

void Light::setId(String id) {
    this->id = id;
}

String Light::getId() {
    return this->id;
}

void Light::setName(String name) {
    this->name = name;
}

String Light::getName() {
    return this->name;
}

void Light::setOn(bool on) {
    this->on = on;
}

bool Light::isOn() {
    return this->on;
}