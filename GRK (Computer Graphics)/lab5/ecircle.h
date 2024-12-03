#ifndef ECIRCLE_H
#define ECIRCLE_H

#include <GL/glew.h>

#include "program.h"

class Ecircle{
 public:
    void Initialize();
    ~Ecircle();
    void Draw(const Program & program);
 private:
    GLuint vao_;
    GLuint vertex_buffer_;
    GLuint color_buffer_;
};

#endif // ECIRCLE_H
