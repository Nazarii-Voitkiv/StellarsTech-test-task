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

public class a02 extends JFrame implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private float kat;
    private FPSAnimator animator;

    public a02(String string) {
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
        
        // Sun
        gl.glColor3f(1.0f, 1.0f, 0.0f);
        glut.glutSolidSphere(0.2,16,16);

        // Mercury
        gl.glColor3f(1.0f, 0.5f, 0.0f);
        gl.glPushMatrix();
        gl.glRotatef((kat*2.0f) % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.4f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.05,8,8);
        gl.glPopMatrix();

        // Venus
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glPushMatrix();
        gl.glRotatef(kat % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.6f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.1,8,8);
        gl.glPopMatrix();

        // Earth and Moon
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glPushMatrix();
        gl.glRotatef((kat*0.7f) % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(1.2f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.15,12,12);
        
        gl.glColor3f(0.8f, 0.8f, 0.8f);
        gl.glRotatef((kat*2.0f) % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.3f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.03,8,8);
        gl.glPopMatrix();
        
        // Mars and its moons
        gl.glPushMatrix();
        gl.glRotatef((kat*0.5f) % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(1.6f, 0.0f, 0.0f);
        
        gl.glColor3f(0.9f, 0.3f, 0.0f);
        glut.glutSolidSphere(0.12, 10, 10);
        
        gl.glPushMatrix();
        gl.glColor3f(0.7f, 0.7f, 0.6f);  
        gl.glRotatef((kat*3.0f) % 360.0f, 0.0f, 0.0f, 1.0f); 
        gl.glTranslatef(0.2f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.02, 8, 8);  
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.6f, 0.6f, 0.6f); 
        gl.glRotatef((kat*1.5f) % 360.0f, 0.0f, 1.0f, 1.0f); 
        gl.glTranslatef(0.25f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.015, 8, 8); 
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        // Jupiter and its moons
        gl.glPushMatrix();
        gl.glRotatef((kat*0.3f) % 360.0f, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(2.2f, 0.0f, 0.0f);
        
        // Jupiter (largest planet)
        gl.glColor3f(0.9f, 0.8f, 0.6f); // Beige/tan color
        glut.glutSolidSphere(0.25, 16, 16);
        
        // Io (innermost moon)
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 0.9f, 0.4f); // Yellowish
        gl.glRotatef((kat*4.0f) % 360.0f, 0.0f, 0.0f, 1.0f); // Fast orbit
        gl.glTranslatef(0.35f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.03, 8, 8);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.9f, 0.9f, 1.0f); // Whitish
        gl.glRotatef((kat*2.5f) % 360.0f, 0.0f, 0.0f, 1.0f); // Medium orbit speed
        gl.glTranslatef(0.45f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.025, 8, 8);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.7f, 0.7f, 0.7f);
        gl.glRotatef((kat*1.8f) % 360.0f, 0.0f, 0.1f, 1.0f);
        gl.glTranslatef(0.55f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.04, 8, 8);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glColor3f(0.6f, 0.6f, 0.5f);
        gl.glRotatef((kat*1.0f) % 360.0f, 0.0f, 0.2f, 1.0f);
        gl.glTranslatef(0.65f, 0.0f, 0.0f);
        glut.glutSolidSphere(0.035, 8, 8);
        gl.glPopMatrix();
        
        gl.glPopMatrix();
        
        gl.glFlush();
        kat += 1f;
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
                new a02("a02");
            }
        });
    }

}
