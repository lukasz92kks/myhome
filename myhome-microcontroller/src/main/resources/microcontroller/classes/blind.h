#ifndef BLIND_H
#define BLIND_H
#include <WString.h>
#include "pineable.h"

class Blind : public Pineable {
private:
    String id;
    String name;
    bool open;

public:
    void setId(String id);
    String getId();
    void setName(String name);
    String getName();
    void setOpen(bool open);
    bool isOpen();
};

#endif