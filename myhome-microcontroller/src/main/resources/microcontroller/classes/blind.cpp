#include "blind.h"

void Blind::setId(String id) {
    this->id = id;
}

String Blind::getId() {
    return this->id;
}

void Blind::setName(String name) {
    this->name = name;
}

String Blind::getName() {
    return this->name;
}

void Blind::setOpen(bool open) {
    this->open = open;
}

bool Blind::isOpen() {
    return this->open;
}