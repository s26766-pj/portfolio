#ifndef ESTAR_H
#define ESTAR_H

#include <GL/glew.h>

#include "program.h"

class Estar{
 public:
    void Initialize();
    ~Estar();
    void Draw(const Program & program);
 private:
    GLuint vao_;
    GLuint vertex_buffer_;
    GLuint color_buffer_;
};

#endif // ESTAR_H
