#include "pineable.h"

Pineable::Pineable() {
}

Pineable::Pineable(Pin input, Pin output) {
    this->input = input;
    this->output = output;
}

void Pineable::setInput(Pin input) {
    this->input = input;
}

Pin Pineable::getInput() {
    return this->input;
}

void Pineable::setOutput(Pin output) {
    this->output = output;
}

Pin Pineable::getOutput() {
    return this->output;
}