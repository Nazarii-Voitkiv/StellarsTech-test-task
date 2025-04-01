import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class a01 extends JFrame implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private float kat;
    private FPSAnimator animator;

    public a01(String string) {
        super(string);
        GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        GLCanvas canvas=new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        add(canvas);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension d=kit.getScreenSize();
        setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        animator=new FPSAnimator(canvas,60);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        
        gl.glLoadIdentity();
        glu.gluLookAt(0.0f, 2.0f, 10.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        
        gl.glRotatef(kat, 0, 1, 0);
        
        // Floor
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 0.5f); // Gray
            gl.glVertex3f(-2.0f, -1.0f, 2.0f);
            gl.glVertex3f(2.0f, -1.0f, 2.0f);
            gl.glVertex3f(2.0f, -1.0f, -2.0f);
            gl.glVertex3f(-2.0f, -1.0f, -2.0f);
        gl.glEnd();
        
        // Front wall
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.9f, 0.8f, 0.7f); // Light brown
            gl.glVertex3f(-2.0f, -1.0f, 2.0f);
            gl.glVertex3f(2.0f, -1.0f, 2.0f);
            gl.glVertex3f(2.0f, 1.0f, 2.0f);
            gl.glVertex3f(-2.0f, 1.0f, 2.0f);
        gl.glEnd();
        
        // Door (front)
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.6f, 0.3f, 0.1f); // Brown
            gl.glVertex3f(-0.6f, -1.0f, 2.01f);
            gl.glVertex3f(0.6f, -1.0f, 2.01f);
            gl.glVertex3f(0.6f, 0.6f, 2.01f);
            gl.glVertex3f(-0.6f, 0.6f, 2.01f);
        gl.glEnd();
        
        // Door handle
        gl.glBegin(GL2.GL_POINTS);
            gl.glColor3f(0.1f, 0.1f, 0.1f); // Dark
            gl.glPointSize(5.0f);
            gl.glVertex3f(0.4f, -0.2f, 2.02f);
        gl.glEnd();
        
        // Windows (front)
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 1.0f); // Light blue
            gl.glVertex3f(-1.5f, 0.0f, 2.01f);
            gl.glVertex3f(-1.0f, 0.0f, 2.01f);
            gl.glVertex3f(-1.0f, 0.5f, 2.01f);
            gl.glVertex3f(-1.5f, 0.5f, 2.01f);
            
            gl.glVertex3f(1.0f, 0.0f, 2.01f);
            gl.glVertex3f(1.5f, 0.0f, 2.01f);
            gl.glVertex3f(1.5f, 0.5f, 2.01f);
            gl.glVertex3f(1.0f, 0.5f, 2.01f);
        gl.glEnd();
        
        // Back wall
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.9f, 0.8f, 0.7f); // Light brown
            gl.glVertex3f(-2.0f, -1.0f, -2.0f);
            gl.glVertex3f(2.0f, -1.0f, -2.0f);
            gl.glVertex3f(2.0f, 1.0f, -2.0f);
            gl.glVertex3f(-2.0f, 1.0f, -2.0f);
        gl.glEnd();
        
        // Left wall
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.85f, 0.75f, 0.65f); // Slightly different brown
            gl.glVertex3f(-2.0f, -1.0f, -2.0f);
            gl.glVertex3f(-2.0f, -1.0f, 2.0f);
            gl.glVertex3f(-2.0f, 1.0f, 2.0f);
            gl.glVertex3f(-2.0f, 1.0f, -2.0f);
        gl.glEnd();
        
        // Window (left wall)
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 1.0f); // Light blue
            gl.glVertex3f(-2.01f, 0.0f, 0.5f);
            gl.glVertex3f(-2.01f, 0.0f, -0.5f);
            gl.glVertex3f(-2.01f, 0.5f, -0.5f);
            gl.glVertex3f(-2.01f, 0.5f, 0.5f);
        gl.glEnd();
        
        // Right wall
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.85f, 0.75f, 0.65f); // Slightly different brown
            gl.glVertex3f(2.0f, -1.0f, -2.0f);
            gl.glVertex3f(2.0f, -1.0f, 2.0f);
            gl.glVertex3f(2.0f, 1.0f, 2.0f);
            gl.glVertex3f(2.0f, 1.0f, -2.0f);
        gl.glEnd();
        
        // Window (right wall)
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.7f, 0.9f, 1.0f); // Light blue
            gl.glVertex3f(2.01f, 0.0f, 0.5f);
            gl.glVertex3f(2.01f, 0.0f, -0.5f);
            gl.glVertex3f(2.01f, 0.5f, -0.5f);
            gl.glVertex3f(2.01f, 0.5f, 0.5f);
        gl.glEnd();
        
        // Roof (triangular front)
        gl.glBegin(GL2.GL_TRIANGLES);
            gl.glColor3f(0.5f, 0.0f, 0.0f); // Dark red
            gl.glVertex3f(-2.0f, 1.0f, 2.0f);
            gl.glVertex3f(2.0f, 1.0f, 2.0f);
            gl.glVertex3f(0.0f, 2.5f, 2.0f);
        gl.glEnd();
        
        // Roof (triangular back)
        gl.glBegin(GL2.GL_TRIANGLES);
            gl.glColor3f(0.5f, 0.0f, 0.0f); // Dark red
            gl.glVertex3f(-2.0f, 1.0f, -2.0f);
            gl.glVertex3f(2.0f, 1.0f, -2.0f);
            gl.glVertex3f(0.0f, 2.5f, -2.0f);
        gl.glEnd();
        
        // Roof (sides)
        gl.glBegin(GL2.GL_QUADS);
            gl.glColor3f(0.6f, 0.0f, 0.0f); // Red
            gl.glVertex3f(-2.0f, 1.0f, 2.0f);
            gl.glVertex3f(0.0f, 2.5f, 2.0f);
            gl.glVertex3f(0.0f, 2.5f, -2.0f);
            gl.glVertex3f(-2.0f, 1.0f, -2.0f);
            
            gl.glVertex3f(2.0f, 1.0f, 2.0f);
            gl.glVertex3f(0.0f, 2.5f, 2.0f);
            gl.glVertex3f(0.0f, 2.5f, -2.0f);
            gl.glVertex3f(2.0f, 1.0f, -2.0f);
        gl.glEnd();
        
        gl.glFlush();
        
        kat += 0.5f; // Smoother rotation
        if(kat > 360.0f) {
            kat -= 360.0f;
        }
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl=drawable.getGL().getGL2();
        glu=GLU.createGLU(gl);
        glut=new GLUT();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
        gl.glViewport(0, 0, width, height);
        if(height==0)
            height=1;
        float aspect=(float)width/height;
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f,aspect,1.0f,30.0f);
        glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new a01("a01");
            }
        });
    }

}
