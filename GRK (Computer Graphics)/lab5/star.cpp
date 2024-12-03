#include "star.h"

#include <GL/glew.h>

void Star::Initialize(){
const GLfloat kVertices[] = {
    0.0f,  0.0f, 0.0f, 1.0f,  // Punkt centralny

    0.0f,  0.8f, 0.0f, 1.0f,  // Górny wierzcholek zewnêtrzny
    0.2f,  0.2f, 0.0f, 1.0f,  // Prawy górny wierzcholek wewnêtrzny
    0.8f,  0.2f, 0.0f, 1.0f,  // Prawy zewnêtrzny


    0.3f, -0.2f, 0.0f, 1.0f,  // Dolny prawy wierzcholek wewnêtrzny
    0.6f, -1.0f, 0.0f, 1.0f,  // Dolny prawy zewnêtrzny
   -0.0f, -0.5f, 0.0f, 1.0f,  // Dolny wierzcholek wewnêtrzny
   -0.6f, -1.0f, 0.0f, 1.0f,  // Dolny lewy zewnêtrzny
   -0.3f, -0.2f, 0.0f, 1.0f,  // Dolny lewy wierzcholek wewnêtrzny
   -0.8f,  0.2f, 0.0f, 1.0f,  // Lewy zewnêtrzny
   -0.2f,  0.2f, 0.0f, 1.0f,  // Lewy górny wierzcholek wewnêtrzny
    0.0f,  0.8f, 0.0f, 1.0f   // Powrót do górnego wierzcho³ka
};

const GLfloat kColors[] = {
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
    1.0f, 0.0f, 0.0f, 1.0f,
};

    glGenVertexArrays(1, &vao_);
    glBindVertexArray(vao_);

    glGenBuffers(1, &vertex_buffer_);
    glBindBuffer(GL_ARRAY_BUFFER, vertex_buffer_);
    glBufferData(GL_ARRAY_BUFFER, sizeof(kVertices), kVertices, GL_STATIC_DRAW);
    glVertexAttribPointer(0, 4, GL_FLOAT, GL_FALSE, 0, nullptr);
    glEnableVertexAttribArray(0);

    glGenBuffers(1, &color_buffer_);
    glBindBuffer(GL_ARRAY_BUFFER, color_buffer_);
    glBufferData(GL_ARRAY_BUFFER, sizeof(kColors), kColors, GL_STATIC_DRAW);
    glVertexAttribPointer(1, 4, GL_FLOAT, GL_FALSE, 0, nullptr);
    glEnableVertexAttribArray(1);

    glBindBuffer(GL_ARRAY_BUFFER, 0);
    glBindVertexArray(0);

}

Star::~Star(){
    glDisableVertexAttribArray(1);
    glDisableVertexAttribArray(0);

    glBindBuffer(GL_ARRAY_BUFFER, 0);

    glDeleteBuffers(1, &color_buffer_);
    glDeleteBuffers(1, &vertex_buffer_);

    glBindVertexArray(0);
    glDeleteVertexArrays(1, &vao_);
}

void Star::Draw(const Program &program){

    glUseProgram(program);
    glBindVertexArray(vao_);

    glDrawArrays(GL_TRIANGLE_FAN, 0, 12);

    glBindVertexArray(0);
    glUseProgram(0);


}
